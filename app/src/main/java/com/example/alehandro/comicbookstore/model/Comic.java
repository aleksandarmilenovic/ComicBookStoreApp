package com.example.alehandro.comicbookstore.model;

/**
 * Created by alehandro on 1.12.17..
 */

public class Comic {

    private String name;
    private String slikaURL;
    private String godina;
    private String opis;
    private String cena;

    public Comic(String name, String slikaURL, String godina, String opis, String cena) {
        this.name = name;
        this.slikaURL = slikaURL;
        this.godina = godina;
        this.opis = opis;
        this.cena = cena;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlikaURL(String slikaURL) {
        this.slikaURL = slikaURL;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getName() {
        return name;
    }

    public String getSlikaURL() {
        return slikaURL;
    }

    public String getGodina() {
        return godina;
    }

    public String getOpis() {
        return opis;
    }

    public String getCena() {
        return cena;
    }
}
