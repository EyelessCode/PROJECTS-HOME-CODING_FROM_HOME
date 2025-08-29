import React, { useEffect, useState } from "react"
import { NavLink } from "react-router"
import { Icon } from "@iconify/react";

type EndpointUrl={
    addressName:string,
    addressLink:string

}

type EndpointUrlProps={
    endUrl:EndpointUrl[]
    logoUrl:string,
    title:string
}

const Header:React.FC<EndpointUrlProps> = ({endUrl,logoUrl,title}) => {
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
                    <div className="flex space-x-4 pl-2 items-center font-[Rampart_One,sans_serif]">
                        {/* Logo */}
                        <article className={`p-[2px] ${isScrolled?"hidden":"block"}`}>
                            {/* <span className="text-white font-extrabold text-2xl">
                                ZZZ
                            </span> */}
                            <img className="w-29 rounded-[8px]" src={logoUrl} alt={title} loading="lazy" />
                        </article>
                        {/* Hero */}
                        <span className={`text-white md:block ${isScrolled?"block":"hidden"} md:${isScrolled?"text-white":"text-black"} transition duration-300 ease-in-out`}>
                            <span className="font-extrabold text-2xl">Z</span>enless <span className="font-extrabold text-2xl">Z</span>one <span className="font-extrabold text-2xl">Z</span>ero
                        </span>
                    </div>
                    {/* Nav for Laptop/PC */}
                    <div className="hidden md:flex">
                        <ul>
                            {endUrl.map((list,i)=>(
                                <li key={i}>
                                    <NavLink to={list.addressLink}
                                            style={({isActive})=>({color:isActive?"red":"black",textDecoration:isActive?"underline":"none"})}>
                                        {list.addressName}
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

                    {isOpen&&(
                        <section className="md:hidden">
                            <div>
                                <ul className="space-y-2 bg-emerald-400 flex flex-col pt-4">
                                    {endUrl.map((list,i)=>(
                                        <li key={i}>
                                            <NavLink to={list.addressLink} className={`block px-3 py-2`}
                                                    style={({isActive})=>({color:isActive?"red":"black",textDecoration:isActive?"underline":"none"})}>
                                                {list.addressName}
                                            </NavLink>
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </section>
                    )}
                </section>
            </nav>
        </header>
    )
}

export {Header}
