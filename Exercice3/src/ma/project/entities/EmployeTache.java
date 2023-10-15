
package ma.project.entities;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EmployeTache {

    @EmbeddedId
    private EmployeTachekey id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelle;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinReelle;

    @JoinColumn(name = "employe", insertable = false, updatable = false)
    @ManyToOne
    private Employe employe;

    @JoinColumn(name = "tache", insertable = false, updatable = false)
    @ManyToOne
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        EmployeTachekey id = new EmployeTachekey(employe.getId(),tache.getId());
        this.id = id;
        this.dateFinReelle = dateFinReelle;
        this.dateDebutReelle = dateDebutReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachekey getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + ", employe=" + employe + ", tache=" + tache + '}';
    }

    public void setId(EmployeTachekey id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

   
   

}
