import { GameService } from "./services/services-game"

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

function joinGame(){
    const pseudo = document.querySelector("#pseudo").value
    let randomHex = Math.floor(Math.random()*16777215).toString(6)
    randomHex = "#" + randomHex
    const GameService = new GameService()
    GameService.postGameCode(randomHex)
    window.location.href="choix.html"
}

function run(){
    createGameButton()
    startGameButton()
}

window.addEventListener("load", run)