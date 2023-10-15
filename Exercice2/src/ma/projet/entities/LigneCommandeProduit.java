/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author hp
 */
@Entity
public class LigneCommandeProduit {

    @EmbeddedId
    private ProduitCommandeKey id;
    @JoinColumn(name = "commande", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Commande commande;
    @JoinColumn(name = "produit", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Produit produit;

    private int quantité;

    public LigneCommandeProduit() {
    }
    

    public LigneCommandeProduit(ProduitCommandeKey id, int quantité) {
        this.id = id;
      
        this.quantité = quantité;
    }
    
   

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public int getQuantité() {
        return quantité;
    }

    public ProduitCommandeKey getId() {
        return id;
    }

    public Commande getCommande() {
        return commande;
    }

    public Produit getProduit() {
        return produit;
    }

}
