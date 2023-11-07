package org.example;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.database.entities.Client;
import org.example.database.entities.Planet;
import org.example.database.repositories.ClientCrud;
import org.example.database.repositories.PlanetCrud;
import org.example.database.utils.FlywayMigration;
import org.example.database.utils.HibernateUtil;

public class App {

    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("The program has started");

        FlywayMigration.migrateDatabase();

        ClientCrud clientCrud = new ClientCrud();

        Client newClient = new Client();
        newClient.setName("Oleg");
        clientCrud.persist(newClient);

        Client client = clientCrud.getById(2L);

        client.setName("Ros");

        clientCrud.merge(client);

        clientCrud.remove(client);


        PlanetCrud planetCrud = new PlanetCrud();

        Planet newPlanet = new Planet();
        newPlanet.setId("NEP");
        newPlanet.setName("Neptune");
        planetCrud.persist(newPlanet);

        Planet planet = planetCrud.getById("SAT");

        planet.setId("EAR");
        planet.setName("Earth");
        planetCrud.merge(planet);

        planetCrud.remove(planet);

        HibernateUtil.getInstance().close();

        LOG.info("The program has finished");
    }
}