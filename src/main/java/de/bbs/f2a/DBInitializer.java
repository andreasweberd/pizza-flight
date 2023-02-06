package de.bbs.f2a;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.sql.DataSource;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DBInitializer {


    @Inject
    DataSource dataSource;

    void onStart(@Observes StartupEvent ev) {
        initdb();
    }

    private void initdb() {
        System.out.println("Init DB");
        try (Connection connection = dataSource.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE users (name VARCHAR(255), password VARCHAR(255))");
                stmt.execute("INSERT INTO users(name, password) VALUES ('peter', '8J+NlfCfjZXwn42VIFN1cGVyIGdlaGVpbWVyIFRleHQg8J+NlfCfjZXwn42V')");
            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
    }
}