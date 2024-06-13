import { GameMenu } from "./src/view/gameMenu.js";

function run(){
    let gameMenu = new GameMenu();
    gameMenu.showGameMenu();
}

window.addEventListener("load", run);