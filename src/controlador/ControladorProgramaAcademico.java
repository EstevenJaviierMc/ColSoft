/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import controlador.ConectarBD;
import java.util.ArrayList;
import modelo.Facultad;
import modelo.ProgramaAcademico;

public class ControladorProgramaAcademico extends ConectarBD {

    ConectarBD cone = new ConectarBD();

   

    public boolean registrar(ProgramaAcademico pro, Facultad f) throws SQLException {

        PreparedStatement ps = null;

        String query = "INSERT INTO programaacademico (nombrePrograma,idFacultad,estado) VALUES(?,?,?)";
        try {

            ps = this.getCon().prepareStatement("INSERT INTO programaacademico VALUES(?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, pro.getNombreprograma());
            ps.setInt(3, f.getIdFacultad());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

    public boolean modificar(ProgramaAcademico pro, Facultad f) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "UPDATE programaacademico SET nombrePrograma=?,idfacultad=?,estado=? WHERE idprogramaacademico=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pro.getNombreprograma());
            ps.setInt(2, f.getIdFacultad());
            ps.setString(3, pro.getEstado());
            ps.setInt(4, pro.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean eliminar(ProgramaAcademico pro) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "DELETE FROM programaacademico WHERE idprogramaacademico=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pro.getId());
            

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean buscar(ProgramaAcademico pro, Facultad f) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String query = "SELECT * FROM programaacademico WHERE nombrePrograma=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pro.getNombreprograma());

            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setNombreprograma((rs.getString("Nombre_Programa")));
                f.setIdFacultad(Integer.parseInt(rs.getString("IdFacultad")));
                pro.setEstado(rs.getString("Estado"));
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    private ProgramaAcademico load(ResultSet et) throws SQLException {
        ProgramaAcademico pro = new ProgramaAcademico();
        Facultad f = new Facultad();
        pro.setId(et.getInt(1));
        pro.setNombreprograma(et.getString(2));
        f.setIdFacultad(et.getInt(3));
        pro.setIdfacultad(f);
        pro.setEstado(et.getString(4));

        return pro;
    }
    
    public ArrayList<ProgramaAcademico> listarprogramas() throws SQLException{
    
        ResultSet rs=null;
        PreparedStatement ps=null;
        ArrayList<ProgramaAcademico> lista=new ArrayList<ProgramaAcademico>();
        try{
            ps = this.getCon().prepareStatement("SELECT * FROM programaacademico");
            rs=ps.executeQuery();
            while(rs.next()){
            lista.add(load(rs));
            
            }
        
        }catch(SQLException Ignore){
        
        } finally{
            if(rs!=null){
            rs.close();
            }
            if(ps!=null){
            ps.close();
            }
        
        }
        return lista;
    }
    public ArrayList<ProgramaAcademico> buscarprogramas(int item,String Parametro) throws SQLException{
    
        ResultSet rs=null;
        PreparedStatement ps=null;
        ArrayList<ProgramaAcademico> lista=new ArrayList<ProgramaAcademico>();
        String sql="";
                
        try{
            if(item==1){
            sql="SELECT FROM programaacademico WHERE nombreprograma=?";
            }
            if(item==2){
            sql="SELECT FORM facultad WHERE nombre=?";
            }
            if(item==3){
            sql="SELECT FROM programaacademico WHERE estado=?";
            }
            ps = this.getCon().prepareStatement(sql);
            ps.setString(1, Parametro);
            rs=ps.executeQuery();
            while(rs.next()){
            lista.add(load(rs));
            
            }
        
        }catch(SQLException Ignore){
        
        } finally{
            if(rs!=null){
            rs.close();
            }
            if(ps!=null){
            ps.close();
            }
        
        }
        return lista;
    }

}
