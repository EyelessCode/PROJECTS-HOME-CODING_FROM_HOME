public class App {
    public static void main(String[] args) {
        try {
            // Código que puede causar una excepción
            int[] numeros = new int[5];
            numeros[10] = 3; // Esto causará una ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha capturado una excepción:");
            e.printStackTrace(); // Imprime la traza de la pila de la excepción
        }
    }
}
