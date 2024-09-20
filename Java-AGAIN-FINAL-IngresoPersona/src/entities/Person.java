package entities;

public class Person {
    private String name;
    private String lastname;
    private String ic;
    private char sex;
    private int age;
    private String rol;
    private String password;
    
    public Person() {
    }

    public Person(String name, String lastname, String ic, char sex, int age, String rol, String password) {
        this.name = name;
        this.lastname = lastname;
        this.ic = ic;
        this.sex = Character.toUpperCase(sex);
        this.age = age;
        this.rol = rol;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
