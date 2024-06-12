import { CardGridService } from "../services/services-grid.js";

export class cardsView{
    constructor(){
    }
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card class=${card._couleur}><p>${card._texte}</p></card>`;	
        grid.innerHTML += cardHTML;
        console.log(cardHTML);
}   
    displayCards(codePartie = "93c3"){
        CardGridService.getGrid(codePartie).then(data => {
            //console.log(data);
            data.forEach(card => {
                this.#displayCard(card);
            });
        });
    }
}