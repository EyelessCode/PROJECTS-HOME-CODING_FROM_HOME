import type { ReactNode } from "react"

interface Props{
    children:ReactNode
    variant:"paragraph"|"title"|"subtitle"
    color:"black"|"white"
}

const Paragraph = ({children,variant="paragraph",color="black"}:Props) => {
    const variantStyle:string=
        variant==="paragraph"?"text-[14px] ":
        variant==="title"?"text-4xl m-3 font-bold":
        "text-2xl m-2 font-bold" // subtitle

    return (
        <span className={`m-1 ${variantStyle}`} style={{color:`${color}`}}>
            {children}
        </span>
    )
}

export default Paragraph
