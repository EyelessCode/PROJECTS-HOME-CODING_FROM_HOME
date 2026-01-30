export const authRedirectByRole=(role:string)=>{
    const map:Record<string,string>={
        admin:"/admin",
        user:"/user"
    }

    return map[role]??"/unauthorized"
}
