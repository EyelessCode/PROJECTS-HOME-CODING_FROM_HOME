import { Navigate, Route, Routes } from "react-router-dom"
// import NotFound from "../pages/NotFound"
import Register from "../pages/Register"
import Home from "../pages/HomeIn"
import Login from "../pages/Login"
import HomeOut from "../pages/HomeOut"
import About from "../pages/About"


const MyRouter = () => {
    return (
        <Routes>
            <Route element={<Home/>} path="/myTy/home" index/>
            <Route element={<HomeOut/>} path="/myTy" index/>
            <Route element={<Login/>} path="/myTy/login"/>
            <Route element={<About/>} path="/myTy/about"/>
            <Route element={<Register/>} path="/myTy/register"/>
            <Route element={<Navigate to="/myTy"/>} path="*"/>
        </Routes>
    )
}

export default MyRouter
