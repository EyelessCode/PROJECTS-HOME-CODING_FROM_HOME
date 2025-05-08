export class ApellidoStudent{
    apellido?:string

    constructor(apellido:string) {
        this.apellido=apellido
        // this.isEmpty()
        this.limitCharacter()
    }

    /* private isEmpty(){
        if (!this.apellido||this.apellido.trim()==='') {
            throw new Error(`El apellido no puede estar vacío!`)
        }
    } */

    private limitCharacter(){
        if (this.apellido && (this.apellido.length >= 25 || this.apellido.length <= 3)) {
            throw new Error(`La cantidad de caracteres sobrepasaron `+
                `un límite. No lo excedas!`)
        }
    }
}
