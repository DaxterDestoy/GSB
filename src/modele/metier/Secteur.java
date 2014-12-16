/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

/**
 *
 * @author btssio
 */
public class Secteur {
    private String codeSec;
    private String libelleSec;

    public Secteur(String codeSec, String libelleSec) {
        this.codeSec = codeSec;
        this.libelleSec = libelleSec;
    }

    public String getCodeSec() {
        return codeSec;
    }

    public void setCodeSec(String codeSec) {
        this.codeSec = codeSec;
    }

    public String getLibelleSec() {
        return libelleSec;
    }

    public void setLibelleSec(String libelleSec) {
        this.libelleSec = libelleSec;
    }

    @Override
    public String toString() {
        return "Secteur{" + "codeSec=" + codeSec + ", libelleSec=" + libelleSec + '}';
    }
    
    
}
