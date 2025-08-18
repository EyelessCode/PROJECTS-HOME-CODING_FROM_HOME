import type React from "react"
import { NavLink } from "react-router"

type MiniInfoCharacterProps={
    iconUrl:string,
    name:string,
    bgColor:string,
    id:string
}

type InfoCharacter={
    characterMini:MiniInfoCharacterProps[]
}

const InfoCharacter:React.FC<InfoCharacter> = ({characterMini}) => {
    return (
        <section className="pt-15 min-screen flex justify-center items-center text-center flex-col bg-gray-900 space-y-15 py-7">
            <h1 className="text-white text-6xl font-[Cabin,Inter,Playwrite,Poetsen]">Most Famous Characters</h1>
            {characterMini.map((ch,i)=>(
                <NavLink to={`/characters/${ch.id}`}>
                    <article key={i} className="text-white flex flex-col items-center justify-center inset-3 rounded-4xl" title={`${ch.name}`} style={{backgroundColor:`${ch.bgColor}`}}>
                        <img src={ch.iconUrl} alt={ch.name} className="w-72 rounded-4xl hover:scale-105 transition" />
                        <div key={i} className="flex items-center p-4">
                            <span className="font-extrabold text-2xl">{ch.name}</span>
                        </div>
                    </article>
                </NavLink>
            ))}
        </section>
    )
}

export {InfoCharacter}