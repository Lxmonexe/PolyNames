import {generateCardGrid} from "./view/cardsView.js"

function applyColor(){
    const cards = document.querySelectorAll("card")
    let j = 0
    let blue = 8
    let grey = 15
    let black = 2
    while(j < 25){
        let number = Math.floor(Math.random() * 25)
        if(cards[number].classList.length === 0){
            if(blue > 0){
                cards[number].classList.add("blue")
                blue--
                j++
            }else if(grey > 0){
                cards[number].classList.add("grey")
                grey--
                j++
            }else if(black > 0){
                cards[number].classList.add("black")
                black--
                j++
            }
        }
    }
}

window.addEventListener("load", generateCardGrid)
window.addEventListener("load", applyColor)