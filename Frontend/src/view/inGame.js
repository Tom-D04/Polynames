import {role} from "./tools/curentSession.js";
import {getHint} from "./tools/game.js";
import {gameService} from "./service/gameService.js";

let game = new gameService();

export class inGame{
    constructor(){
    }

    static showInGame(){
        fetch("/Frontend/html/inGame.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            if(role === "spyMaster"){
                let hint_box = document.createElement("div");
                hint_box.id = "hint_box";
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
                document.getElementById("hint_box").appendChild(hintNumber);
                let submit = document.createElement("button");
                submit.id = "submit";
                document.getElementById("hint_box").appendChild(submit);
                submit.addEventListener("click", () => {
                    let hint = document.getElementById("hintInput").value;
                    let number = document.getElementById("hintNumber").value;
                    game.setHint(hint, number);
                });
            }
            else if(role ==="operative"){
                let hint = getHint();
                documentgetElementById("hint").innerHTML = hint;
            }
            game.startTimer();
        });
    }
}