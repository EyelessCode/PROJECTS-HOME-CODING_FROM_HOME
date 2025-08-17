export interface Character{
    id:string,
    name:string,
    sex?:"Male"|"Female"|null,
    specialty?:"Attacker"|"Tank"|"Support"|"Anomaly"|null,
    attackType:"Ethereal"|"Physical"|"Ice"|"Icy"|"Electric"|"Corrupter"|"Fire",
    height?:number|null,
    description:string,
    splashArtUrl:string,
    iconUrl:string

}

export const characters:Character[]=[
    {
        id:"Evelyn",
        name:"Evelyn Chevalier",
        sex:"Female",
        specialty:"Attacker",
        attackType:"Fire",
        height:173,
        description:`Evelyn serves as the bodyguard and manager for Astra Yao, and as such has to micromanage both of their lives consistently due to Astra's busy schedule. She is often quite serious and no nonsense, being well guarded around others (an attitude developed during her prior career as part of The Organization), though she is notably more relaxed around Astra and the Phaethon siblings due to their time spent together.`,
        splashArtUrl:"https://i.ibb.co/pvd9K5Bv/evelyn-splashart-zzz.webp",
        iconUrl:"https://i.ibb.co/V0K2ttt9/Evelyn-Icon.webp"
    },

    {
        id:"Jane_Doe",
        name:"Jane Doe",
        sex:"Female",
        specialty:"Anomaly",
        attackType:"Physical",
        height:170,
        description:`We don't know any things about her yet...`,
        splashArtUrl:"https://i.ibb.co/rKTPCvVL/Jane-Doe-Splash-Art.webp",
        iconUrl:"https://i.ibb.co/dsrL8Wkr/Jane-Doe-Icon.webp"
    },

    {
        id:"Nicole_Demara",
        name:"Nicole Demara",
        sex:"Female",
        specialty:"Support",
        attackType:"Ethereal",
        height:165.5,
        description:`Nicole Demara is the founder and current leader of the Cunning Hares odd-job agency. Despite taking on any and all Hollow-related commissions and typically charging a high commission fee, she struggles with finances, leading the Cunning Hares to frequently be in debt, sometimes bordering on bankruptcy. Due to this and her all-or nothing approach, the Cunning Hares have become somewhat infamous in the space, with many clients blacklisting her completely and reviews received on Inter-Knot painting her in an unflattering light.`,
        splashArtUrl:"https://i.ibb.co/8LWWbrZ6/Nicole-Splash-Art-ZZZ.webp",
        iconUrl:"https://i.ibb.co/23djwWC3/Nicole-Demara-Icon.webp"
        // https://i.ibb.co/jv1LCkBJ/Zenless-Zone-Zero-Splash-Art.webp
    }
]
