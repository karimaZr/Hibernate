/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.entities.Produit;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class Test {

    public static void main(String[] args) {
        // Initialize Hibernate
        HibernateUtil.getSessionFactory(); // Ensure Hibernate is properly initialized

        // Create ProduitService instance
        ProduitService produitService = new ProduitService();

        try {
            // 1. Créer cinq produits
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse("2023-01-15");
            Date date2 = sdf.parse("2023-02-20");
            Date date3 = sdf.parse("2023-03-10");
            Date date4 = sdf.parse("2023-04-05");
            Date date5 = sdf.parse("2023-05-12");

            Produit produit1 = new Produit("Marque 1", "Ref 1", date1, 12, "Designation 1");
            Produit produit2 = new Produit("Marque 2", "Ref 2", date2, 14, "Designation 2");
            Produit produit3 = new Produit("Marque 3", "Ref 3", date3, 16, "Designation 3");
            Produit produit4 = new Produit("Marque 4", "Ref 4", date4, 18, "Designation 4");
            Produit produit5 = new Produit("Marque 5", "Ref 5", date5, 355, "Designation 5");

            produitService.create(produit1);
            produitService.create(produit2);
            produitService.create(produit3);
            produitService.create(produit4);
            produitService.create(produit5);

            // 2. Afficher la liste des produits
            List<Produit> produits = produitService.findAll();
            System.out.println("Liste des produits :");
            for (Produit produit : produits) {
                System.out.println(produit);
            }

            // 3. Afficher les informations du produit dont id = 2
            int prod = 2;
            Produit produitById = produitService.findById(prod);
            System.out.println("\nInformations du produit avec id = " + prod + ":");
            System.out.println(produitById);

            // 4. Supprimer le produit dont id = 3
            int d = 3;
            Produit produitToDelete = produitService.findById(d);
            if (produitToDelete != null) {
                produitService.delete(produitToDelete);
                System.out.println("\nLe produit avec id = " + d + " a été supprimé.");
            } else {
                System.out.println("\nLe produit avec id = " + d + " n'a pas été trouvé.");
            }

            // 5. Modifier les informations du produit dont id = 1
            int productIdToUpdate = 1;
            Produit produitToUpdate = produitService.findById(productIdToUpdate);
            if (produitToUpdate != null) {
                produitToUpdate.setMarque("Nouvelle marque du produit 1");
                produitToUpdate.setPrix(175.0);
                produitService.update(produitToUpdate);
                System.out.println("\nLes informations du produit avec id = " + productIdToUpdate + " ont été mises à jour.");
            } else {
                System.out.println("\nLe produit avec id = " + productIdToUpdate + " n'a pas été trouvé.");
            }

            // 6. Afficher la liste des produits dont le prix est supérieur à 100 DH
            List<Produit> expensiveProducts = produitService.findProductsAbovePrice(100.0);
            System.out.println(" produits dont le prix est supérieur à  100 DH:");
            for (Produit produit : expensiveProducts) {
                System.out.println(produit);
            }

            // 7. Afficher la liste des produits commandés entre deux dates lues au clavier
            // Define your start and end dates here


List<Produit> productsOrderedBetweenDates = produitService.findProductsOrderedBetweenDates(date2, date4);
            System.out.println("Products ordered between " + date2 + " and " + date4 + ":");
            for (Produit produit : productsOrderedBetweenDates) {
                System.out.println(produit);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
