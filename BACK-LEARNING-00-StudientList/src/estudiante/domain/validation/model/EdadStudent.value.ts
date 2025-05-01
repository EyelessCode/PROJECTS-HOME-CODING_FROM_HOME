export class EdadStudent{
    edad:number

    constructor(edad:number) {
        this.edad=edad
        this.edadNinio()
    }

    private edadNinio(){
        if (this.edad<6||this.edad>50) {
            throw new Error(`Esta edad no está permitida para `+
                `un estudiante de escuela, colegio y universitario!`
            )
        }
    }
}
