import {GameMenu} from "./gameMenu.js";

export class RoomCode{
    constructor(){
    }

    goToMenu(){
        fetch("/Frontend/html/gameMenu.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }

    showRoomCode(){
        fetch("/Frontend/html/roomCode.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let menu = document.getElementById("menu_button");
            menu.addEventListener("click", () => {
                console.log("menu button clicked");
                new GameMenu().showGameMenu();
            });
        });
    }
}