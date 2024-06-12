import {cardsView}  from "./view/cardsView.js"
import { MOWview } from "./view/MOWview.js"
import { CardGridService } from "./services/services-grid.js";


async function run(){
    const view = new cardsView()
    
    const viewMOW = new MOWview()
    await view.displayCards().then(() => {
    viewMOW.displayMOW()
    });
    //hintButton()
}



function hintButton(){
    const view = new MOWview()
    view.hintSubmit()
    const hintButton = document.querySelector('hint-box-button')
    hintButton.addEventListener('click', hintPush)
}

function hintPush(){
    const hint = document.querySelector('.text-hint').value
    const number = document.querySelector('.number-hint').value
    const hintList = document.querySelector('.hint-box')
    hintList.innerHTML += `<p>${hint} - ${number}</p>`
}

window.addEventListener("load", run)