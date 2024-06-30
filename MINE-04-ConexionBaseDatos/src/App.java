import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/biblioteca";
        String user="cristhian";
        String password="cris03022";

        try{
            Connection conn=DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
