
async function run(){
    if(localStorage.getItem("role") === "MDM"){
        window.location.href = "partieMDM.html"
    } else if(localStorage.getItem("role") === "MDI"){
        window.location.href = "partieMDI.html"
    }
    else {
        window.location.href = "menu.html"
    }
}
 


window.addEventListener("load", run)