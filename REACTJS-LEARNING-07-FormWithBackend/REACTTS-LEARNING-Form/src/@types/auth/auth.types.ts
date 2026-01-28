export interface UserPayload{
    id:number
    username:string
    password:string
    role:"admin"|"user"
}

export interface AuthResponse{
    token:string
    user:UserPayload
}

export interface AuthContextType{
    user:UserPayload|null
    token:string|null
    login:(username:string,password:string)=>Promise<void>
    register:(username:string,password:string)=>Promise<void>
    logout:()=>void
}
