/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
/**
 *
 * @author hp
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id
    @GeneratedValue
    protected int id;
    protected String nom;
    protected String prenom;
    protected String telephone;
    protected String adress;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateNaissance;

    public int getId() {
        return id;
    }
    public Personne(){
    }

    public Personne(String nom, String prenom, String telephone, String adress, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adress = adress;
        this.dateNaissance = dateNaissance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    
}
