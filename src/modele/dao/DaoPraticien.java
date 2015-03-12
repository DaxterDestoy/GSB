/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Praticien;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class DaoPraticien {
    //Récupérer un praticien d'après son id
     public static Praticien selectOne(String numPrat) throws SQLException {
        Praticien unPraticien = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PRATICIEN WHERE PRA_NUM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, numPrat);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nomPrat = rs.getString("PRA_NOM");
            String prenomPrat = rs.getString("PRA_PRENOM");
            String adressePrat = rs.getString("PRA_ADRESSE");
            String cpPrat = rs.getString("PRA_CP");
            String villePrat = rs.getString("PRA_VILLE");
            String coefNotoriete = rs.getString("PRA_COEFNOTORIETE");
            String typePraticien = rs.getString("TYP_CODE");
            
            unPraticien = new Praticien(numPrat, nomPrat, prenomPrat, adressePrat, cpPrat, villePrat, coefNotoriete, typePraticien);
        }
        return unPraticien;
    }
     
    //Récupérer tous les secteurs
    public static List<Praticien> selectAll() throws DaoException {
        List<Praticien> lesPraticiens = new ArrayList<Praticien>();
        Praticien unPraticien;
        ResultSet rs;
        try {
            PreparedStatement pstmt;
            Jdbc jdbc = Jdbc.getInstance();
            // préparer la requête
            String requete = "SELECT * FROM PRATICIEN";
            pstmt = jdbc.getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String numPrat = rs.getString("PRA_NUM");
                String nomPrat = rs.getString("PRA_NOM");
                String prenomPrat = rs.getString("PRA_PRENOM");
                String adressePrat = rs.getString("PRA_ADRESSE");
                String cpPrat = rs.getString("PRA_CP");
                String villePrat = rs.getString("PRA_VILLE");
                String coefNotoriete = rs.getString("PRA_COEFNOTORIETE");
                TypePraticien typePraticien = DaoTypePraticien.selectOne(rs.getString("TYP_CODE"));

                unPraticien = new Praticien(numPrat, nomPrat, prenomPrat, adressePrat, cpPrat, villePrat, coefNotoriete, typePraticien);
                lesPraticiens.add(unPraticien);
            }
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesPraticiens;
    }
}