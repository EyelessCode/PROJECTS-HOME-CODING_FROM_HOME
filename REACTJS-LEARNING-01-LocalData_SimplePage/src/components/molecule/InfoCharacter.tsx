import { Icon } from "@iconify/react/dist/iconify.js"
import type React from "react"
import { NavLink } from "react-router"

type MiniInfoCharacterProps={
    iconCharacterUrl:string,
    name:string,
    bgColor:string,
    id:string,
    //? New properties
    iconFactionUrl:string,
    unknownFactionUrl:string
    factionName:string,
    //? For quick view characteristics | icon
    // iconSexUrl:string,
    iconSpecialtyUrl:string,
    iconAttributeUrl:string,
    //? For quick view characteristics | letter
    specialty?:string|null
    attribute:string
    sex?:string|null
}

type InfoCharacter={
    characterMini:MiniInfoCharacterProps[]
    title:string
}

const InfoCharacter:React.FC<InfoCharacter> = ({characterMini,title}) => {
    return (
        <section className="pt-15 min-h-[100dvh] flex justify-center items-center text-center flex-col bg-gray-900 space-y-15 py-7">
            <h1 className="text-white text-6xl font-[Rampart_One,sans_serif]">
                {title}
            </h1>
            {characterMini.map((ch,i)=>{
                let gender="Undefined gender"
                if (!ch.sex) {
                    ch.sex="Undefined gender"
                }else{
                    if(ch.sex==="Male"){
                        gender="male"
                    }else if(ch.sex==="Female"){
                        gender="female"
                    }else{
                        gender="gender"
                    }
                }
                return(
                    <section key={i} title={ch.name}>
                        <article className="relative p-2" style={{backgroundColor:`${ch.bgColor}`}}>
                            <div className="w-45 overflow-hidden">
                                <img loading="lazy" className="w-full h-full object-cover" src={ch.iconCharacterUrl} alt={ch.name} />
                            </div>
                            <div className="absolute top-12 outline rounded-full">
                                <img loading="lazy" className="w-12" src={ch.iconFactionUrl?ch.iconFactionUrl:ch.unknownFactionUrl} alt={ch.factionName} />
                            </div>
                            <div className="flex flex-col text-center px-3">
                                <h3 className="text-4xl">{ch.name}</h3>
                                <h4 className="text-2xl">{ch.factionName?ch.factionName:"Unkown Faction"}</h4>
                            </div>
                            <div className="flex flex-col text-xl mx-22 gap-1 text-white font-semibold">
                                <article className="flex flex-row gap-2 items-center bg-black/50 px-2 py-1 rounded-full">
                                    <img loading="lazy" className="w-8" src={ch.iconSpecialtyUrl} alt={ch.specialty?ch.specialty:undefined} />
                                    <span>{ch.specialty}</span>
                                </article>
                                <article className="flex flex-row gap-2  items-center bg-black/50 px-2 py-1 rounded-full">
                                    <img loading="lazy" className="w-8" src={ch.iconAttributeUrl} alt={ch.attribute} />
                                    <span>{ch.attribute}</span>
                                </article>
                                <article className="flex flex-row gap-2  items-center bg-black/50 px-2 py-1 rounded-full">
                                    {/* This fucking shit gave me a fucking hard night! */}
                                    {/* {ch.sex?.includes("Male")?(<Icon icon="mdi:gender-male" width="28" height="28" />):(<Icon icon="mingcute:female-line" width="28" height="28" />)} */}
                                    {ch.sex?(<Icon icon={`icons8:${gender}`} width="32" height="32" />):undefined}
                                    <span>{ch.sex}</span>
                                </article>
                            </div>
                            <div className="flex flex-row justify-center items-center gap-7">
                                <button type="button">
                                    <NavLink to={`/characters/${ch.id}`}>
                                        View details
                                    </NavLink>
                                </button>
                                <button type="button">
                                    <NavLink to={`/characters`}>
                                        Go to page
                                    </NavLink>
                                </button>
                            </div>
                        </article>
                    </section>
                )
            })}
        </section>
    )
}

export {InfoCharacter}
