import type { JSX } from "react"
import { useAuth } from "../../contexts/AuthContext"
import { Navigate } from "react-router-dom"

interface RequiredRoleProps{
    role:"admin"|"user"
    children:JSX.Element
}

const RequiredRole = ({children,role}:RequiredRoleProps) => {
    const {user}=useAuth()

    if(!user)return <Navigate to="/login" replace/>
    if(user.role!==role)return <Navigate to="/" replace/>
    return children
}

export default RequiredRole
