import { GameService } from "./services/services-game.js"

function createGameButton(){
    let button = document.querySelector("#create-game")
    button.addEventListener("click",createGame)
}

function startGameButton(){
    let button = document.querySelector("#enter-game")
    button.addEventListener("click",getPseudo)
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

function getPseudo(){
    const div = document.querySelector("div")
    div.innerHTML = `<p>
                        <input type='text' id='pseudo' placeholder="Entrez votre pseudo">
                    </p>
                    <p>
                        <button id='start'>Commencer</button>
                    </p>`
    let button = document.querySelector("#start")
    button.addEventListener("click",joinGameWithCode)
}

function joinGameWithCode(){
    const pseudo = document.querySelector("#pseudo").value
    window.location.href="choix.html"
}

async function joinGame(){
    const pseudo = document.querySelector("#pseudo").value
    let randomHex = Math.floor(Math.random()*16777215).toString(6)
    randomHex = "#" + randomHex
    try {
        const data = await GameService.postGameCode(randomHex)
        console.log(data)
        window.location.href = "choix.html"
    } catch (error) {
        console.error('Error posting game code:', error)
    }
}

function run(){
    createGameButton()
    startGameButton()
}

window.addEventListener("load", run)