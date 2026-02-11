interface Props{
    name:string
    type:"button"|"submit"
    disabled?:boolean
    onClick:()=>void
    variant:"primary-filled"|"succes-filled"|
        "danger-filled"|"secondary-filled"|"primary-outlined"|
        "secundary-outlined"|"sucess-outlined"|"danger-outlined"
}

const Button = ({name,onClick,disabled=false,type,variant="primary-filled"}:Props) => {
    const styleVariant:string=
        variant==="primary-filled"?"border-blue-400 bg-blue-400 text-white hover:bg-blue-500": // filled
        variant==="secondary-filled"?"border-gray-500 bg-gray-500 text-white hover:bg-gray-600": // filled
        variant==="danger-filled"?"border-red-500 bg-red-500 text-white hover:bg-red-600": // filled
        variant==="succes-filled"?"border-green-500 bg-green-500 text-white hover:bg-green-600": //filled
        variant==="primary-outlined"?" border-blue-400 text-black hover:bg-blue-500 hover:text-white": // outlined
        variant==="secundary-outlined"?" border-gray-500 text-black hover:bg-gray-600 hover:text-white": //outlined
        variant==="danger-outlined"?" border-red-500 text-black hover:bg-red-600 hover:text-white": //outlined
        " border-green-500 text-black hover:bg-green-600 hover:text-white" // sucess | outlined

    return (
        <button type={type} disabled={disabled} onClick={onClick}
            className={`uppercase text-[14px] transition btn-hover border-2 p-3 rounded-3xl font-bold cursor-pointer text-black ${styleVariant}`}>
        {name}</button>
    )
}

export default Button
