package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;

public class LibroRepositorio {
    String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
    String user="cristhian";
    String password="cris03022";

    public List<Libro> obtenerLibro(){
        List<Libro> listaLibro=new ArrayList<Libro>();

            try{
                //! AQUÍ ESTABLECES LA CONEXIÓN
                Connection conn=DriverManager.getConnection(url, user, password);

                // MENSAJES EN CONSOLA
                System.out.println("=".repeat(40));
                System.out.println("CONECTANDO...\nCONEXIÓN TERMINADA\n¡'BIBLIOTECA' CONECTADA!");
                System.out.println("=".repeat(40));
                
                //! CREAS LA FRASE PARA LA CONSULTA
                String sql="SELECT * FROM libro";

                //! CREAR LA CONSULTA
                Statement stm=conn.createStatement();

                //! ESTABLECES LA CONSULTA Y LA EJECUTAS
                ResultSet rs=stm.executeQuery(sql);

                while (rs.next()) {//! EL '.next' LO QUE HACE ES RECORRER REGISTRO A REGISTRO

                    //! CAMPOS DE LA TABLA
                    int id=rs.getInt("id");
                    String titulo=rs.getString("titulo");
                    String isbn=rs.getString("isbn");
                    int numPaginas=rs.getInt("numPaginas");
                    Date fechaPublicacion=rs.getDate("fechaPublicacion");
                    int idAutor=rs.getInt("idAutor");
                    int idCategoria=rs.getInt("idCategoria");
                    int idEditorial=rs.getInt("idEditorial");

                    //! CREACIÓN A OBJETO
                    Libro libro=new Libro(id, titulo, isbn, numPaginas, fechaPublicacion, idAutor,
                    idCategoria, idEditorial);

                    //! SE AGREGAN LOS DATOS A LA LISTA
                    listaLibro.add(libro);

                    // // PRESENTACIÓN EN CONSOLA
                    // System.out.println("ID: "+id+"\t\tTítulo: "+titulo+"\t\tISBN: "+isbn+"\tN° Páginas: "+numPaginas+
                    // "\t\tFecha de la publicación: "+fechaPublicacion+"\tID del autor: "+idAutor+
                    // "\t\tID de la categoría: "+idCategoria+"\t\tID del editorial: "+idEditorial);

                    // // PRESENTACIÓN EN CONSOLA
                    // System.out.println(id+"\t"+titulo+"\t\t"+isbn+"\t\t"+numPaginas+"\t"+fechaPublicacion+
                    // "\t\t"+idAutor+"\t"+idCategoria+"\t"+idEditorial);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        return listaLibro;
        
    }

    public List<Libro> libroPorIsbn(String isbnCampo){
        List<Libro> listaLibro=new ArrayList<Libro>();

        try{
            //! AQUÍ ESTABLECES LA CONEXIÓN
            Connection conn=DriverManager.getConnection(url, user, password);

            // MENSAJES EN CONSOLA
            System.out.println("=".repeat(40));
            System.out.println("CONECTANDO...\nCONEXIÓN TERMINADA\n¡'BIBLIOTECA' CONECTADA!");
            System.out.println("=".repeat(40));
            
            //! CREAS LA FRASE PARA LA CONSULTA
            String sql="SELECT * FROM Libro";

            //! CREAR LA CONSULTA
            Statement stm=conn.createStatement();

            //! ESTABLECES LA CONSULTA Y LA EJECUTAS
            ResultSet rs=stm.executeQuery(sql);

            while (rs.next()) {//! EL '.next' LO QUE HACE ES RECORRER REGISTRO A REGISTRO

                //! CAMPOS DE LA TABLA
                int id=rs.getInt("id");
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                int numPaginas=rs.getInt("numPaginas");
                Date fechaPublicacion=rs.getDate("fechaPublicacion");
                int idAutor=rs.getInt("idAutor");
                int idCategoria=rs.getInt("idCategoria");
                int idEditorial=rs.getInt("idEditorial");

                //! CREACIÓN A OBJETO
                Libro libro=new Libro(id, titulo, isbn, numPaginas, fechaPublicacion, idAutor,
                idCategoria, idEditorial);

                //! SE AGREGAN LOS DATOS A LA LISTA
                listaLibro.add(libro);
                System.out.println("EL ISBN DEL LIBRO ES: "+libro.getIsbn());

                // // PRESENTACIÓN EN CONSOLA
                // System.out.println("ID: "+id+"\t\tTítulo: "+titulo+"\t\tISBN: "+isbn+"\tN° Páginas: "+numPaginas+
                // "\t\tFecha de la publicación: "+fechaPublicacion+"\tID del autor: "+idAutor+
                // "\t\tID de la categoría: "+idCategoria+"\t\tID del editorial: "+idEditorial);

                // // PRESENTACIÓN EN CONSOLA
                // System.out.println(id+"\t"+titulo+"\t\t"+isbn+"\t\t"+numPaginas+"\t"+fechaPublicacion+
                // "\t\t"+idAutor+"\t"+idCategoria+"\t"+idEditorial);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return listaLibro;
    }
}
