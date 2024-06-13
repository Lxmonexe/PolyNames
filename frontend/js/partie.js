import {SSEClient} from "./libs/sse-client.js"
import { MDMview } from "./view/MDMview.js"
import { MDIview } from "./view/MDIview.js"
import { GameService } from "./services/services-game.js"

let premierIndiceMDM = true
let premierIndiceMDI = true
async function run(){
    
    if(localStorage.getItem("role") === "MDM"){
        MDMcontroller()
    } else if(localStorage.getItem("role") === "MDI"){
        MDIcontroller()
    }
    // lancement du SSE
    const data = await GameService.postHint("vide",0).then(data => {
        showHint()
    })
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

async function showHint(){
    const sseHint = new SSEClient(`localhost:8080`)
    sseHint.connect()
    sseHint.subscribe("indice", (indice) => {
        if(localStorage.getItem("role") === "MDI"){
        if(premierIndiceMDI){
            const hintList = document.querySelector('.hint-box')
            hintList.innerHTML = "<h2>Indices</h2>"
            premierIndiceMDI = false
        }
        indice = JSON.parse(indice)
        const hintList = document.querySelector('.hint-box')
         
            hintList.innerHTML += `<p>${indice.mot} - ${indice.nbcarte}</p>`
        }})
        
    }
    


function hintButton(){
    const view = new MDMview()
    view.hintSubmit()
    const hintButton = document.querySelector('#hint-box-button')
    hintButton.addEventListener('click', hintPush)
}

async function hintPush(){
    const hint = document.querySelector('.text-hint').value
    const number = document.querySelector('.number-hint').value.toString()
    if(premierIndiceMDM){
        const hintList = document.querySelector('.hint-box')
        hintList.innerHTML = "<h2>Indices</h2>"
        premierIndiceMDM = false
    }
    const hintList = document.querySelector('.hint-box')
    hintList.innerHTML += `<p>${hint} - ${number}</p>`
    const data = await GameService.postHint(hint, number)
}

window.addEventListener("load", run)