import {Button, NavItems, PerfilUser} from '@/index';
import { Link } from 'react-router-dom';

interface Props{
    companyName:string
    isActive:boolean
    logout:()=>void
    username:string|undefined
    role:string|undefined
}

interface NavProps{
    name:string
    link:string
}

const Header = ({companyName,isActive,logout,username,role}:Props) => {
    const navs:NavProps[]=[
        {link:"/myTy",name:"Home"},
        {link:"/myTy/about",name:"About"}
    ]
    return (
        <>
            <section>
                <h1 className='text-5xl'>{companyName}</h1>
            </section>
            <section>
                <nav>
                    <ul className='flex flex-row gap-3'>{navs.map((element:NavProps)=>
                        <NavItems key={element.link} link={element.link} name={element.name}/>)}
                    </ul>
                </nav>
                <section>
                    {isActive?(
                        <PerfilUser role={role} username={username}>
                            <Button variant='primary-filled' name='Cerrar sesión' onClick={logout} type='button'/>
                        </PerfilUser>
                    ):(
                        <p>
                            <span className="hover:text-blue-600">
                                <Link to="/myTy/login">Iniciar sesión</Link></span>/
                            <span className="hover:text-blue-600">
                                <Link to="/myTy/register">Registrarse</Link></span>.
                        </p>
                    )}
                </section>
            </section>
        </>
    )
}

export default Header
