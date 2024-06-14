import { setRole } from "../tools/curentSession";
import { InGame } from "./inGame";


export class ChooseRole{
    constructor(inGame){
        this.inGame = inGame;
    }

    showChooseRole(){
        fetch("/Frontend/html/chooseRole.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let spyMaster = document.getElementById("spy_master");
            let operative = document.getElementById("operative");
            spyMaster.addEventListener("click", () => {
                setRole("spyMaster");
                this.inGame.showInGame();
            });
            operative.addEventListener("click", () => {
                setRole("operative");
                this.inGame.showInGame();
            });
        });
    }
}