import { GameService } from "./services/services-game.js"
import { PseudoService } from "./services/services-pseudo.js"
import { CardGridService } from "./services/services-grid.js"

async function run(){
    if(localStorage.getItem("role") === "MDM"){
        window.location.href = "partieMDM.html"
    } else if(localStorage.getItem("role") === "MDI"){
        window.location.href = "partieMDI.html"
    }else if(localStorage.getItem("role") === "vide"){
        finishGame()
        createGame()
        joinGame()
    }
    else {
        window.location.href = "menu.html"
    }
}
 
function finishGame(){
    const h3 = document.querySelector('h3')
    h3.innerHTML = `Partie ${localStorage.getItem("statutFin")} le score est de: ${localStorage.getItem("score")}`
}

function createGame(){
    const button = document.querySelector("#create-game")
    button.addEventListener("click", startNewGame)
}

async function startNewGame(){
    let randomHex = Math.floor(Math.random()*654321).toString(16)
    try {
        const data = await GameService.postGameCode(randomHex)
        const datapseudo = await PseudoService.postPseudo(localStorage.getItem("pseudo"), randomHex, "MDM")
        console.log(datapseudo)
        
        localStorage.setItem("code", randomHex)
        localStorage.setItem("role", "MDM")
        localStorage.setItem("numeroJoueur", 1)
        const data2 = await CardGridService.createGrid(randomHex)
        window.location.href = "choix.html"
    } catch (error) {
        console.error('Error posting game code:', error)
    }
}

function joinGame(){
    const button = document.querySelector("#join-game")
    button.addEventListener("click", joinGameWithCode)
}

async function joinGameWithCode(){
    const code = document.querySelector("#code-game").value
    const data = await PseudoService.postPseudo(localStorage.getItem("pseudo"), code, "MDI")
    
    localStorage.setItem("code", code)
    localStorage.setItem("role", "MDI")
    localStorage.setItem("numeroJoueur", 2)
    window.location.href="choix.html"
}

window.addEventListener("load", run)