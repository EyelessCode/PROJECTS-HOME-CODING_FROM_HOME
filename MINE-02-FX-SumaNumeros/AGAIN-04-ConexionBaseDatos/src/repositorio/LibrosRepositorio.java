package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Libros;

public class LibrosRepositorio {
    String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
    String user="cristhian";
    String password="cris03022";

    public List<Libros> libroGeneral(){
        List<Libros> libroList=new ArrayList<Libros>();

        try{
            Connection cnt=DriverManager.getConnection(url, user, password);
            System.out.println("=".repeat(35));
            System.out.println("¡BASE DE DATOS CONECTADA!");
            System.out.println("=".repeat(35));

            String sql="SELECT * FROM libro";
            Statement sta=cnt.createStatement();
            ResultSet rs=sta.executeQuery(sql);

            while (rs.next()) {
            int id=rs.getInt("id");
            String titulo=rs.getString("titulo");
            String isbn=rs.getString("isbn");
            int numPaginas=rs.getInt("numPaginas");
            Date fechaPublicacion=rs.getDate("fechaPublicacion");
            int idAutor=rs.getInt("idAutor");
            int idCategoria=rs.getInt("idCategoria");
            int idEditorial=rs.getInt("idEditorial");

            Libros l=new Libros(id, titulo, isbn, numPaginas, fechaPublicacion, idAutor, idCategoria, idEditorial);

            libroList.add(l);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return libroList;
        
    }

    public List<Libros> libroTitulo(String campoTitulo){
        List<Libros> libroList=new ArrayList<Libros>();

        try {
            Connection cnt=DriverManager.getConnection(url, user, password);

            System.out.println("=".repeat(35)+"\n¡BASE DE DATOS CONECTADA!\n"+"=".repeat(35));

            String sql="SELECT titulo from libro";
            Statement stm=cnt.createStatement();
            ResultSet rs=stm.executeQuery(sql);

            while (rs.next()) {
                String titulo=rs.getString("titulo");

                // int id=rs.getInt("id");
                // String titulo=rs.getString("titulo");
                // String isbn=rs.getString("isbn");
                // int numPaginas=rs.getInt("numPaginas");
                // Date fechaPublicacion=rs.getDate("fechaPublicacion");
                // int idAutor=rs.getInt("idAutor");
                // int idCategoria=rs.getInt("idCategoria");
                // int idEditorial=rs.getInt("idEditorial");

                Libros l=new Libros(0, titulo, null, 0, null, 0, 0, 0);

                // Libros l=new Libros(id, titulo, isbn, numPaginas, fechaPublicacion, idAutor, idCategoria, idEditorial);
                libroList.add(l);
                // System.out.println(l.getTitulo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libroList;
    }
}
