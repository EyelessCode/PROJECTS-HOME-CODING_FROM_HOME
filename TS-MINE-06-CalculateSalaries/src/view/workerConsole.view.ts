import { IWorkerViewEvent } from '../interface/iworkerEvent.interface';
export class WorkerConsoleView implements IWorkerViewEvent{
    workerView(): void {
        // throw new Error('Method not implemented.');
        console.log(this.lineString());
        console.log(`Worker View - Welcome!`+`\n>>> Loading...\n1. Repository`
            +`\n2. ATM\n3. Supervisor\nWaiting for a asnwer! ...`
        );
        console.log(this.lineString());
    }
    lineString(): string {
        // throw new Error('Method not implemented.');
        const LINE:string="=".repeat(30);
        return LINE;
    }
/*     printConsole():void{
        console.log(this.lineString());
        console.log(`Worker View - Welcome!`+`\n>>> Loading...\n1. Repository`
            +`\n2. ATM\n3. Supervisor\nWaiting for a asnwer! ...`
        );
        console.log(this.lineString());
    }

    lineString():String{
        const LINE:string="=".repeat(30);
        return LINE;
    } */
}