import { CardGridService } from "./services/services-grid.js";
import { SSEClient } from "./libs/sse-client.js";
import { GameService } from "./services/services-game.js";

const sseClient = new SSEClient(`localhost:8080`)
let premierIndiceMDM = true
    
function displayCard(card){
    const grid = document.querySelector('gridCards');
    const cardHTML = `<card class=${card._couleur} id="MDM"><p>${card._texte}</p></card>`;	
    grid.innerHTML += cardHTML;
    
}   

function displayCardsMDM(codePartie){
    CardGridService.getGrid(codePartie).then(data => {
        data.forEach(card => {
            displayCard(card);
        });
    });
}

function hintSubmit() {
    const hint = document.querySelector('.input-box');
    hint.innerHTML = 
        `<h2>Ajouter un indice</h2>
        <input type="text" placeholder="Entrez votre indice ici" class="text-hint">
        <input type="number" placeholder="Nombre de cartes associées" class="number-hint">
        <button id="hint-box-button">Ajouter l'indice</button>`  
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



function connectSSE(){
    sseClient.connect()
}

async function nextTurn(){
    sseClient.subscribe("tourSuivant", (data) => {
        console.log(data)
        hintSubmit()
    })
}

function run(){
    displayCardsMDM(localStorage.getItem("code"));
    nextTurn();
    connectSSE();
    hintSubmit();
   
}

window.addEventListener('load', run);