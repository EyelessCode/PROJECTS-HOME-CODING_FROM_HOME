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
    String usuario="cristhian";
    String contrasenia="cris03022";

    public List<Libros> llamadaLibro(){
        List<Libros> listaLibros=new ArrayList<Libros>();
        try{
            Connection conn=DriverManager.getConnection(url, url, contrasenia);

            System.out.println("CONECTADO...\n");

            String sql="SELECT * FROM Libro";

            Statement st=conn.createStatement();

            ResultSet rs=st.executeQuery(sql);

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

                listaLibros.add(l);
                System.out.println(listaLibros);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return listaLibros;
    }
}
