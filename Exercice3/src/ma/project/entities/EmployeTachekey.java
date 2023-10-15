package ma.project.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 *
 * @author hp 
 */
@Embeddable
public class EmployeTachekey implements Serializable {

   
    private int employe;
    private int tache;

    public EmployeTachekey() {
    }

    public EmployeTachekey(int employe, int tache) {
        this.employe = employe;
        this.tache = tache;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }

   
}
