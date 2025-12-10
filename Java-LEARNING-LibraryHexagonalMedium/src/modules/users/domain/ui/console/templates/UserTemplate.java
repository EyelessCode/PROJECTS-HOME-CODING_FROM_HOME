package modules.users.domain.ui.console.templates;

import shared.ui.console.templates.GenericTemplates;

public abstract class UserTemplate extends GenericTemplates{

    @Override
    protected void menu() {
        System.out.println(
            // "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
            "\n"+"=".repeat(5)+" USER MENU "+"=".repeat(5)+
            "\n1. View all users."+
            "\n2. Search user (IC or names)."+
            "\n3. Go back."
            // "\n-- 3 Create user. --"+
            // "\n-- 4 Remove user. --"+
        );
    }

    protected void adminUserMenu() {
        System.out.println(
            "\n"+"-".repeat(5)+" ADMIN MOD "+"-".repeat(5)+
            "\n"+"=".repeat(5)+" USER MENU "+"=".repeat(5)+
            "\n1. View all users."+
            "\n2. Search user (IC or names)."+
            "\n3. Create user."+
            "\n4. Modify user."+
            "\n5. Remove user."+
            "\n6. Go back."+
            "\n"+"-".repeat(5)+" YOU MUST BE CAREFUL WITH >ROOT PRIVILEGES< "+"-".repeat(5)
        );
    }
}
