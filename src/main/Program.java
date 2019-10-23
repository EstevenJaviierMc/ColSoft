package main;

import controlador.ControladorFacultad;
import java.sql.SQLException;
import java.util.Scanner;
import controlador.ConectarBD;
import java.util.List;
import modelo.Facultad;

public class Program {

    public static void guardarFacultad() {
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
            fjdbc.grabarFacultad(f1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getErrorCode() == 1062) {
                System.out.println("La facultad que desea ingresar ya Existe!");
            };
        }
    }

    public static void actualizarFacultad(Facultad f1) {
        Facultad f2 = f1;

        ConectarBD cx = new ConectarBD();
        ControladorFacultad fjdbc = new ControladorFacultad();
        try {
            cx.conectarme();
            fjdbc.setCon(cx.getCon());
            fjdbc.modificarFacultad(f2);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Facultad obtenerFacultad(String codigo) {
        Facultad f2 = null;

        ConectarBD cx = new ConectarBD();
        ControladorFacultad fjdbc = new ControladorFacultad();
        try {
            cx.conectarme();
            fjdbc.setCon(cx.getCon());
            f2 = fjdbc.obtenerFacultad(codigo);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(f2.toString());
        
        return f2;
    }

    public static void obtenerFacultades() {
        List<Facultad> listaFacultades = null;

        ConectarBD cx = new ConectarBD();
        ControladorFacultad fjdbc = new ControladorFacultad();
        try {
            cx.conectarme();
            fjdbc.setCon(cx.getCon());
            listaFacultades = fjdbc.obtenerFacultades();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        for (Object facultad : listaFacultades) {
            System.out.println(facultad.toString());
        }
    }

    public static void eliminarFacultad(String codigo) {

        ConectarBD cx = new ConectarBD();
        ControladorFacultad fjdbc = new ControladorFacultad();
        try {
            cx.conectarme();
            fjdbc.setCon(cx.getCon());
            fjdbc.EliminarFacultad(codigo);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

//    public static void main(String[] args) {
//        guardarFacultad ();
//        System.out.println("");
//     
//        obtenerFacultades();
//        System.out.println("");
//
//        Scanner leer = new Scanner(System.in);
//        System.out.print("Ingrese el numero de facultad que quiere obtener: ");
//        String num = leer.next();
//        Facultad f1 = obtenerFacultad(num);
//        System.out.println("");        
//        
//        System.out.print("Ingrese el nuevo nombre para la facultad: ");
//        f1.setNombre(leer.next());
//        
//        System.out.print("Ingrese el nuevo estado para la facultad: ");
//        f1.setEstado(leer.next());
//        actualizarFacultad(f1);
//        System.out.println("");
//        
//        obtenerFacultades();
//        System.out.println("");
//
//        System.out.print("Ingrese el numero de facultad que quiere eliminar: ");
//        num = leer.next();
//        eliminarFacultad(num);
//
//    }

}
