/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author hp
 */
@Entity
@NamedNativeQuery(name="betweenDates",query="select distinct p from Produit p join fetch p.commandes c where c.date between :startDate and :endDate",resultClass =Produit.class)
public class Produit {
@Id
@GeneratedValue
private int id;
private String reference;
private float prix;
@Temporal(javax.persistence.TemporalType.DATE)

@ManyToOne
private Catégorie catégorie;
 @OneToMany(mappedBy="produit")
 private List<LigneCommandeProduit> ligneCommande;

    public Produit( String reference, float prix,Catégorie categorie) {
        
        this.reference = reference;
        this.prix = prix; 
        this.catégorie=categorie;
       
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    

    public void setcatégorie(Catégorie catégorie) {
        this.catégorie = catégorie;
    }

    public int getId() {
        return id;
    }

  

    public String getReference() {
        return reference;
    }

    public float getPrix() {
        return prix;
    }

   

    public Catégorie getcatégorie() {
        return catégorie;
    }

}

