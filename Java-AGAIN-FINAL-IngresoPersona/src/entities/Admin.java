package entities;

public class Admin {
    private String username;
    private String ic;
    private char sex;
    private int age;
    private String rol;
    private String PASSWORD;
    
    public Admin() {
    }

    public Admin(String username, String ic, char sex, int age, String rol, String pASSWORD) {
        this.username = username;
        this.ic = ic;
        this.sex = Character.toUpperCase(sex);
        this.age = age;
        this.rol = rol;
        PASSWORD = pASSWORD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }

    
}
