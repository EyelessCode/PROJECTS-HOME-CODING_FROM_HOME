window.addEventListener("scroll",function(){
    let header=this.document.querySelector("header")
    header.classList.toggle("downScroll",this.window.scrollY>0)
})
