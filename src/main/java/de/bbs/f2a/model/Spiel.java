package de.bbs.f2a.model;

import java.util.Date;

public class Spiel
{
    int id;
    Date erscheinungsdatum;

    String name;

    String pfad;

    public int getId()
    {
        return id;
    }

    public void setId( final int id )
    {
        this.id = id;
    }

    public Date getErscheinungsdatum()
    {
        return erscheinungsdatum;
    }

    public void setErscheinungsdatum( final Date erscheinungsdatum )
    {
        this.erscheinungsdatum = erscheinungsdatum;
    }

    public String getName()
    {
        return name;
    }

    public void setName( final String name )
    {
        this.name = name;
    }

    public String getPfad()
    {
        return pfad;
    }

    public void setPfad( final String pfad )
    {
        this.pfad = pfad;
    }
}
