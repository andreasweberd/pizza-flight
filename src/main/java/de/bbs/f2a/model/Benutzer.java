package de.bbs.f2a.model;

import java.util.Date;

public class Benutzer
{
  public int getId()
  {
    return id;
  }

  public void setId( final int id )
  {
    this.id = id;
  }

  public String getVorname()
  {
    return vorname;
  }

  public void setVorname( final String vorname )
  {
    this.vorname = vorname;
  }

  public String getNachname()
  {
    return nachname;
  }

  public void setNachname( final String nachname )
  {
    this.nachname = nachname;
  }

  public Date getBenutzerseit()
  {
    return benutzerseit;
  }

  public void setBenutzerseit( final Date benutzerseit )
  {
    this.benutzerseit = benutzerseit;
  }

  public String getNickname()
  {
    return nickname;
  }

  public void setNickname( final String nickname )
  {
    this.nickname = nickname;
  }

  int id;
  String vorname;
  String nachname;
  Date benutzerseit;

  String nickname;

  public String toString(){
    return id + " " + nickname;
  }
}
