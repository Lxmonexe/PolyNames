import { CardGridService } from "../services/services-grid.js";

export class cardsView{
    constructor(){
    }
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card class=${card.couleur}>${card.mots}</card>`;	
}   
    displayCards(codePartie = "67875"){
        CardGridService.getGrid(codePartie).then(data => {
            console.log(data);
            data.forEach(card => {
                this.#displayCard(card);
            });
        });
    }
}