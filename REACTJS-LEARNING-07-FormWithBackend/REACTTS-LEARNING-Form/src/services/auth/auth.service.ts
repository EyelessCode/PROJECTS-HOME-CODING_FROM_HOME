import type { AuthResponse } from "../../@types/auth/auth.types";
import api from "../../apis/axios";

export const loginRequest=async(username:string,password:string):Promise<AuthResponse>=>{
    const {data}=await api.post<AuthResponse>("/login",{
        username,password
    })

    return data
}

export const registerRequest=async(username:string,password:string):Promise<AuthResponse>=>{
    const {data}=await api.post<AuthResponse>("/register",{
        username,password
    })
    return data
}
