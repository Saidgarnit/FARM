package com.example.login.Models;

public class Production {
    private int id ;

    private int metrage;
    private String Nom_de_race;
    private String Quantite;
    private String Qantite_Finale;
    private double Prix;
    private String Date_dentre;
    private String Nom_de_lemploye;
    private String Nom_de_fournisseur;
    private String origine;

    public Production() {
    }

    public Production(int id, int metrage, String nom_de_race, String quantite, String qantite_Finale, double prix, String date_dentre, String nom_de_lemploye, String nom_de_fournisseur, String origine) {
        this.id = id;
        this.metrage = metrage;
        this.Nom_de_race = nom_de_race;
        this.Quantite = quantite;
        this.Qantite_Finale = qantite_Finale;
        this.Prix = prix;
        this.Date_dentre = date_dentre;
        this.Nom_de_lemploye = nom_de_lemploye;
        this.Nom_de_fournisseur = nom_de_fournisseur;
        this.origine = origine;

    }

    public Production(int metrage, String nom_de_race, String quantite, String qantite_Finale, double prix, String date_dentre, String nom_de_lemploye, String nom_de_fournisseur, String origine) {
        this.metrage = metrage;
        this.Nom_de_race = nom_de_race;
        this.Quantite = quantite;
        this.Qantite_Finale = qantite_Finale;
        this.Prix = prix;
        this.Date_dentre = date_dentre;
        this.Nom_de_lemploye = nom_de_lemploye;
        this.Nom_de_fournisseur = nom_de_fournisseur;
        this.origine = origine;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetrage() {
        return String.valueOf(metrage);
    }

    public void setMetrage(int metrage) {
        this.metrage = metrage;
    }

    public String getNom_de_race() {
        return Nom_de_race;
    }

    public void setNom_de_race(String nom_de_race) {
        Nom_de_race = nom_de_race;
    }

    public String getQuantite() {
        return Quantite;
    }

    public void setQuantite(String quantite) {
        Quantite = quantite;
    }

    public String getQantite_Finale() {
        return Qantite_Finale;
    }

    public void setQantite_Finale(String qantite_Finale) {
        Qantite_Finale = qantite_Finale;
    }

    public String getPrix() {
        return String.valueOf(Prix);
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public String getDate_dentre() {
        return Date_dentre;
    }

    public void setDate_dentre(String date_dentre) {
        Date_dentre = date_dentre;
    }

    public String getNom_de_lemploye() {
        return Nom_de_lemploye;
    }

    public void setNom_de_lemploye(String nom_de_lemploye) {
        Nom_de_lemploye = nom_de_lemploye;
    }

    public String getNom_de_fournisseur() {
        return Nom_de_fournisseur;
    }

    public void setNom_de_fournisseur(String nom_de_fournisseur) {
        Nom_de_fournisseur = nom_de_fournisseur;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }
}
