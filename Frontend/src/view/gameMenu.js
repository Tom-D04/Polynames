export class GameMenu{
    constructor(){
    }

    createGame(){

    }

    joinGame(){

    }

    showGameMenu(){
        fetch("\Polynames\Frontend\src\view\gameMenu.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }
}