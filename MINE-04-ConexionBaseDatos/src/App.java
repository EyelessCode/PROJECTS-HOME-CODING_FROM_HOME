import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/biblioteca";
        String user="cristhian";
        String password="cris03022";

        try{
            //! AQUÍ ESTABLECES LA CONEXIÓN
            Connection conn=DriverManager.getConnection(url, user, password);
            System.out.println("=".repeat(40));
            System.out.println("CONECTANDO...\nCONEXIÓN TERMINADA\n¡'BIBLIOTECA' CONECTADA!");
            System.out.println("=".repeat(40));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
