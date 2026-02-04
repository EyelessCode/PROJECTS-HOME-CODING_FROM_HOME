import { useAuth } from "../../../../contexts/auth/AuthContext"
import NavSideTitleItem from "../../../atoms/NavSideTitleItem"
import NavBar from "../../../molecules/NavBar"
import NavItems from "../../../molecules/NavItems"

interface Props{
    title:string
}

interface NavProps{
    name:string
    link:string
}

export const Nav = ({title}:Props) => {
    const {logout,user}=useAuth()
    const navItem:NavProps[]=[
        {name:"Home",link:"/myTy"},
        {name:"About",link:"/myTy/about"}
    ]

    const linkItem:NavProps[]=[
        {name:"Iniciar sesión",link:"myTy/login"},
        {name:"Regístrarse",link:"myTy/register"}
    ]
    return (
        <>
            <NavSideTitleItem title={title}/>
            <nav>
                <ul className="flex flex-row justify-center gap-7">
                    {
                        navItem.map((element,i:number)=>{
                            return(
                                <NavBar link={element.link} name={element.name} key={i}/>
                            )
                        })
                    }
                </ul>
            </nav>
            <NavItems isActive={user?true:false} loginLabel={linkItem[0].name} registerLabel={linkItem[1].name}
                loginLink={linkItem[0].link} registerLink={linkItem[1].link} logoutLabel="Cerrar sesión"
                username={user?.username} logout={logout}
            />
        </>
    )
}

