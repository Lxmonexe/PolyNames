export class MOWview{
    
    hintSubmit() {
        const hint = document.querySelector('.input-box');
        hint.innerHTML = 
            `<h2>Ajouter un indice</h2>
            <input type="text" placeholder="Entrez votre indice ici" class="text-hint">
            <input type="number" placeholder="Nombre de cartes associées" class="number-hint">
            <button id="hint-box-button">Ajouter l'indice</button>`
        
    }
}