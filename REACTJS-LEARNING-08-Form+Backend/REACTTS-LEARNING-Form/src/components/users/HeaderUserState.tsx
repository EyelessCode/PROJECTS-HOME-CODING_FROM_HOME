import { Link } from "react-router-dom"

export interface Props{
    username:string|undefined
    logout:()=>void
    // token:string
    isActive:boolean
}

const HeaderUserState = ({username,logout,isActive}:Props) => {
    return (
        <section>
            {
                isActive?
                <>
                    <article>{username}</article>
                    <article><button type="button" onClick={logout}>Cerrar sesión</button></article>
                </>
                :
                <p>
                    <span className="hover:text-blue-600">
                        <Link to="myTy/login">Iniciar sesión</Link></span>/
                    <span className="hover:text-blue-600">
                        <Link to="/myTy/register">Registrarse</Link></span>.
                </p>
            }
        </section>
                // <article>{username}</article>
                // <article><button type="button" onClick={logout}>Cerrar sesión</button></article>
    )
}

export default HeaderUserState
