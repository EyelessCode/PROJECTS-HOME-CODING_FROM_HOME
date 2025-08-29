export interface DetailInfo{
    name:string,
    urlIcon:string,
    description:string,
    //// widthReso:string,
    heightReso:string,
    rounded:string
}

export const detail:DetailInfo[]=[
    {
        name:"MiHoyoVerse",
        urlIcon:"https://graphicsgaga.com/wp-content/uploads/2023/10/Hoyoverse-Logo-PNG.webp",
        description:`Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet itaque impedit tempora, esse similique nesciunt praesentium maiores minima fuga voluptas, perferendis quasi quidem perspiciatis modi. Amet eaque pariatur vitae officiis!`,
        //// widthReso:"194px",
        rounded:"calc(infinity*1px)",
        heightReso:"168px"
    },
    {
        name:"Zenless Zone Zero",
        urlIcon:"https://i.ibb.co/gb1gGGSs/Zenless-Zone-Zero-Logo.webp",
        description:`Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet itaque impedit tempora, esse similique nesciunt praesentium maiores minima fuga voluptas, perferendis quasi quidem perspiciatis modi. Amet eaque pariatur vitae officiis!`,
        //// widthReso:"194px",
        rounded:"none",
        heightReso:"100%"
    },
    {
        name:"Dev Team",
        urlIcon:"https://i.ibb.co/BHRjB1kb/hoyoverse-dev-team-photo.webp",
        description:`Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet itaque impedit tempora, esse similique nesciunt praesentium maiores minima fuga voluptas, perferendis quasi quidem perspiciatis modi. Amet eaque pariatur vitae officiis!`,
        //// widthReso:"194px",
        rounded:"none",
        heightReso:"168px"
    },
]
