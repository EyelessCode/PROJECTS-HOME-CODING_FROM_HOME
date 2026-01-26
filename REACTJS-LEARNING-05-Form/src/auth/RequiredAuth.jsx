import { Navigate } from "react-router-dom"
import { useAuth } from "./contexts/AuthContext"

const RequiredAuth = ({children}) => {
    const {user}=useAuth()
    if(!user)return <Navigate to="/login" replace />
    return children
}

export default RequiredAuth
