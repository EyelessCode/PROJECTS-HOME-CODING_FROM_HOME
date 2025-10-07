package modules.users.domain.models;

import modules.users.domain.exceptions.validators.UserValidator;

public class User extends UserValidator{
    private Byte id;
    private final String ic,name,lastname;
    private final char gender;
    private final byte age;
    
    public User(String ic, String name, String lastname, char gender, byte age) {
        this.ic = ic;
        this.name = name;
        this.lastname = lastname;
        this.gender = genderValidator(gender);
        this.age = age;
    }

    //? For testing...
    public User(Byte id, String ic, String name, String lastname, char gender, byte age) {
        this.id = id;
        this.ic = ic;
        this.name = name;
        this.lastname = lastname;
        this.gender = genderValidator(gender);
        this.age = age;
    }

    public Byte getId() {
        return id;
    }

    public String getIc() {
        return ic;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public char getGender() {
        return gender;
    }

    public byte getAge() {
        return age;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (
            "\n"+"=".repeat(5)+" USER "+"=".repeat(5)+
            "\nID: "+id+"\tIC: "+ic+
            "\nNAME: "+name+"\tLASTNAME: "+lastname+
            "\nGENDER: "+gender+
            "\nAGE: "+age+
            "\n"+"=".repeat(12)
        );
    }
}
