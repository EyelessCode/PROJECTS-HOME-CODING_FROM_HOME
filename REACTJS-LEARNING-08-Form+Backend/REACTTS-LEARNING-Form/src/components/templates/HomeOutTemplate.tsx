import {ArticleOnInfo, Card, Header, Paragraph} from "@/index"

interface Props{
    isUser:boolean
    logout:()=>void
    username:string|undefined
    role:string|undefined
    img:string
    imgAlt:string
}

const HomeOutTemplate = ({isUser,logout,role,username,img,imgAlt}:Props) => {
    return (
        <body className="bg-amber-100 h-dvh w-dvw">
            <header className="bg-cyan-400 py-6 flex flex-row justify-between p-3 items-center text-white w-full">
                <Header logout={logout} role={role} username={username}
                    companyName="ResorcesEC" isActive={isUser}/>
            </header>
            <main>
                <ArticleOnInfo>
                    <section className="flex flex-row gap-4">
                        <div className="min-w-169.5 h-125">
                            <img className="w-full max-h-full" src={img} alt={imgAlt} loading="lazy" />
                        </div>
                        <article>
                            <div>
                                <Paragraph color="black" variant="subtitle">
                                    <>Work</>
                                </Paragraph>
                            </div>
                            <article className="text-justify ">
                                <Paragraph color="black" variant="paragraph">
                                    <>{"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.".repeat(3)}</>
                                </Paragraph>
                            </article>
                        </article>
                    </section>
                    <article className="flex flex-row pt-7 gap-5">
                        <Card>
                            <div className="text-center my-2 uppercase">
                                <Paragraph color="black" variant="subtitle">
                                    <>Seguridad</>
                                </Paragraph>
                            </div>
                            <article>
                                <Paragraph color="black" variant="paragraph">
                                    <>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</>
                                </Paragraph>
                            </article>
                        </Card>
                        <Card>
                            <div className="text-center my-2 uppercase">
                                <Paragraph color="black" variant="subtitle">
                                    <>Compatibilidad</>
                                </Paragraph>
                            </div>
                            <article>
                                <Paragraph color="black" variant="paragraph">
                                    <>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</>
                                </Paragraph>
                            </article>
                        </Card>
                        <Card>
                            <div className="text-center my-2 uppercase">
                                <Paragraph color="black" variant="subtitle">
                                    <>Crecimiento</>
                                </Paragraph>
                            </div>
                            <article>
                                <Paragraph color="black" variant="paragraph">
                                    <>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</>
                                </Paragraph>
                            </article>
                        </Card>
                    </article>
                </ArticleOnInfo>
                <ArticleOnInfo>
                    <section>

                    </section>
                </ArticleOnInfo>
            </main>
        </body>
    )
}

export default HomeOutTemplate
