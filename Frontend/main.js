import { GameMenu } from "./src/view/gameMenu.js";
import { InGame } from "./src/view/inGame.js";
import { CardView } from "./src/view/cardView.js";

function run(){
    // let cardView = new CardView();
    // let inGame = new InGame(cardView);
    // inGame.showInGame();
    let gameMenu = new GameMenu();
    gameMenu.showGameMenu();
}

window.addEventListener("load", run);