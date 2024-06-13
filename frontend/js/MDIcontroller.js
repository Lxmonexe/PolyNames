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
    const data = await GameService.updateScore(localStorage.getItem("code"), score.toString())
}

function cardEventListener(){
    let cardClicked = 1
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
                }
                else if(cardClicked > localStorage.getItem("nbcarte")){
                    card.style.backgroundColor = "blue"
                    updateScore(cardClicked*cardClicked)
                    card.id = "decouvert"
                    cardClicked +=1 
                    
                }
                
            }
            else if(target.target.id === "noir" ){
                card.style.backgroundColor = "black"
                console.log("testnoir")
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

function run(){
    
    displayCardsMDI(localStorage.getItem("code"))
    connectSSE()
    showHint()
    nextTurnButton()
}

window.addEventListener('load', run)