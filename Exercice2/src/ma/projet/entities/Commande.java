/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Commande {
     @Id
     @GeneratedValue
     private int id;
      @Temporal(javax.persistence.TemporalType.DATE)
     private Date date;
      @OneToMany(mappedBy="commande")
      private List<LigneCommandeProduit> ligneCommande;
    
    public Commande(Date date) {
        this.date = date;
    }

    public List<LigneCommandeProduit> getLigneCommande() {
        return ligneCommande;
    }

    

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
