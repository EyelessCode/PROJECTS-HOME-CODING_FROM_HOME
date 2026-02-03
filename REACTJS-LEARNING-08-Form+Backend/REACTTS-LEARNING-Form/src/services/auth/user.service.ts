import type { AuthResponseType } from "../../@types/auth/auth.response.type"
import { api } from "../../apis/axios"

export const loginRequest=async(username:string,password:string)=>{
    const {data}=await api.post<AuthResponseType>("/login",{username,password})
    return data
}

export const registerRequest=async(username:string,password:string)=>{
    const {data}=await api.post<AuthResponseType>("/register",{username,password})
    return data
}
