import {cardsView}  from "./view/cardsView.js"

function run(){
    const view = new cardsView()
    view.generateCardGrid()
}

window.addEventListener("load", run)