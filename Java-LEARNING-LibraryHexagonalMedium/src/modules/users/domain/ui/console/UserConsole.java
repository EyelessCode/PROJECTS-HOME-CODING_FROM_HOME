package modules.users.domain.ui.console;

import modules.users.domain.ui.console.templates.UserTemplate;

public abstract class UserConsole extends UserTemplate{
    // private Scanner scanner=new Scanner(System.in);
    protected abstract void options();
    // protected abstract void searchUserOptions();
}
