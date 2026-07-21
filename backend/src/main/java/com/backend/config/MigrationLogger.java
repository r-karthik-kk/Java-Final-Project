package com.backend.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrationLogger implements CommandLineRunner {

    private final Flyway flyway;

    public MigrationLogger(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(String... args) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("         DATABASE MIGRATIONS");
        System.out.println("========================================");

        MigrationInfo current = flyway.info().current();

        if (current == null) {
            System.out.println("Current Version : Empty Database");
        } else {
            System.out.println("Current Version : V" + current.getVersion());
            System.out.println("Description     : " + current.getDescription());
        }

        System.out.println("----------------------------------------");

        MigrationInfo[] pending = flyway.info().pending();

        if (pending.length == 0) {

            System.out.println("Status : Database is up to date.");

        } else {

            System.out.println("Pending Migrations :");

            for (MigrationInfo migration : pending) {

                System.out.println(" -> V"
                        + migration.getVersion()
                        + " : "
                        + migration.getDescription());

            }

        }

        System.out.println("========================================");
        System.out.println();

    }

}