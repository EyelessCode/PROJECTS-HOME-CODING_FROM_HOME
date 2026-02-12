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
            <section className='flex flex-row gap-2 items-center justify-between'>
                <nav className='mr-8'>
                    <ul className='flex flex-row'>{navs.map((element:NavProps)=>
                        <NavItems key={element.link} link={element.link} name={element.name}/>)}
                    </ul>
                </nav>
                <section className='flex flex-row gap-5 items-center text-center'>
                    {isActive?(
                        <PerfilUser role={role} username={username}>
                            <Button variant='secondary-filled' name='Cerrar sesión' onClick={logout} type='button'/>
                        </PerfilUser>
                    ):(
                        <p className='text-2xl'>
                            <span className="hover:text-black">
                                <Link to="/myTy/login">Iniciar sesión</Link></span>/
                            <span className="hover:text-black">
                                <Link to="/myTy/register">Registrarse</Link></span>.
                        </p>
                    )}
                </section>
            </section>
        </>
    )
}

export default Header
