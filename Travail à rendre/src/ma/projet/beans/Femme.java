/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author hp
 */
@Entity
public class Femme extends Personne {
    @OneToMany(mappedBy = "femme")
    private List<Marriage> mariage;
    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, String adress, Date dateNaissance) {
        super(nom, prenom, telephone, adress, dateNaissance);
    }
    
    
}
