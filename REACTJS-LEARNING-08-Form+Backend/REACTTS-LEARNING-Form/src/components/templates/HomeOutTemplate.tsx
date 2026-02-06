import {Header} from "@/index"

interface Props{
    isUser:boolean
    logout:()=>void
    username:string|undefined
    role:string|undefined
}

const HomeOutTemplate = ({isUser,logout,role,username}:Props) => {
    return (
        <>
            <header className="flex flex-row justify-between p-3 items-center">
                <Header logout={logout} role={role} username={username}
                    companyName="ResorcesEC" isActive={isUser}/>
            </header>
        </>
    )
}

export default HomeOutTemplate
