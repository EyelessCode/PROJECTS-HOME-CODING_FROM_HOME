import { type UserPayload } from "@/index"

export interface AuthResponseType{
    token:string
    user:UserPayload
}
