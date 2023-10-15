/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hp
 */
@Entity
public class Catégorie {

    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String libelle;
    @OneToMany(mappedBy = "catégorie", fetch = FetchType.EAGER)
    private List<Produit> produits;

    

    public Catégorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setProduit(List<Produit> produits) {
        this.produits = produits;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Produit> getProduits() {
        return produits;
    }

}
