import { Route, Routes } from "react-router-dom"
import RequiredAuth from "../contexts/RequiredAuth"
import Login from "../pages/Login"
import Register from "../pages/Register"
import Admin from "../pages/Admin"
import Home from "../pages/Home"

const Router = () => {
    return (
        <Routes>
            <Route path="/login" element={<Login/>}/>
            <Route path="/register" element={<Register/>}/>
            <Route path="/test" element={<Home/>}/>
            <Route path="/home" element={<RequiredAuth><Home/></RequiredAuth>}/>
            <Route path="/admin" element={<RequiredAuth><Admin/></RequiredAuth>}/>
            <Route path="*" element={<Login/>}/>
        </Routes>
    )
}

export default Router
