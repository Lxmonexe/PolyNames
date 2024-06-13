import { CardGridService } from "./services/services-grid.js";

function buttonListener(){
    let button = document.querySelector("#start-game");
    button.addEventListener("click", ()=> {
        window.location.href = "partie.html";
    });
}

function startGame(){
    const rolejoueur1 = document.querySelector("#rolejoueur1").selectedIndex;
    const rolejoueur2 = document.querySelector("#rolejoueur2").selectedIndex;
    console.log(rolejoueur1);
    console.log(rolejoueur2);
    console.log("test");
    if(rolejoueur1 === rolejoueur2){
        const error = document.querySelectorAll("#error-message");
        error.innerHTML += "<p>Les rôles des joueurs doivent être différents</p>";
        return;
    }
    // envoi des roles au backend
    window.location.href = "partie.html";
}




function run(){
    const codePartie = localStorage.getItem("code");
    const code = document.querySelector("#code-partie");
    code.innerHTML = codePartie;
    buttonListener();
    
}

window.addEventListener('load', run);