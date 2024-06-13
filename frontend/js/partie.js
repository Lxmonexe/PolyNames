
import { MDMview } from "./view/MDMview.js"
import { MDIview } from "./view/MDIview.js"

async function run(){
    if(localStorage.getItem("role") === "MDM"){
        MDMcontroller()
    } else if(localStorage.getItem("role") === "MDI"){
        MDIcontroller()
    }
    
}
 
function MDMcontroller(){
    const view = new MDMview()
    view.displayCardsMDM(localStorage.getItem("code"))
    hintButton()
}

function MDIcontroller(){
    const view = new MDIview()
    view.displayCardsMDI(localStorage.getItem("code"))
}



function hintButton(){
    const view = new MOWview()
    view.hintSubmit()
    const hintButton = document.querySelector('hint-box-button')
    hintButton.addEventListener('click', hintPush)
}

function hintPush(){
    const hint = document.querySelector('.text-hint').value
    const number = document.querySelector('.number-hint').value
    const hintList = document.querySelector('.hint-box')
    hintList.innerHTML += `<p>${hint} - ${number}</p>`
}

window.addEventListener("load", run)