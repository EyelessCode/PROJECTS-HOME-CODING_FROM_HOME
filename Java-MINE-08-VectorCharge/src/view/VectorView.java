package view;

public class VectorView {
    public String lineString(){
        String LINE="=".repeat(30);
        return LINE;
    }

    public void draw() {
        lineString();
        System.out.println("Drawing a vector"+
        "\n↓"+"\n↓"+"\n↓"+"\n↓"+"\n↓");
    }
}
