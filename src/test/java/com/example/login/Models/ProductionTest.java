package com.example.login.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductionTest {

    @Test
    public void testProductionConstructorWithAllParameters() {
        Production production = new Production(1, 100, "Race", "50", "Final", 10.5, "2023-01-01",
                "John Doe", "Supplier", "Origin");

        assertEquals(1, production.getId());
        assertEquals("100", production.getMetrage());
        assertEquals("Race", production.getNom_de_race());
        assertEquals("50", production.getQuantite());
        assertEquals("Final", production.getQantite_Finale());
        assertEquals("10.5", production.getPrix());
        assertEquals("2023-01-01", production.getDate_dentre());
        assertEquals("John Doe", production.getNom_de_lemploye());
        assertEquals("Supplier", production.getNom_de_fournisseur());
        assertEquals("Origin", production.getOrigine());
    }

    @Test
    public void testProductionSettersAndGetters() {
        Production production = new Production();

        production.setId(2);
        assertEquals(2, production.getId());

        production.setMetrage(200);
        assertEquals("200", production.getMetrage());

        production.setNom_de_race("New Race");
        assertEquals("New Race", production.getNom_de_race());

        production.setQuantite("75");
        assertEquals("75", production.getQuantite());

        production.setQantite_Finale("New Final");
        assertEquals("New Final", production.getQantite_Finale());

        production.setPrix(15.75);
        assertEquals("15.75", production.getPrix());

        production.setDate_dentre("2023-02-02");
        assertEquals("2023-02-02", production.getDate_dentre());

        production.setNom_de_lemploye("Jane Smith");
        assertEquals("Jane Smith", production.getNom_de_lemploye());

        production.setNom_de_fournisseur("New Supplier");
        assertEquals("New Supplier", production.getNom_de_fournisseur());

        production.setOrigine("New Origin");
        assertEquals("New Origin", production.getOrigine());
    }
}
