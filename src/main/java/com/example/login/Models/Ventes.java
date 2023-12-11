package com.example.login.Models;

public class Ventes {
    private int id;
    private String nomDeProduct;
    private String quantite;
    private double prix;
    private String dateVentre;
    private String client;

    public Ventes() {
    }
    

    public Ventes(int id, String nomDeProduct, String quantite, double prix, String dateVentre, String client) {
        this.id = id;
        this.nomDeProduct = nomDeProduct;
        this.quantite = quantite;
        this.prix = prix;
        this.dateVentre = dateVentre;
        this.client = client;
    }

    public Ventes(String nomDeProduct, String quantite, double prix, String dateVentre, String client) {
        this.nomDeProduct = nomDeProduct;
        this.quantite = quantite;
        this.prix = prix;
        this.dateVentre = dateVentre;
        this.client = client;
    }

    public Ventes(String nomDeProduct, String quantite, String prix, String dateVentre, String client) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDeProduct() {
        return nomDeProduct;
    }

    public void setNomDeProduct(String nomDeProduct) {
        this.nomDeProduct = nomDeProduct;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDateVentre() {
        return dateVentre;
    }

    public void setDateVentre(String dateVentre) {
        this.dateVentre = dateVentre;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
