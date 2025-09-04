export interface Character{
    id:string,
    name:string,
    description:string,
    splashArtUrl:string,
    iconCharacterUrl:string,
    bgColor:string,
    height?:number|null,
    iconFactionUrl:string,
    unknownFactionUrl:"https://i.ibb.co/67csDMM8/Faction-Unknown-icon.webp",
    factionName:string,
    //? For quick view characteristics | letter
    specialty?:"Attack"|"Defense"|"Support"|"Anomaly"|"Rupture"|"Stun"|null,
    attribute:"Ether"|"Physical"|"Ice"|"Frost"|"Electric"|"Auric Ink"|"Fire",
    sex?:"Male"|"Female"|null,
    //? For quick view characteristics | icon
    // iconSexUrl:string,
    iconSpecialtyUrl:string,
    iconAttributeUrl:string,
}

export const characters:Character[]=[
    {
        id:"Evelyn",
        name:"Evelyn Chevalier",
        height:173,
        description:`Evelyn serves as the bodyguard and manager for Astra Yao, and as such has to micromanage both of their lives consistently due to Astra's busy schedule. She is often quite serious and no nonsense, being well guarded around others (an attitude developed during her prior career as part of The Organization), though she is notably more relaxed around Astra and the Phaethon siblings due to their time spent together.`,
        splashArtUrl:"https://i.ibb.co/pvd9K5Bv/evelyn-splashart-zzz.webp",
        iconCharacterUrl:"https://i.ibb.co/V0K2ttt9/Evelyn-Icon.webp",
        bgColor:"darkred",
        iconFactionUrl:"https://i.ibb.co/zp8d4n1/Faction-Stars-of-Lyra-Icon.webp",
        unknownFactionUrl:"https://i.ibb.co/67csDMM8/Faction-Unknown-icon.webp",
        factionName:"Stars of Lyra",
        //? For quick view characteristics | letter
        specialty:"Attack",
        attribute:"Fire",
        sex:"Female",
        //? For quick view characteristics | icon
        // iconSexUrl:"",
        iconSpecialtyUrl:"https://i.ibb.co/fVhNHFXW/Icon-Attack.webp",
        iconAttributeUrl:"https://i.ibb.co/C34Wf1CX/Icon-Fire-attribute.webp",
    },

    {
        id:"Jane_Doe",
        name:"Jane Doe",
        height:170,
        description:`We don't know any things about her yet...`,
        splashArtUrl:"https://i.ibb.co/rKTPCvVL/Jane-Doe-Splash-Art.webp",
        iconCharacterUrl:"https://i.ibb.co/dsrL8Wkr/Jane-Doe-Icon.webp",
        bgColor:"darkblue",
        iconFactionUrl:"https://i.ibb.co/0Vn56B3b/Faction-Criminal-Investigation-Special-Response-Team-Icon.webp",
        unknownFactionUrl:"https://i.ibb.co/67csDMM8/Faction-Unknown-icon.webp",
        factionName:"Criminal Investigation Special Response Team",
        //? For quick view characteristics | letter
        specialty:"Anomaly",
        attribute:"Physical",
        sex:"Female",
        //? For quick view characteristics | icon
        // iconSexUrl:"",
        iconSpecialtyUrl:"https://i.ibb.co/6cG4wMk2/Icon-Anomaly.webp",
        iconAttributeUrl:"https://i.ibb.co/KRbv429/Icon-Physical-attribute.webp",
    },

    {
        id:"Nicole_Demara",
        name:"Nicole Demara",
        height:165.5,
        description:`Nicole Demara is the founder and current leader of the Cunning Hares odd-job agency. Despite taking on any and all Hollow-related commissions and typically charging a high commission fee, she struggles with finances, leading the Cunning Hares to frequently be in debt, sometimes bordering on bankruptcy. Due to this and her all-or nothing approach, the Cunning Hares have become somewhat infamous in the space, with many clients blacklisting her completely and reviews received on Inter-Knot painting her in an unflattering light.`,
        splashArtUrl:"https://i.ibb.co/8LWWbrZ6/Nicole-Splash-Art-ZZZ.webp",
        iconCharacterUrl:"https://i.ibb.co/23djwWC3/Nicole-Demara-Icon.webp",
        bgColor:"deeppink",
        iconFactionUrl:"https://i.ibb.co/QRwC748/Faction-Gentle-House-Icon.webp",
        unknownFactionUrl:"https://i.ibb.co/67csDMM8/Faction-Unknown-icon.webp",
        factionName:"Cunning Hares",
        //? For quick view characteristics | letter
        specialty:"Support",
        attribute:"Ether",
        sex:"Female",
        //? For quick view characteristics | icon
        // iconSexUrl:"",
        iconSpecialtyUrl:"https://i.ibb.co/ZRR7K7NS/Icon-Support.webp",
        iconAttributeUrl:"https://i.ibb.co/ynj473K2/Icon-Ether-attribute.webp",
    }
]
