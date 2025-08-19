import { Icon } from "@iconify/react/dist/iconify.js"
import type React from "react"

type Items={
    url:string,
    title:string,
    description:string
}

const SplashArt:React.FC<Items> = ({description,title,url}) => {
    return (
        <div className="relative min-h-screen flex">
            <section className={`absolute bg-center w-full h-183 bg-cover flex opacity-80 inset-0 -z-20`} style={{backgroundImage:`url('${url}')`}}>
                {/* <img src={url} alt="" /> */}
            </section>
            <article className="flex justify-center items-center flex-col text-center text-black z-40">
                <h2 className="font-[Poetsen_One,sans_serif] font-extrabold tracking-[0.2em] text-5xl">{title}</h2>
                <p className="font-bold mt-6">{description}</p>
            </article>
            <section className="absolute left-1/2 bottom-1/8 transform -translate-x-1/2 animate-bounce">
                <Icon icon="line-md:arrow-down" width="54" height="54" />
            </section>
        </div>
    )
}

export {SplashArt}
