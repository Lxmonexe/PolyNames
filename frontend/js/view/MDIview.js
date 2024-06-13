import { CardGridService } from "../services/services-grid.js";

export class MDIview{
    
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card id=${card._couleur}><p>${card._texte}</p></card>`;	
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