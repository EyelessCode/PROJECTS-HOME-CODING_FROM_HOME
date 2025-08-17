import { useState } from "react"
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
    return (
        <header className="border">
            <nav className="bg-emerald-500 fixed z-50 ">
                <section className="flex flex-row justify-between items-center max-w-7xl mx-auto">
                    <section className="outline">
                        <div>
                            <h1>Zenless Zone Zero</h1>
                        </div>
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
                            {/* button here */}
                        </div>
                    </section>
                    <section>
                        <div className="md:hidden">
                            <button onClick={()=>setIsOpen(!isOpen)}>
                                {isOpen?<Icon icon="duo-icons:menu" width="54" height="54" />:<Icon icon="cuida:menu-outline" width="54" height="54" />}
                            </button>
                        </div>
                        {isOpen&&(
                            <HamburgerMenu items={menuList} />
                        )}
                    </section>
                </section>
            </nav>
        </header>
    )
}

export {NavMenu}
