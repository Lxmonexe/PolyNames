import { GameService } from "./services/services-game.js"
import {PseudoService} from "./services/services-pseudo.js"

function createGameButton(){
    let button = document.querySelector("#create-game")
    button.addEventListener("click",createGame)
}

function startGameButton(){
    const button = document.querySelector("#enter-game")
    const code = document.querySelector("#code-game")
    code.addEventListener("input",()=>{
        if(GameService.getPartie(code.value)){
            button.disabled = false
        }else{
            button.disabled = true
        }
    })
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
    let randomHex = Math.floor(Math.random()*654321).toString(16)
    try {
        const data = await GameService.postGameCode(randomHex)
        const datapseudo = await PseudoService.postPseudo(pseudo, randomHex)
        console.log(datapseudo)
        //window.location.href = "choix.html"
    } catch (error) {
        console.error('Error posting game code:', error)
    }
}

function run(){
    createGameButton()
    startGameButton()
}

window.addEventListener("load", run)