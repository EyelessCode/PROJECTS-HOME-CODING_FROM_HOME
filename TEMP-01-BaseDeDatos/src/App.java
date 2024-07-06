import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        CircuitRepositorio cr=new CircuitRepositorio();

        List<Circuits> ccc=cr.circuitList();

        System.out.println("HAY "+ccc.size()+" DE CANTIDAD");

        for (Circuits circuits : ccc) {
            System.out.printf("\nNOMBRE: %s \tPAÍS: %s \tID CONDUCTOR: %d\n", circuits.getName(),circuits.getCountry(),circuits.getCircuitId());
        }
    }
}
