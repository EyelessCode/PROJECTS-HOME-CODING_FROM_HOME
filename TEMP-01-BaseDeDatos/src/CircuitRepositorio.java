import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CircuitRepositorio {
    String jdbcUrl="jdbc:mysql://127.0.0.1:3306/formula_01";
    String usuario="cristhian";
    String contrasenia="cris03022";

    public List<Circuits> circuitList(){
        List<Circuits> ct=new ArrayList<Circuits>();
        
        try{
            Connection cnt=DriverManager.getConnection(jdbcUrl, usuario, contrasenia);

            String sql="SELECT * FROM `circuits` limit 5";
            Statement st=cnt.createStatement();
            ResultSet rs=st.executeQuery(sql);

            while (rs.next()) {
                int circuitId=rs.getInt("circuitId");
                String circuitRef=rs.getString("circuitRef");
                String name=rs.getString("name");
                String location=rs.getString("location");
                String country=rs.getString("country");


                Circuits c=new Circuits(circuitId, circuitRef, name, location, country);

                ct.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ct;
    }
}
