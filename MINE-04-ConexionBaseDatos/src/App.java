import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
        String user="cristhian";
        String password="cris03022";

        try{
            //! AQUÍ ESTABLECES LA CONEXIÓN
            Connection conn=DriverManager.getConnection(url, user, password);
            
            //! CREAS LA FRASE PARA LA CONSULTA
            String sql="SELECT * FROM libro";

            //! CREAR LA CONSULTA
            Statement stm=conn.createStatement();

            //! ESTABLECES LA CONSULTA Y LA EJECUTAS
            ResultSet rs=stm.executeQuery(sql);

            while (rs.next()) {//! EL '.next' LO QUE HACE ES RECORRER REGISTRO A REGISTRO
                int id=rs.getInt("id");
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                int numPaginas=rs.getInt("numPaginas");
                Date fechaPublicacion=rs.getDate("fechaPublicacion");
                int idAutor=rs.getInt("idAutor");
                int idCategoria=rs.getInt("idCategoria");
                int idEditorial=rs.getInt("idEditorial");
            }

            // MENSAJES EN CONSOLA
            System.out.println("=".repeat(40));
            System.out.println("CONECTANDO...\nCONEXIÓN TERMINADA\n¡'BIBLIOTECA' CONECTADA!");
            System.out.println("=".repeat(40));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
