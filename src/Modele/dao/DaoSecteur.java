/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele.dao;

import Modele.metier.Secteur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author btssio
 */
public class DaoSecteur {
    //Récupérer un secteur d'après son id
     public static Secteur selectOne(String codeSec) throws SQLException {
        Secteur unSecteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeSec);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String libelleSec = rs.getString("SEC_LIBELLE");
            unSecteur = new Secteur(codeSec, libelleSec);
        }
        return unSecteur;
    }
     
    //Récupérer tous les secteurs
    public static List<Secteur> selectAll() throws SQLException {
        List<Secteur> lesSecteurs = new ArrayList<Secteur>();
        Secteur unSecteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String codeSec = rs.getString("SEC_CODE");
            String libelleSec = rs.getString("SEC_LIBELLE");
            unSecteur = new Secteur(codeSec, libelleSec);
            lesSecteurs.add(unSecteur);
        }
        return lesSecteurs;
    }
}
