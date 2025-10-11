package modules.users.domain.ui.console.templates;

import shared.ui.console.templates.GenericTemplates;

public abstract class UserTemplate extends GenericTemplates{

    @Override
    protected void userMenu() {
        System.out.println(
            // "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
            "\n"+"=".repeat(5)+" USER MENU "+"=".repeat(5)+
            "\n1. View all users."+
            "\n2. Search user."+
            "\n3 Create user."+
            "\n4 Remove user."+
            "\n5 Go back."
        );
    }

    @Override
    protected void searchUserMenu() {
        System.out.println(
            "\n"+"=".repeat(5)+" SEARCH OPTION "+"=".repeat(5)+
            "\n1. By only ID."+
            "\n2. By name, lastname or IC."+
            "\n3 Go back."
        );
    }
}
