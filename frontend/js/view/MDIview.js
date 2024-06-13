import { CardGridService } from "../services/services-grid.js";

export class cardsViewMDI{
    
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card class=${card._couleur} id="MDI"><p>${card._texte}</p></card>`;	
        grid.innerHTML += cardHTML;
        console.log(cardHTML);
    }

    displayCardsMDI(codePartie){
        CardGridService.getGrid(codePartie).then(data => {
            //console.log(data);
            data.forEach(card => {
                this.#displayCard(card);
            });
        });
    }
}