import { CardGridService } from "../services/services-grid.js";

export class MDMview{
    
    hintSubmit() {
        const hint = document.querySelector('.input-box');
        hint.innerHTML = 
            `<h2>Ajouter un indice</h2>
            <input type="text" placeholder="Entrez votre indice ici" class="text-hint">
            <input type="number" placeholder="Nombre de cartes associées" class="number-hint">
            <button id="hint-box-button">Ajouter l'indice</button>`
        
    }

    hintPush(){
        const hint = document.querySelector('.text-hint').value
        const number = document.querySelector('.number-hint').value
        const hintList = document.querySelector('.hint-box')
        hintList.innerHTML += `<p>${hint} - ${number}</p>`
    }

    #displayCard(card){
        const grid = document.querySelector('gridCards');
        const cardHTML = `<card class=${card._couleur} id="MDM"><p>${card._texte}</p></card>`;	
        grid.innerHTML += cardHTML;
        
}   
    displayCardsMDM(codePartie){
        CardGridService.getGrid(codePartie).then(data => {
            data.forEach(card => {
                this.#displayCard(card);
            });
        });
    }
}