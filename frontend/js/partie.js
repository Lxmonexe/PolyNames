import {SSEClient} from "./libs/sse-client.js"
import { MDMview } from "./MDMview.js"
import { MDIview } from "./MDIview.js"
import { GameService } from "./services/services-game.js"

let premierIndiceMDM = true
let premierIndiceMDI = true
let sseClient = new SSEClient(`localhost:8080`)
async function run(){
    
    if(localStorage.getItem("role") === "MDM"){
        MDMcontroller()
    } else if(localStorage.getItem("role") === "MDI"){
        MDIcontroller()
        
    }
    connectSSE()
    showHint()
}
 
function MDMcontroller(){
    const view = new MDMview()
    view.displayCardsMDM(localStorage.getItem("code"))
    hintButton()
}

function MDIcontroller(){
    const view = new MDIview()
    view.displayCardsMDI(localStorage.getItem("code"))
    nextTurn()
}

function connectSSE(){
    sseClient.connect()
}
async function showHint(){
    
    sseClient.subscribe("indice", (indice) => {
        if(localStorage.getItem("role") === "MDI"){
        if(premierIndiceMDI){
            const hintList = document.querySelector('.hint-box')
            hintList.innerHTML = "<h2>Indices</h2>"
            premierIndiceMDI = false
        }
        indice = JSON.parse(indice)
        const hintList = document.querySelector('.hint-box')
        localStorage.setItem("nbcarte", indice.nbcarte)    
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
    localStorage.setItem("nbcarte", number)
    const data = await GameService.postHint(hint, number)
    const inputBox = document.querySelector('.input-box')
    inputBox.innerHTML = ""
}

function cardEventListener(){
    let cardClicked = 1
    const cards = document.querySelectorAll('card')
    for(const card of cards){
        console.log("test")
        card.addEventListener('click', (target) => {
        
        if(target.target.id === "gris"){
            console.log("testgris")
        }
        if(target.target.id === "bleu"){
            if(cardClicked <= localStorage.getItem("nbcarte")){
                card.style.backgroundColor = "blue"
                const data = GameService.updateScore(localStorage.getItem("code"), cardClicked)
                cardClicked += 1 
            }
            else if(cardClicked > localStorage.getItem("nbcarte")){
                card.style.backgroundColor = "blue"
                const data = GameService.updateScore(localStorage.getItem("code"), cardClicked)
                cardClicked +=1 
                console.log("update score")
            }
            
        }
        if(target.target.id === "noir"){
            console.log("testnoir")
        }
    })
    }
}



async function updateScore(score){
    const data = await GameService.updateScore(localStorage.getItem("code"), score) 
}

function nextTurn(){
    const view = new MDIview()
    view.nextTurn()
    const nextButton = document.querySelector('#next-turn')
    nextButton.addEventListener('click', () => {
        hintButton()
        
    })
}

window.addEventListener("load", run)