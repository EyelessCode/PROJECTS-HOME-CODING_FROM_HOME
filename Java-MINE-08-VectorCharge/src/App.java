import repository.VectorialChargeRespoitory;
// import view.VectorView;

public class App {
    public static void main(String[] args) throws Exception {
        VectorialChargeRespoitory vectorialChargeRespoitory=new VectorialChargeRespoitory();
        // VectorView vectorView=new VectorView();

        System.out.println("Hello, World!");
        // System.out.println(vectorView.lineString());
        vectorialChargeRespoitory.vectorFunction();
    }
}
