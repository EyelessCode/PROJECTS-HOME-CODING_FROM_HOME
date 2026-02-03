import type { JSX } from "react"
import { Link } from "react-router-dom"

interface Props{
    companyName:string
    userbar:JSX.Element
    door:boolean
}

interface NavProps{
    name:string
    link:string
}

const Header = ({companyName,userbar,door}:Props) => {
    // door=false
    const navItem:NavProps[]=[
        {name:"Home",link:"/myTy"},
        {name:"About",link:"/myTy/about"}
    ]
    return (
        <header className="flex justify-between mx-4 items-center text-2xl">
            <article>
                <h1 className="text-6xl">{companyName}</h1>
            </article>
            <div>
                <nav>
                    <ul className="flex flex-row justify-center gap-7">
                        {navItem.map((element,i:number):JSX.Element=>{
                            return (
                                <li key={i}><Link to={element.link}>{element.name}</Link></li>
                            )
                        })}
                    </ul>
                </nav>
            </div>
            {
                door?userbar:
                <p>
                    <span className="hover:text-blue-600">
                        <Link to="myTy/login">Iniciar sesión</Link></span>/
                    <span className="hover:text-blue-600">
                        <Link to="/myTy/register">Registrarse</Link></span>.
                </p>
            }
        </header>
    )
}

export default Header
