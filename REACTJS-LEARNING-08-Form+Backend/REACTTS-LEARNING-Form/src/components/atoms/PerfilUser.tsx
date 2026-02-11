import type { ReactNode } from "react"

interface Props{
    username:string|undefined
    role:string|undefined
    // logout:()=>void
    children:ReactNode
}

const PerfilUser = ({children,role,username}:Props) => {
    return (
        <>
            <article>
                <p className="text-[14px]">{username}</p>
                <p className="font-extrabold">[{role}]</p>
            </article>
            <div>{children}</div>
        </>
    )
}

export default PerfilUser
