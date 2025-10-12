package modules.users.domain.services;

import java.util.HashSet;
import java.util.Set;

import modules.users.domain.exceptions.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.models.UserIcInvalidException;
import modules.users.domain.exceptions.models.UserNameInvalidException;
import modules.users.domain.models.valueObjects.UserIc;

public abstract class UserServiceValidator {
    protected final Set<UserIc>icRegistry=new HashSet<>();

    //? Initial local datas (for testing).
    public UserServiceValidator(){
        icRegistry.add(new UserIc("0974852960"));
        icRegistry.add(new UserIc("0985987874"));
        icRegistry.add(new UserIc("0969963695"));
        icRegistry.add(new UserIc("0958852100"));
        icRegistry.add(new UserIc("0990010147"));
    }

    protected void propertiesExpected(String ic,String name,String lastname,Byte age){
        if (ic==null) {
            throw new UserIcInvalidException("User's IC cannot be null value.");
        }
        if (name==null||lastname==null) {
            throw new UserNameInvalidException("User's name or lastname cannot be null value");
        }
    }

    protected void icDuplicated(String ic){
        UserIc userIc=new UserIc(ic);
        if (icRegistry.contains(userIc)) {
            // System.out.println(icRegistry.toString());
            throw new UserCouldNotBeCreatedException("This User's IC has been used.");
        }
        icRegistry.add(userIc);
    }
}
