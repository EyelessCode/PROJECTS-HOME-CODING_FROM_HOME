import { NavLink } from 'react-router';
type InfoThrow={
    urlIcon:string,
    description:string,
    name:string,
    //// widthReso:string,
    heightReso:string,
}

type InfoProps={
    info:InfoThrow[],
    title:string,
    addressUrl:string
}

const Detail:React.FC<InfoProps> = ({info,title,addressUrl}) => {
    return (
        <section className="bg-gray-900">
            <section className="text-white">
                <article className="flex flex-col justify-center items-center">
                    <div className="mb-42 mt-6">
                        <h3 className="text-6xl font-[Rampart_One,sans_serif]">
                            {title}
                        </h3>
                    </div>
                    {info.map((inff,i)=>(
                        <article key={i}>
                            <div className="bg-gray-950 flex flex-col justify-center items-center rounded-4xl mb-40 mx-6 hover:outline border-white group">
                                <div className="p-3 rounded-full w-[194px] overflow-hidden -mt-28 bg-gray-950 z-0 outline-0 border-white group-hover:outline-3 transition">
                                    <img style={{height:`${inff.heightReso}`}} className="object-cover w-full rounded-full group-hover:scale-105 transition" src={inff.urlIcon} alt={inff.name} loading='lazy' />
                                </div>
                                <div className="mx-2 rounded-4xl">
                                    <div>
                                        <h4 className="text-center text-3xl mb-4 my-2 font-extrabold font-[Chakra_Petch,sans-serif] uppercase">{inff.name}</h4>
                                    </div>
                                    <div>
                                        <p className="font-[Arial] px-4 text-justify py-2">
                                            {inff.description}
                                        </p>
                                    </div>
                                    <div className='flex items-center justify-center py-4'>
                                        <button type='button' className='py-4 px-12 bg-yellow-400 text-black font-bold rounded-3xl cursor-pointer hover:bg-amber-500 transition-colors ease-in duration-100 uppercase text-1xl'>
                                            <NavLink to={addressUrl}>
                                                More
                                            </NavLink>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </article>
                    ))}
                </article>
            </section>
        </section>
    )
}

export {Detail}