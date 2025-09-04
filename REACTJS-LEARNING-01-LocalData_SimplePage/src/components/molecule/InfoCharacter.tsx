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
                    <section key={i} className="group/zzz-chr" title={ch.name}>
                        <article className="relative w-83">
                            <article className="flex flex-col justify-center items-center">
                                <div className="w-52 overflow-hidden z-0 -mb-20 rounded-full group-hover/zzz-chr:outline-2 outline-white">
                                    <img loading="lazy" className="w-full h-full object-cover p-2 rounded-full group-hover/zzz-chr:scale-105 transition-all ease-in-out duration-200" style={{backgroundColor:`${ch.bgColor}`}} src={ch.iconCharacterUrl} alt={ch.name} />
                                </div>
                                <div className="absolute top-33 right-17 rounded-full z-10 p-1 w-19 bg-black/65 group-hover/zzz-chr:outline-2 outline-white group-hover/zzz-chr:bg-black" title={ch.factionName}>
                                    <img loading="lazy" className="w-full h-full" src={ch.iconFactionUrl?ch.iconFactionUrl:ch.unknownFactionUrl} alt={ch.factionName} />
                                </div>
                            </article>
                            <article className="flex flex-col justify-center items-center px-3 pb-6 pt-8 rounded-3xl group-hover/zzz-chr:outline-2 outline-white" style={{backgroundColor:`${ch.bgColor}`}}>
                                <div className="text-center px-1 text-white my-2 mt-14 flex flex-col justify-center items-center gap-1">
                                    <h3 className="text-5xl font-extrabold font-[Great_Vibes,cursive]">{ch.name}</h3>
                                    <h4 className="text-2xl font-bold font-[Chakra_Petch,sans-serif]">{ch.factionName?ch.factionName:"Unkown Faction"}</h4>
                                    <div className="border-t border-white w-45 my-2"></div>
                                </div>
                                <div className="flex flex-col text-xl w-37 mx-auto gap-1 text-white font-semibold">
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
                                <div className="flex flex-row justify-center items-center gap-2 mt-3 pt-3">
                                    <button type="button" className=" font-bold px-4 py-2 text-white cursor-pointer hover:underline ease-in">
                                        <NavLink to={`/characters/${ch.id}`}>
                                            View details
                                        </NavLink>
                                    </button>
                                    <NavLink to={`/characters`}>
                                        <button type="button" className="bg-amber-400 rounded-full py-2 px-4 font-bold cursor-pointer hover:bg-amber-400/80">
                                            Go to page
                                        </button>
                                    </NavLink>
                                </div>
                            </article>
                        </article>
                    </section>
                )
            })}
        </section>
    )
}

export {InfoCharacter}
