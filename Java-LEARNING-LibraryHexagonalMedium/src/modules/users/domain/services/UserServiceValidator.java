package modules.users.domain.services;

import java.util.HashSet;
import java.util.Set;

import modules.users.domain.exceptions.models.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.models.valueObjects.UserIcInvalidException;
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

    protected void icDuplicated(String ic){
        UserIc userIc=new UserIc(ic);
        if (icRegistry.contains(userIc)) {
            throw new UserIcInvalidException("User's IC already registered.");
        }
        icRegistry.add(userIc);
    }

    protected void anythingNull(String ic, String name, String lastname, String gender, Byte age){
        if ((ic==null&&name==null&&lastname==null&&gender==null&&age==null)
        ||(ic==null||name==null||lastname==null||gender==null||age==null)) {
            throw new UserCouldNotBeCreatedException("User couldn't be created.");
        }
    }

    protected void anythingNull(String name, String lastname, String gender, Byte age){
        if ((name==null&&lastname==null&&gender==null&&age==null)
        ||(name==null||lastname==null||gender==null||age==null)) {
            throw new UserCouldNotBeCreatedException("User couldn't be created.");
        }
    }
}
