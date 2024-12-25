export class WorkerConsoleView{
    printConsole():void{
        console.log(this.lineString());
        console.log(`Worker View - Welcome!`+`\n>>> Loading...\n1. Repository`
            +`\n2. ATM\n3. Supervisor\nWaiting for a asnwer! ...`
        );
        console.log(this.lineString());
    }

    lineString():String{
        const LINE:string="=".repeat(30);
        return LINE;
    }
}