import {role} from "/Frontend/src/tools/curentSession.js";
import {GameService} from "/Frontend/src/service/gameService.js";
import { CardView } from "./cardView.js";



export class InGame{
    constructor(cardView, gameService){
        this.cardView = cardView;
        this.gameService = gameService;
    }

    showInGame(){
        fetch("/Frontend/html/inGame.html").then(response => response.text()).then(async (text) => {
            document.body.innerHTML = text;
            // if(role === "spyMaster"){
                await this.cardView.showCardsSpyMaster();
                let hint_box = document.createElement("div");
                hint_box.id = "hint_box";
                document.getElementById("game").appendChild(hint_box);
                let hintInput = document.createElement("input");
                hintInput.id = "hintInput";
                hintInput.type = "text";
                hintInput.placeholder = "Enter hint";
                hintInput.minLength = 1;
                document.getElementById("hint_box").appendChild(hintInput);
                let hintNumber = document.createElement("input");
                hintNumber.id = "hintNumber";
                hintNumber.type = "number";
                hintNumber.placeholder = "Enter number of cards";
                hintNumber.min = 1;
                hintNumber.max = 8;
                document.getElementById("hint_box").appendChild(hintNumber);
                let submit = document.createElement("button");
                submit.id = "submit";
                submit.placeholder = "Submit";
                document.getElementById("hint_box").appendChild(submit);
                submit.addEventListener("click", () => {
                    let hint = document.getElementById("hintInput").value;
                    let number = document.getElementById("hintNumber").value;
                    new game.setHint(hint, number);
                });
            // }
            // else if(role ==="operative"){
            //     let hint = getHint();
            //     documentgetElementById("hint").innerHTML = hint;
            // }
            //this.gameService.startTimer();
        });
    }
}