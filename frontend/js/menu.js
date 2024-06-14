import { GameService } from "./services/services-game.js"
import { CardGridService } from "./services/services-grid.js"
import {PseudoService} from "./services/services-pseudo.js"


function createGameButton(){
    let button = document.querySelector("#create-game")
    button.addEventListener("click",createGame)
}

function createGame(){
    const div = document.querySelector("div")
    div.innerHTML = `<p>
                        <input type='text' id='pseudo' placeholder="Entrez votre pseudo">
                    </p>
                    <p>
                        <button id='start'>Commencer</button>
                    </p>`
    let button = document.querySelector("#start")
    button.addEventListener("click",joinGame)
}

function joinGameButton(){
        let button = document.querySelector("#start")
        button.addEventListener("click",joinGameWithCode)
}

async function joinGameWithCode(){
    const pseudo = document.querySelector("#pseudo-entergame").value
    const code = document.querySelector("#code-game").value
    const data = await PseudoService.postPseudo(pseudo, code, "MDI")
    localStorage.setItem("code", code)
    localStorage.setItem("pseudo", pseudo)
    localStorage.setItem("role", "MDI")
    localStorage.setItem("numeroJoueur", 2)
    window.location.href="choix.html"
}

async function joinGame(){
    const pseudo = document.querySelector("#pseudo").value
    let randomHex = Math.floor(Math.random()*654321).toString(16)
    try {
        const data = await GameService.postGameCode(randomHex)
        const datapseudo = await PseudoService.postPseudo(pseudo, randomHex, "MDM")
        localStorage.setItem("code", randomHex)
        localStorage.setItem("pseudo", pseudo)
        localStorage.setItem("role", "MDM")
        localStorage.setItem("numeroJoueur", 1)
        const data2 = await CardGridService.createGrid(randomHex)
        window.location.href = "choix.html"
    } catch (error) {
        console.error('Error posting game code:', error)
    }
}

function clearLocalStorage(){
    localStorage.clear()
}

function run(){
    clearLocalStorage()
    createGameButton()
    joinGameButton()
}

window.addEventListener("load", run)