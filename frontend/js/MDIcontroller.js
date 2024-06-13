import { CardGridService } from "./services/services-grid.js";

export class MDIview{
    
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card id=${card._couleur}><p>${card._texte}</p></card>`;	
        grid.innerHTML += cardHTML;
    }
    
    displayCardsMDI(codePartie){
        CardGridService.getGrid(codePartie).then(data => {
            data.forEach(card => {
                this.#displayCard(card);
                this.cardEventListener();
                });
            });
            
    }

    
    
    nextTurn(){
        const inputBox = document.querySelector('.input-box');
        inputBox.innerHTML = 
            `<h2>Prochain tour</h2>
            <button id="next-turn">Prochain tour</button>`;
    }
    static async cardEventListener(){
        let cardClicked = 1
        const cards = document.querySelectorAll('card')
        for(const card of cards){
            console.log("test")
            card.addEventListener('click', (target) => {
            
            if(target.target.id === "gris"){
                console.log("testgris")
            }
            if(target.target.id === "bleu"){
                if(cardClicked <= localStorage.getItem("nbcarte")){
                    let score = localStorage.getItem("score")
                    card.style.backgroundColor = "blue"
                    localStorage.setItem("score", score)
                    cardClicked += 1 
                }
                else if(cardClicked > localStorage.getItem("nbcarte")){
                    card.style.backgroundColor = "blue"
                    let score = localStorage.getItem("score")
                    localStorage.setItem("score", score)
                    cardClicked +=1 
                    console.log("update score")
                }
                
            }
            if(target.target.id === "noir"){
                console.log("testnoir")
            }
        })
        }
    }
}
