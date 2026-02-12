import type { ReactNode } from "react"

interface Props{
    children:ReactNode
}

const ArticleOnInfo = ({children}:Props) => {
    return (
        <section
            className="bg-cyan-200 mt-8 mx-20 p-4 flex-col flex"
        >{children}</section>
    )
}

export default ArticleOnInfo
