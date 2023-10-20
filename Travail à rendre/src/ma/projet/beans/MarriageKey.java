/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class MarriageKey implements Serializable {
    private int femme;
    private int homme;

    public MarriageKey(){}
    public MarriageKey(int femme, int homme) {
        this.femme = femme;
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }
    
}
