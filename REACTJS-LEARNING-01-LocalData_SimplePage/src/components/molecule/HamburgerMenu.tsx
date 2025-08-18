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
        <section className="md:hidden">
            <div>
                <ul className="space-y-2 bg-emerald-400 flex flex-col pt-4">
                    {items.map((list,i)=>(
                        <li key={i}>
                            <NavLink to={list.addresLink} className={`block px-3 py-2`}
                                    style={({isActive})=>({color:isActive?"red":"black",textDecoration:isActive?"underline":"none"})}>
                                {list.addresName}
                            </NavLink>
                        </li>
                    ))}
                </ul>
            </div>
        </section>
    )
}

export {HamburgerMenu}
