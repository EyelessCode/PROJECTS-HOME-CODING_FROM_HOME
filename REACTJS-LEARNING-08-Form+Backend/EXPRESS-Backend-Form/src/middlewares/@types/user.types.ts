export interface UserPayload{
    id:number
    username:string
    password:string
    role:"admin"|"user"
}

export interface UserPayloadPublic{
    id:number
    username:string
    // password:string
    role:string
}
