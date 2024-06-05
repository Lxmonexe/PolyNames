function createGameButton(){
    let button = document.querySelector("#create-game")
    button.addEventListener("click",createGame)
}

function startGameButton(){
    let button = document.querySelector("#enter-game")
    button.addEventListener("click",waitForPlayers)
}

function createGame(){
    const div = document.querySelector("div")
    div.innerHTML = "Entrez un pseudo : <input type='text' id='pseudo'><button id='start'>Commencer</button>"
    let button = document.querySelector("#start")
    button.addEventListener("click",waitForPlayers)
}

function waitForPlayers(){
    const pseudo = document.querySelector("#pseudo").value
    let randomHex = Math.floor(Math.random()*16777215).toString(16)
    window.location.href="choix.html"
}

createGameButton()