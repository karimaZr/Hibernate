/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Client;
import ma.projet.entities.Commande;
import ma.projet.service.ClientService;
import ma.projet.service.CommandeService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;

/**
 *
 * @author Lachgar
 */
public class Test {
    
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        CommandeService css = new CommandeService();
        
        //cs.create(new Client("XS34", new Date()));
        //cs.delete(cs.findById(2));
       // for(Client c : cs.findAll(null))
         //   System.out.println(c);
        
   //     css.create(new Commande("c23", new Date(), cs.findById(1)));
     //   css.create(new Commande("c22", new Date(), cs.findById(1)));
       // css.create(new Commande("c21", new Date(), cs.findById(3)));
        
        for(Commande c : cs.findById(1).getCommandes())
            System.out.println(c.getCode());
        
    }
    
}
