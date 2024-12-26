"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.WorkerConsoleView = void 0;
class WorkerConsoleView {
    workerView() {
        console.log(this.lineString());
        console.log(`Worker View - Welcome!` + `\n>>> Loading...\n1. Repository`
            + `\n2. ATM\n3. Supervisor\nWaiting for a asnwer! ...`);
        console.log(this.lineString());
    }
    lineString() {
        const LINE = "=".repeat(30);
        return LINE;
    }
}
exports.WorkerConsoleView = WorkerConsoleView;
//# sourceMappingURL=workerConsole.view.js.map