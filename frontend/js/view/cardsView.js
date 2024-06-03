function generateCardGrid(){
    const cards = document.querySelector("gridCards")
    for(let i = 0; i < 25; i++){
        const card = document.createElement("card") 
        cards.appendChild(card)
    }
}

window.addEventListener("load", generateCardGrid)