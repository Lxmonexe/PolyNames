export class cardsView{
    constructor(){
    }
    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card class=${card.couleur}>${card.mots}</card>`;	
}   

}