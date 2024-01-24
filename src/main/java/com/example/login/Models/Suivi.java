package com.example.login.Models;

public class Suivi {
    private int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantite_par_jour() {
        return quantite_par_jour;
    }

    public void setQuantite_par_jour(String quantite_par_jour) {
        this.quantite_par_jour = quantite_par_jour;
    }

    public String getConsomation() {
        return consomation;
    }

    public void setConsomation(String consomation) {
        this.consomation = consomation;
    }

    public String getDate_mise_a_jour() {
        return date_mise_a_jour;
    }

    public void setDate_mise_a_jour(String date_mise_a_jour) {
        this.date_mise_a_jour = date_mise_a_jour;
    }

    private String quantite_par_jour;
    private String consomation;
    private String date_mise_a_jour;

    public String getEmploiyee() {
        return emploiyee;
    }

    public void setEmploiyee(String emploiyee) {
        this.emploiyee = emploiyee;
    }

    private String emploiyee;



    public Suivi( int id,String quantite_par_jour, String date_mise_a_jour,String consomation,String emploiyee){
        this.id = id;
        this.quantite_par_jour=quantite_par_jour;
        this.consomation=consomation;
        this.date_mise_a_jour = date_mise_a_jour;
        this.emploiyee=emploiyee;
    }

    public Suivi(String quantite_par_jour, String date_mise_a_jour,String consomation,String emploiyee){
        this.quantite_par_jour=quantite_par_jour;
        this.consomation=consomation;
        this.date_mise_a_jour = date_mise_a_jour;
        this.emploiyee=emploiyee;

    }
}
