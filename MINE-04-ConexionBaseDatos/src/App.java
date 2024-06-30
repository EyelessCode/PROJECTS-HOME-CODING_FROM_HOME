import java.sql.Connection;
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
