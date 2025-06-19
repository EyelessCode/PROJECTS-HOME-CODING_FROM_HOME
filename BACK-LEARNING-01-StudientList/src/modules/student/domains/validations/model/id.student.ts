import { IdNegative } from "../util/ErrorStudent.util"

export class IdStudent{
    value:number

    constructor(value:number) {
        this.value=value
        this.validationNumber()
    }

    private validationNumber() {
        if (this.value<=0) {
            throw new IdNegative(`That's a negative number!`)
        }
    }
}
