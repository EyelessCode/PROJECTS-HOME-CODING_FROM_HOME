export interface EndpointUrl{
    addressName:string,
    addressLink:string
}

export const heroLogo={
    logoUrl:"https://i.ibb.co/gLWzBxmL/zeneless-zone-zero-logo-horizontal.webp",
    title:"Zenless Zone Zero Logo"
}

export const menuList:EndpointUrl[]=[
    {
        addressName:"Home",
        addressLink:"/"
    },
    {
        addressName:"Characters",
        addressLink:"/characters"
    },
    {
        addressName:"About",
        addressLink:"/about"
    }
]
