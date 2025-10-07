package models;

public class User {
    private String name,lastname,ic;
    private Integer id;
    private byte age;
    private char gender;
    
    public User(String name, String lastname, String ic, byte age, char gender) {
        this.name = name;
        this.lastname = lastname;
        this.ic = ic;
        this.age = age;
        this.gender = Character.toUpperCase(gender);
    }
    
    public User(Integer id,String name, String lastname, String ic, byte age, char gender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.ic = ic;
        this.age = age;
        this.gender = Character.toUpperCase(gender);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getIc() {
        return ic;
    }

    public Integer getId() {
        return id;
    }

    public byte getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", lastname=" + lastname + ", ic=" + ic + ", id=" + id + ", age=" + age
                + ", gender=" + gender + "]";
    }
}
