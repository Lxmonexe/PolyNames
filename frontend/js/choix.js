function buttonListener(){
    let button = document.querySelector("#start-game");
    button.addEventListener("click", startGame);
}

function startGame(){
    const rolejoueur1 = document.querySelector("#rolejoueur1").value;
    const rolejoueur2 = document.querySelector("#rolejoueur2").value;
    if(rolejoueur1 === rolejoueur2){
        const error = document.querySelectorAll("#error-message");
        error.innerHTML += "<p>Les rôles des joueurs doivent être différents</p>";
        return;
    }
    // envoi des roles au backend
    //window.location.href = "game.html";
}


function run(){
    selectListener();
    buttonListener();
}

window.addEventListener('load', run);