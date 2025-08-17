import type React from "react"
import { NavLink } from "react-router"

type Items={
    addresName:string,
    addresLink:string
}

type ItemsProps={
    items:Items[]
}

const HamburgerMenu:React.FC<ItemsProps> = ({items}) => {
    return (
        <section className="md:hidden z-10">
            <ul className="flex flex-col pb-3 space-y-3 bg-amber-500">
                {items.map((list,i)=>(
                    <li key={i} >
                        <NavLink to={list.addresLink} className="block px-3 py-2 rounded-md text-base font-medium text-gray-300 hover:text-white hover:bg-gray-800"
                                style={({isActive})=>({color:isActive?"red":"black",textDecoration:isActive?"underline":"none"})}>
                            {list.addresName}
                        </NavLink>
                    </li>
                ))}
            </ul>
        </section>
    )
}

export {HamburgerMenu}
