import { CardGridService } from "../services/services-grid.js";

export class MDIview{
    
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card id=${card._couleur}><p>${card._texte}</p></card>`;	
        grid.innerHTML += cardHTML;
    }
    addClicListener(){
        const cards = document.querySelectorAll('card');
        for(const card of cards){
            card.addEventListener('click', async (event) => {
                const target = event.target;
                target.style.backgroundColor = "red";
            });
        }
    }
    displayCardsMDI(codePartie){
        CardGridService.getGrid(codePartie).then(data => {
            data.forEach(card => {
                this.#displayCard(card);
                this.addClicListener();
                });
            });
            
        };
        
}
