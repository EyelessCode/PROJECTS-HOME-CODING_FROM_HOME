import { Navigate } from "react-router-dom"
import { useAuth } from "../../contexts/AuthContext"
import type { JSX } from "react"

const RequiredAuth = ({children}:{children:JSX.Element}) => {
    const {user}=useAuth()
    return user?children:<Navigate to="/login" replace/>
}

export default RequiredAuth
