package modules.loans.domain.ui.console;

import modules.loans.domain.ui.console.templates.BookLoanTemplate;

public abstract class BookLoanConsole extends BookLoanTemplate {
    protected abstract void options();
    protected abstract void subShowOptions();
}
