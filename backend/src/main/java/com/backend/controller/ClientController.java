package com.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.backend.dto.ClientRequest;
import com.backend.service.ClientService;



@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins="http://localhost:5173")
public class ClientController {



private final ClientService service;



public ClientController(
        ClientService service
){

    this.service = service;

}




@PostMapping("/register")
public ResponseEntity<String> register(
        @RequestBody ClientRequest request
){

    return ResponseEntity.ok(
            service.register(request)
    );

}


}