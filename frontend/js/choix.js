import { CardGridService } from "./services/services-grid.js";
import { GameService } from "./services/services-game.js";
import { SSEClient } from "./libs/sse-client.js"


function buttonRoleListener(){
    
}


function run(){
    const codePartie = localStorage.getItem("code");
    const code = document.querySelector("#code-partie");
    code.innerHTML = codePartie;
    const sseClient = new SSEClient(`localhost:8080`);
    sseClient.connect();
}

window.addEventListener('load', run);