window.addEventListener("scroll",function(){
    let header=this.document.querySelector(".header")
    let logImg=this.document.querySelector(".logo a img")

    if (this.window.scrollY>0) {
        header.style.position="fixed"
        header.style.top="0"
        header.style.width="100%"
        header.style.transform = "translateY(-10%)"
        logImg.style.width="50px"
        logImg.style.height="50px"
    } else {
        header.style.position="relative"
        header.style.transform="translateY(0)"
        header.style.backgroundColor="#2E5E3B"
        header.style.width="100%"
        logImg.style.width="100%"
        logImg.style.height="150px"
    }

})
