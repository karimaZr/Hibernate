/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Marriage {
    @EmbeddedId
    private MarriageKey id;
    @JoinColumn(name = "homme", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Homme homme;
    @JoinColumn(name = "femme", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Femme femme;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    private Date dateFin;
    private int nbrEnfant;
    public Marriage(){}

    public Marriage(MarriageKey id,Date dateDebut, Date dateFin, int nbrEnfant) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.id=id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }
    
}
