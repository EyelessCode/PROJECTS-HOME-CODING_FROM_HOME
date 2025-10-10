package modules.users.domain.ui.console.views;

import modules.users.domain.ui.console.templates.UserTemplate;

public abstract class UserConsoleView extends UserTemplate{
    protected void options(){
        while (true) {
            menu();
            byte option=-1;
            switch (option) {
                case 1->throw new RuntimeException();
                default->System.out.println("Invalid option. Please enter a valid option (4).");
            }
        }
    }
}
