/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import modelo.Facultad;

/**
 *
 * @author Estudiante
 */
public class ControladorFacultad extends ConectarBD{
    private List listaFacultad;
    ConectarBD cone = new ConectarBD();

    public void saveFacultad(Facultad m1) throws SQLException {
        PreparedStatement pstt = null;
        try {
            pstt = getCon().prepareStatement("insert into facultad values(?,?,?)");

            pstt.setString(1, null);
            pstt.setString(2, m1.getNombre());
            pstt.setString(3, m1.getEstado());

            if ((getFacultad(m1.getNombre())).getNombre()== null) {
                if (m1.getNombre()!= null) {
                    pstt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "La Facultad fue registrada exitosamente!");
                    System.out.println("La Facultad fue registrada exitosamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "No deje campos vacios");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La Facultad que desea registar ya extiste!");
            }//fin de if
            
        } finally {
            if (pstt != null) {
                pstt.close();
            }
        }
    }

    public void updateFacultad(Facultad m1) throws SQLException {
        PreparedStatement pstt = null;
        try {
            pstt = this.getCon().prepareStatement("UPDATE facultad SET idfacultad=?,nombre=?,estado=?");
            
            pstt.setString(1, m1.getNombre());
            pstt.setString(2, m1.getEstado());

            pstt.executeUpdate();
            JOptionPane.showMessageDialog(null, "La Facultad fue actualizada exitosamente!");
        } finally {
            if (pstt != null) {
                pstt.close();
            }
        }
    }

    public Facultad getFacultad(String codigo) throws SQLException {

        Facultad m1 = new Facultad();
        PreparedStatement pstt = null;
        ResultSet rs = null;
        try {

            pstt = this.getCon().prepareStatement("select * from facultad where idfacultad = ?");
            pstt.setString(1, codigo);
            rs = pstt.executeQuery();
            while (rs.next()) {
                m1 = load(rs);
            }
        } finally {
            if (pstt != null) {
                pstt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return m1;
    }

    public List getFacultad() throws SQLException {

        listaFacultad = new LinkedList();
        PreparedStatement pstt = null;
        ResultSet rs = null;
        try {
            pstt = this.getCon().prepareStatement("select * from facultad");
            rs = pstt.executeQuery();
            while (rs.next()) {
                listaFacultad.add(load(rs));
            }
        } finally {
            if (pstt != null) {
                pstt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return listaFacultad;
    }

    private Facultad load(ResultSet rs) throws SQLException {
        Facultad rcu = new Facultad();
        
        rcu.setIdFacultad(rs.getInt(1));
        rcu.setNombre(rs.getString(2));
	rcu.setEstado(rs.getString(3));

        return rcu;
    }

    public void DeleteFacultad(String codigoFacultad) throws SQLException {
        PreparedStatement pstn = null;
        try {
            pstn = this.getCon().prepareStatement("DELETE FROM facultad WHERE idfacultad = '"+ codigoFacultad +"'");
            
            if (pstn.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "La Facultad fue eliminada exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "La Facultad fue que desea registar no extiste!");
            }
        } finally {
            if (pstn != null) {
                pstn.close();
            }
        }
    }
}