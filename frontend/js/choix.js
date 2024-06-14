import { GameService } from "./services/services-game.js";
import { SSEClient } from "./libs/sse-client.js"

const sseClient = new SSEClient(`localhost:8080`);

// bouton choix de rôles désactivé à cause d'un problème avec la fonction viewRole() et qui empêche le bon fonctionnement de la suite
function buttonRoleListener(){
    const buttonMDM = document.querySelector(".MDM");
    const buttonMDI = document.querySelector(".MDI");
    buttonMDM.addEventListener("click", changeMDM);
    buttonMDI.addEventListener("click", changeMDI);
}

function buttonStart(){
    const button = document.querySelector(".start-button");
    button.addEventListener("click", () => {
        window.location.href = "partie.html";
    });
}

async function changeMDM(){
    const data = await GameService.udpdateRole(localStorage.getItem("code"), localStorage.getItem("pseudo"), "MDM", localStorage.getItem("numeroJoueur"));
    localStorage.setItem("role", "MDM");
}

async function changeMDI(){
    const data = await GameService.udpdateRole(localStorage.getItem("code"), localStorage.getItem("pseudo"), "MDI", localStorage.getItem("numeroJoueur"));
    localStorage.setItem("role", "MDI");
}

// fonction permettant de d'afficher le pseudo des joueurs au dessus de leur role
async function viewRole(){
    sseClient.subscribe("role", (data) => {
        data = JSON.parse(data);
        if(data.role == "MDM"){
            if(data.numeroJoueur == 1){
                const joueur = document.querySelector("#Joueur1MDM");
                joueur.innerHTML = `${data.pseudo}`;
                console.log("ok");
            }
            else if(data.numeroJoueur == 2){
                const joueur = document.querySelector("#Joueur2MDM");
                joueur.innerHTML = `${data.pseudo}`;
            }
        } else if(data.role == "MDI"){
            if(data.numeroJoueur == 1){
               const joueur = document.querySelector("#Joueur1MDI");
                joueur.innerHTML = `<p>${data.pseudo}</p>`;
            }
            else if(data.numeroJoueur == 2){
                const joueur = document.querySelector("#Joueur2MDI");
                joueur.innerHTML = `<p>${data.pseudo}</p>`;
                console.log("ok");
            }
        }
    });
}

function run(){
    const codePartie = localStorage.getItem("code");
    const code = document.querySelector("#code-partie");
    code.innerHTML = codePartie;
    sseClient.connect();
    viewRole();
    buttonRoleListener();
    buttonStart();
}

window.addEventListener('load', run);