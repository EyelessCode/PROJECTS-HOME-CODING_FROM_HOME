import type { ReactNode } from "react"

interface Props{
    children:ReactNode
}

const Card = ({children}:Props) => {
    return (
        <section className="outline-2 bg-amber-50 outline-cyan-300 flex flex-col p-2">
            {children}
        </section>
    )
}

export default Card
