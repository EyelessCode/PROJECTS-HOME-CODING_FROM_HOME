import { Navigate } from "react-router-dom"
import { userAuth } from "./contexts/AuthContext"

const RequireAuth = ({children}) => {
    const {user}=userAuth()
    if(!user)return <Navigate to="/login" replace/>
    return children
}

export default RequireAuth
