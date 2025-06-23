export class NameStudent{
    value:string

    constructor(value:string){
        this.value=value

    }

    private characterLimit(){
        let noSpace=this.value.trim();
        if (noSpace.length>10) {
            throw new IcCharacterLimit(`This student's IC pass the 10 character limit!`)
        }

        if (!this.value||noSpace.trim()===''||noSpace.length<=0) {
            throw new IcNoSpace(`Student's IC cannot be empty!`)
        }
    }
}