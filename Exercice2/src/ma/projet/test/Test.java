/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import ma.projet.entities.Produit;
import ma.projet.entities.Catégorie;
import ma.projet.service.CatégorieService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;
import ma.projet.entities.Produit;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.ProduitCommandeKey;
import ma.projet.service.ProduitService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.util.HibernateUtil;

import org.hibernate.Session;

/**
 *
 * @author Lachgar
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        CatégorieService cs = new CatégorieService();
        ProduitService css = new ProduitService();
        CommandeService commandeservice=new CommandeService();
         LigneCommandeService LigneCommandeservice=new LigneCommandeService();
         
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2023-01-15");
        
        Catégorie cat=new Catégorie("314FF","pc portable"); 
        cs.create(cat);
        // Create Produit instances
        Produit produit1 = new Produit("Ref 1", 12.0f,cat);
        Produit produit2 = new Produit("Ref 2", 14.0f,cat);
        css.create(produit2);
        css.create(produit1);

// Create Commande instance
        Commande commande = new Commande(date1);
        System.out.println(commande.getId());
        ProduitCommandeKey key = new ProduitCommandeKey(produit1.getId(), commande.getId()+1);
        ProduitCommandeKey key2 = new ProduitCommandeKey(produit2.getId(), commande.getId()+1);
        commandeservice.create(commande);
// Create LigneCommandeProduit instances
       LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit(key,50);
       LigneCommandeProduit ligneCommandeProduit2 = new LigneCommandeProduit(key2,60);   
       LigneCommandeservice.create(ligneCommandeProduit);
       LigneCommandeservice.create(ligneCommandeProduit2);
            

    }
   

}
