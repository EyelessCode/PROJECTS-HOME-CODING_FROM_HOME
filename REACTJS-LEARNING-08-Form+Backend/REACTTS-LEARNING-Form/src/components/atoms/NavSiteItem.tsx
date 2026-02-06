import type { ReactNode } from "react"

interface Props{
    children:ReactNode
    display?:"flex"|"grid"
}

const NavSiteItem = ({children,display="flex"}:Props) => {
    return (
        <section className="text-2xl" style={{display:`${display}`}}>
            {children}
        </section>
    )
}

export default NavSiteItem
