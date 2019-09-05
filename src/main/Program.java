package main;

import controlador.ControladorFacultad;
import java.sql.SQLException;
import java.util.Scanner;
import controlador.ConectarBD;
import modelo.Facultad;

public class Program {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre, estado;
        
        System.out.print("Ingrese el nombre de la Facultad: ");
        nombre = leer.next();
        System.out.print("Ingrese el estado de la Facultad: ");
        estado = leer.next();

        Facultad f1 = new Facultad(nombre, estado);

        System.out.println(f1.toString());
        
        ConectarBD cx = new ConectarBD();
        ControladorFacultad fjdbc = new ControladorFacultad();
        try {
            cx.conectarme();
            fjdbc.setCon(cx.getCon());
            fjdbc.saveFacultad(f1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if(ex.getErrorCode() == 1062) {
                System.out.println("La facultad que desea ingresar ya Existe!");
            };
        }
        
        
    }

}
