package com.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.dto.ClientRequest;
import com.backend.entity.Client;
import com.backend.entity.ClientType;
import com.backend.repository.ClientRepository;
import com.backend.repository.ClientTypeRepository;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientTypeRepository typeRepository;

    private final PasswordEncoder encoder;

    public ClientService(
            ClientRepository repository,
            ClientTypeRepository typeRepository,
            PasswordEncoder encoder
    ) {

        this.repository = repository;
        this.typeRepository = typeRepository;
        this.encoder = encoder;

    }

    public String register(
            ClientRequest request
    ) {

        if (repository.existsByClientId(
                request.getClientId()
        )) {

            return "Client ID already exists";

        }

        if (repository.existsByEmail(
                request.getEmail()
        )) {

            return "Email already registered";

        }

        ClientType clientType =
                typeRepository
                        .findById(
                                request.getClientTypeId()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Client type not found"
                                )
                        );

        Client client = new Client();

        client.setClientId(
                request.getClientId()
        );

        client.setName(
                request.getName()
        );

        client.setEmail(
                request.getEmail()
        );

        client.setMobileNumber(
                request.getMobileNumber()
        );

        client.setPassword(
                encoder.encode(
                        request.getPassword()
                )
        );

        client.setClientType(
                clientType
        );

        client.setAbout(
                request.getAbout()
        );

        repository.save(client);

        return "Client registered successfully";

    }

}