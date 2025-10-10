package modules.users.domain.ui.console.templates;

public abstract class UserTemplate {
    protected void menu(){
        System.out.println(
            "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
            "\n"+"=".repeat(5)+" USER MENU "+"=".repeat(5)+
            "\n1. View all users."+
            "\n2. Search user."+
            "\n3 Create user."+
            "\n4 Remove user."
        );
    }
}
