function createGameButton(){
    let button = document.querySelector("button")
    button.addEventListener("click",startGame)
}

function startGame(){
    window.location.href = "choix.html"
}

createGameButton()