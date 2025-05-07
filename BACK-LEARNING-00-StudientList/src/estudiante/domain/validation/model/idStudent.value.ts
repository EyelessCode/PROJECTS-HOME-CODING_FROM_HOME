export class IdStudent{
    id:number

    constructor(id:number) {
        this.id=id
        this.numNegativo()
        // this.noFloat()
    }

    private numNegativo(){
        if (this.id<0) {
            throw new Error(`El ID no puede ser menor a '0'!`)
        }
    }

    /* private noFloat(){
        if (!Number.isInteger(this.id)) {
            throw new Error(`El ID debe de ser un número entero!`)
        }
    } */

    private noRepeat(){
        if (this.id===this.id) {
            throw new Error(`${this.id} ya existr!`)
        }
    }
}
