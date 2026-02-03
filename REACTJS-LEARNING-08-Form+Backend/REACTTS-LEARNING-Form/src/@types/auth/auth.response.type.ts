import type { UserPayload } from "../users/user.type"

export interface AuthResponseType{
    token:string
    user:UserPayload
}
