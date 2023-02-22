package de.bbs.f2a;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DBInitializer
{

  @Inject DataSource dataSource;
  @Inject DataService dataService;

  void onStart( @Observes StartupEvent ev )
  {
    initdb();
    initUserAuth();
  }

  @Transactional()
  public void initUserAuth()
  {
    try ( Connection connection = dataSource.getConnection() )
    {
      PreparedStatement p = connection.prepareStatement( "INSERT INTO benutzer (name, vorname, nickname, benutzer_seit) VALUES (?,?,?,?)" );
      p.setString( 1, "dummy" );
      p.setString( 2, "dummy" );
      p.setString( 3, "dummy" );
      p.setDate( 4, new Date( new java.util.Date().getTime() ) );
      p.executeUpdate();

      System.out.println( dataService.getBenutzerData() );
      PreparedStatement p2 = connection.prepareStatement( "INSERT INTO auth (benutzid, passwort, email) VALUES (?,?,?)" );
      p2.setInt( 1, dataService.getBenutzerData("dummy").getId());
      p2.setString( 2, dataService.getHash( "dummy" ) );
      p2.setString( 3, "dummy@dummy.de" );
      p2.executeUpdate();
    }
    catch ( SQLException e )
    {
      System.out.println( "Error processing connection " + e );
    }
  }

  @Transactional
  public void initdb()
  {
    System.out.println( "Init DB" );
    try ( Connection connection = dataSource.getConnection() )
    {
      try ( Statement stmt = connection.createStatement() )
      {
        stmt.execute( "CREATE TABLE spiel (id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY, erscheinungsdatum date, "
            + "name VARCHAR(255), pfad VARCHAR(255))" );

        stmt.execute( "CREATE TABLE benutzer (id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY, name VARCHAR(255), "
            + "vorname VARCHAR(255), nachname VARCHAR(255), benutzer_seit date, nickname VARCHAR(255) unique not null)" );
        stmt.execute(
            "CREATE TABLE auth (id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY, benutzid int, " + "passwort VARCHAR(255), email VARCHAR(255),"
                + "gesperrt boolean, "
                + "foreign key (benutzid) references benutzer(id))" );

        stmt.execute( "CREATE TABLE benutzer_spiel (benutzid int, spielid int," + " foreign key (benutzid) references benutzer(id),"
            + "foreign key (spielid) references spiel(id))" );

      }
      catch ( SQLException e )
      {
        System.out.println( "Error processing statement " + e );
      }
    }
    catch ( SQLException e )
    {
      System.out.println( "Error processing connection " + e );
    }
  }
}
