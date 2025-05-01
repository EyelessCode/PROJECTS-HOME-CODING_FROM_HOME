export class NombreStudent{
    nombre:string

    constructor(nombre:string) {
        this.nombre=nombre
        this.isEmpty()
        this.limitCharacter()
    }

    private isEmpty(){
        if (!this.nombre||this.nombre.trim()==='') {
            throw new Error(`El nombre no puede estar vacío!`)
        }
    }

    private limitCharacter(){
        if (this.nombre.length>=25||this.nombre.length<=3) {
            throw new Error(`La cantidad de caracteres sobrepasaron `+
                `un límite. No lo excedas!`)
        }
    }
}
