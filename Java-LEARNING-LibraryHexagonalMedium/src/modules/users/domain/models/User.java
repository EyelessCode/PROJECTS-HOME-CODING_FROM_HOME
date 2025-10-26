package modules.users.domain.models;

import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserId;
import modules.users.domain.models.valueObjects.UserLastname;
import modules.users.domain.models.valueObjects.UserName;
import modules.users.domain.models.valueObjects.enums.UserGender;

public class User {
    private UserId id;
    private final UserIc ic;
    private final UserName name;
    private final UserLastname lastname;
    private final UserGender gender;
    private final UserAge age;
    
    public User(UserIc ic, UserName name, UserLastname lastname, UserGender gender, UserAge age) {
        this.id=new UserId(null);
        this.ic = ic;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }

    public User(UserId id,UserIc ic, UserName name, UserLastname lastname, UserGender gender, UserAge age) {
        this.id=id;
        this.ic = ic;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }

    public UserId getId() {
        return id;
    }

    public UserIc getIc() {
        return ic;
    }

    public UserName getName() {
        return name;
    }

    public UserLastname getLastname() {
        return lastname;
    }

    public UserGender getGender() {
        return gender;
    }

    public UserAge getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return (
            "\n"+"=".repeat(5)+" USER "+"=".repeat(5)+
            "\nID: "+id.getValue()+"\tIC: "+ic.getValue()+
            "\nNAME: "+name.getValue()+"\t\tLASTNAME: "+lastname.getValue()+
            "\nGENDER: "+gender.getDescription()+
            "\nAGE: "+age.getValue()+
            "\n"+"=".repeat(12)
        );
    }
}
