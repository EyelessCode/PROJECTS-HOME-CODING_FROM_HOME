import type { JSX } from "react"
import { Link } from "react-router-dom"
import HeaderUserState from "./users/HeaderUserState"
import { useAuth } from "../contexts/auth/AuthContext"

interface NavProps{
    name:string
    link:string
}

const Header = () => {
    const {logout,user}=useAuth()
    // door=false
    const navItem:NavProps[]=[
        {name:"Home",link:"/myTy"},
        {name:"About",link:"/myTy/about"}
    ]
    return (
        <header className="flex justify-between mx-4 items-center text-2xl">
            <article>
                <h1 className="text-6xl">
                    <span>Resorcer</span>
                    <span className="text-yellow-300">EC</span>
                </h1>
            </article>
            <div>
                <nav>
                    <ul className="flex flex-row justify-center gap-7">
                        {navItem.map((element,i:number):JSX.Element=>{
                            return (
                                <li key={i} className="hover:text-blue-600">
                                    <Link to={element.link}>{element.name}</Link>
                                </li>
                            )
                        })}
                    </ul>
                </nav>
            </div>
            <HeaderUserState isActive={user?true:false} username={user?.username} logout={logout}/>
        </header>
    )
}

export default Header
