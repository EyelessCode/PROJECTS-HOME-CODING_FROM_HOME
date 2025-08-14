const SplashArt = () => {
    return (
        <div className="min-w-full flex flex-col justify-center items-center">
            <h1>SplashArt</h1>
            <section className="bg-center w-full h-102 bg-cover flex justify-center items-center" style={{backgroundImage:"url('https://i.ibb.co/pvd9K5Bv/evelyn-splashart-zzz.webp')"}}>
                <article className="flex justify-center items-center flex-col text-center bg-black/40 rounded-4xl text-white">
                    <h2 className="font-[Poetsen_One,sans_serif] font-extrabold tracking-[0.2em] text-5xl ">Evelyn</h2>
                    <p className="font-bold">Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae et quia atque doloremque culpa iusto similique ipsa odio mollitia dignissimos perferendis suscipit reiciendis harum, doloribus tempore natus. Laudantium, dolore animi?</p>
                </article>
            </section>
        </div>
    )
}

export {SplashArt}
