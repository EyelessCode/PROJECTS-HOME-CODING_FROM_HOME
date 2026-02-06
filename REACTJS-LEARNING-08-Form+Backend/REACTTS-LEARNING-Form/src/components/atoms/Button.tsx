interface Props{
    name:string
    type:"button"|"submit"
    disabled?:boolean
    onClick:()=>void
    color:"primary"|"succes"|"danger"|"secondary"
    // bg:"filled"|"outlined"
    variant?:"solid"|"outline"
    className?:string
}

const Button = ({name,onClick,disabled=false,type,color,className="",variant="solid"}:Props) => {
    const buttonClasses:string=[
        "button",
        `button--${color}`,
        variant === "outline" ? "button--outline" : "",
        className,
    ].filter(Boolean).join(" ")
    return (
        <button type={type} disabled={disabled} onClick={onClick}
            className={buttonClasses}>
        {name}</button>
    )
}

export default Button
