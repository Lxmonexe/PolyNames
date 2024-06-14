import { CardGridService } from "./services/services-grid.js";
import { GameService } from "./services/services-game.js";
import { SSEClient } from "./libs/sse-client.js"

const sseClient = new SSEClient(`localhost:8080`)
let premierIndiceMDI = true

function displayCard(card){
    const grid = document.querySelector('gridCards');
    const cardHTML = `<card id=${card._couleur}><p>${card._texte}</p></card>`;	
    grid.innerHTML += cardHTML;
}

function displayCardsMDI(codePartie){
    CardGridService.getGrid(codePartie).then(data => {
        data.forEach(card => {
            displayCard(card);
            cardEventListener()
            
            });
        });
        
}

function connectSSE(){
    sseClient.connect()
}

function nextTurnButton(){
    const inputBox = document.querySelector('.input-box');
    inputBox.innerHTML = 
        `<h2>Prochain tour</h2>
        <button id="next-turn">Prochain tour</button>`;
    const button = document.querySelector('#next-turn')
    button.addEventListener('click', nextTurn)
}

async function nextTurn(){
    const data = await GameService.nextTurn()
}
async function updateScore(score){
    localStorage.setItem("score", parseInt(localStorage.getItem("score")) + score)
    const data = await GameService.updateScore(localStorage.getItem("code"), localStorage.getItem("score"))
}

function cardEventListener(){
    let cardClicked = 1
    let blueCard = 8
    const cards = document.querySelectorAll('card')
    for(const card of cards){
        console.log("test")
        card.addEventListener('click', (target) => {
        
        if(target.target.id === "gris"){
            card.style.backgroundColor = "grey"
            card.id = "decouvert"
            nextTurn()
            localStorage.setItem("intuition", 0)
        }
        else if(target.target.id === "bleu"){
            if(cardClicked <= localStorage.getItem("nbcarte")){
                card.style.backgroundColor = "blue"
                card.id = "decouvert"
                updateScore(cardClicked)
                cardClicked += 1 
                blueCard -= 1
                if(blueCard === 0){
                    postEndGame("Victoire !")
                }
            }
            else if(cardClicked > localStorage.getItem("nbcarte")){
                card.style.backgroundColor = "blue"
                updateScore(cardClicked*cardClicked)
                card.id = "decouvert"
                cardClicked +=1 
                blueCard -= 1
                if(blueCard === 0){
                    postEndGame("Victoire !")
                }
            }
            
        }
        else if(target.target.id === "noir" ){
            card.style.backgroundColor = "black"
            console.log("testnoir")
            updateScore(0)
            card.id = "decouvert"
            postEndGame("Perdue...")
        }
        
        })
    }
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

async function getScore(){
    sseClient.subscribe("score", (data) => {
        const h3 = document.querySelector('h3')
        data = JSON.parse(data)
        h3.innerHTML = `Score: ${data.scorePartie}`
    })
}

async function postEndGame(statut){
    const data = await GameService.endGame(localStorage.getItem("code"), statut)
}

async function endGame(){
    sseClient.subscribe("finPartie", (data) => {
        data = JSON.parse(data)
        localStorage.setItem("statutFin", data.statutFin)
        localStorage.setItem("score", data.scorePartie)
        localStorage.setItem("role","vide")
        window.location.href = "partie.html"
    })
}

function run(){
    localStorage.setItem("score", 0)
    displayCardsMDI(localStorage.getItem("code"))
    connectSSE()
    showHint()
    nextTurnButton()
    getScore()
    endGame()
}

window.addEventListener('load', run)