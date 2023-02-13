package de.bbs.f2a.model;

public class Auth
{
  public int getId()
  {
    return id;
  }

  public void setId( final int id )
  {
    this.id = id;
  }

  public int getBenutzid()
  {
    return benutzid;
  }

  public void setBenutzid( final int benutzid )
  {
    this.benutzid = benutzid;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword( final String password )
  {
    this.password = password;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( final String email )
  {
    this.email = email;
  }

  public boolean isGesperrt()
  {
    return gesperrt;
  }

  public void setGesperrt( final boolean gesperrt )
  {
    this.gesperrt = gesperrt;
  }

  int id;
  int benutzid;
  String password;
  String email;
  boolean gesperrt = false;



  public String toString(){
    return id + " " + email + " " + password;
  }
}
