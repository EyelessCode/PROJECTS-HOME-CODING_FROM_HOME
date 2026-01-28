const api=`http://localhost:3000/api/auth`

export const loginRequest=async(username,password)=>{
    const response=await fetch(`${api}/login`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({username,password})
    })

    if(!response.ok){
        const error=await response.json()
        throw new Error(error.message)
    }
    return response.json()
}

export const registerRequest=async(username,password)=>{
    const response=await fetch(`${api}/register`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({username,password})
    })

    if(!response.ok){
        const error=await response.json()
        throw new Error(error.message)
    }
    return response.json()
}
