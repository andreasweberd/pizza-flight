package de.bbs.f2a;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import de.bbs.f2a.model.Auth;
import de.bbs.f2a.model.Benutzer;
import de.bbs.f2a.model.Benutzer_Spiel;
import de.bbs.f2a.model.Spiel;

@Singleton
public class DataService {

    @Inject
    DataSource dataSource;

    public List<Auth> getAuthData() {
        List<Auth> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                final ResultSet query = stmt.executeQuery("SELECT * FROM auth");
                while (query.next()) {
                    result.add(authFromQuery(query));
                }
            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
        return result;
    }

    public List<Benutzer> getBenutzerData() {
        List<Benutzer> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                final ResultSet query = stmt.executeQuery("SELECT * FROM benutzer");
                while (query.next()) {
                    result.add(benutzerFromQuery(query));
                }
            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
        return result;
    }


    public Benutzer getBenutzerData(String nickname) {

        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement p = connection.prepareStatement("SELECT * FROM benutzer where nickname = ?");
            p.setString(1, nickname);
            final ResultSet query = p.executeQuery();
            while (query.next()) {
                return benutzerFromQuery(query);
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }

        return null;
    }

    public List<Benutzer_Spiel> getBenutzerToSpiel() {
        List<Benutzer_Spiel> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                final ResultSet query = stmt.executeQuery("SELECT * FROM benutzer_spiel");
                while (query.next()) {
                    Benutzer_Spiel b = new Benutzer_Spiel();
                    b.setBenutzid(query.getInt("benutzid"));
                    b.setSpielid(query.getInt("spielid"));

                    result.add(b);
                }
            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
        return result;
    }

    public List<Spiel> getSpielData() {
        List<Spiel> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement stmt = connection.createStatement()) {
                final ResultSet query = stmt.executeQuery("SELECT * FROM spiel");
                while (query.next()) {
                    result.add(spielFromQuery(query));
                }
            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
        return result;
    }

    public List<Auth> getAuthData(final Benutzer b) {
        final List<Auth> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement p = connection.prepareStatement("SELECT * FROM auth where benutzid = ?");
            p.setInt(1, b.getId());
            final ResultSet query = p.executeQuery();
            while (query.next()) {
                result.add(authFromQuery(query));
            }
        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
        return result;
    }

    public String getHash(final String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    private static Benutzer benutzerFromQuery(ResultSet query) throws SQLException {
        final Benutzer b = new Benutzer();
        b.setId(query.getInt("id"));
        b.setVorname(query.getString("vorname"));
        b.setNachname(query.getString("nachname"));
        b.setBenutzerseit(query.getDate("benutzer_seit"));
        b.setNickname(query.getString("nickname"));
        return b;
    }

    private static Auth authFromQuery(ResultSet query) throws SQLException {
        final Auth a = new Auth();
        a.setId(query.getInt("id"));
        a.setGesperrt(query.getBoolean("gesperrt"));
        a.setEmail(query.getString("email"));
        a.setPassword(query.getString("passwort"));
        a.setBenutzid(query.getInt("benutzid"));
        return a;
    }

    private static Spiel spielFromQuery(ResultSet query) throws SQLException {
        final Spiel s = new Spiel();
        s.setId(query.getInt("id"));
        s.setErscheinungsdatum(query.getDate("erscheinungsdatum"));
        s.setName(query.getString("name"));
        s.setPfad(query.getString("pfad"));
        return s;
    }
}
