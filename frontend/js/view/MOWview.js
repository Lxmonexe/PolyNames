export class MOWview{
    
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

    displayMOW(){
        const cards = document.querySelectorAll("card");
        for(const card of cards){
            if(card.classList === "gris"){
                card.classList.remove("gris");
                card.classList.add("grey");
            }
            else if(card.id === "bleu"){
                card.classList.remove("bleu");
                card.classList.add("blue");
            }
            else if(card.id === "noir"){
                card.classList.remove("noir");
                card.classList.add("black");
            }
        }
        
        
        
    }
}