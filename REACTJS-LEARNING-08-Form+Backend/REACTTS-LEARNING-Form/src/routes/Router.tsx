import { Navigate, Route, Routes } from "react-router-dom"
import { About, HomeIn, HomeOut, Login, Register } from "@/index"


const Router = () => {
    return (
        <Routes>
            <Route element={<HomeIn/>} path="/myTy/home" index/>
            <Route element={<HomeOut/>} path="/myTy" index/>
            <Route element={<Login/>} path="/myTy/login"/>
            <Route element={<About/>} path="/myTy/about"/>
            <Route element={<Register/>} path="/myTy/register"/>
            <Route element={<Navigate to="/myTy"/>} path="*"/>
        </Routes>
    )
}

export default Router
