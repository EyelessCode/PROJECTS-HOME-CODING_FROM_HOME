import { useEffect, useState } from "react"
import { NavLink } from "react-router"
import { Icon } from "@iconify/react";
import { HamburgerMenu } from "../molecule/HamburgerMenu";

const NavMenu = () => {
    const menuList=[
        {
            addresName:"Home",
            addresLink:"/"
        },
        {
            addresName:"Characters",
            addresLink:"/characters"
        },
        {
            addresName:"About",
            addresLink:"/about"
        }
    ]
    console.log(menuList);

    const [isOpen,setIsOpen]=useState(false)
    const [isScrolled,setIsScrolled]=useState(false)

    useEffect(()=>{
        const handleScroll=()=>{
            setIsScrolled(window.scrollY>20)
        }
        window.addEventListener("scroll",handleScroll)
        return ()=> window.removeEventListener("scroll",handleScroll)
    },[])

    useEffect(()=>{
        const handleResize=()=>{
            if (window.innerWidth>=768) {
                setIsOpen(false)
            }
        }

        window.addEventListener("resize",handleResize)
        return ()=>window.removeEventListener("resize",handleResize)
    },[])
    return (
        <header className="bg-amber-200">
            <nav className={`fixed w-full z-50 ${isScrolled?"bg-gray-900":"bg-transparent"} transition ease-in-out duration-300 rounded-b-3xl pb-1`}>
                <section className="flex justify-between">
                    <div className="flex space-x-4 pl-2 py-2 items-center">
                        {/* Logo */}
                        <article className={`bg-black rounded-[8px] p-1 ${isScrolled?"hidden":"block"}`}>
                            <span className="text-white font-extrabold text-2xl font-[Bungee,Cabin,sans_serif]">ZZZ</span>
                        </article>
                        {/* Hero */}
                        <span className={`text-white md:block ${isScrolled?"block":"hidden"} md:${isScrolled?"text-white":"text-black"} transition duration-300 ease-in-out`}><span className="font-[Bungee,Cabin,sans_serif] font-extrabold text-2xl">Z</span>enless <span className="font-[Bungee,Cabin,sans_serif] font-extrabold text-2xl">Z</span>one <span className="font-[Bungee,Cabin,sans_serif] font-extrabold text-2xl">Z</span>ero</span>
                    </div>
                    {/* Nav for Laptop/PC */}
                    <div className="hidden md:flex">
                        <ul>
                            {menuList.map((list,i)=>(
                                <li key={i}>
                                    <NavLink to={list.addresLink}
                                            style={({isActive})=>({color:isActive?"red":"black",textDecoration:isActive?"underline":"none"})}>
                                        {list.addresName}
                                    </NavLink>
                                </li>
                            ))}
                        </ul>
                    </div>
                    {/* Hamgurguer Button */}
                    <div className="md:hidden">
                        <button onClick={()=>setIsOpen(!isOpen)} className={`${isScrolled?"text-white":"text-black"}`}>
                            {isOpen?(<Icon icon="duo-icons:menu" width="54" height="54" />):(<Icon icon="cuida:menu-outline" width="54" height="54" />)}
                        </button>
                    </div>
                    {/* Mobile Menu */}
                    {isOpen&&<HamburgerMenu items={menuList}/>}
                </section>
            </nav>
        </header>
    )
}

export {NavMenu}
