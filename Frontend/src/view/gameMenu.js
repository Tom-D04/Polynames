export class GameMenu{
    constructor(){
    }

    createGame(){
        fetch("/Frontend/html/roomCode.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }

    joinGame(){
        fetch("/Frontend/html/waitHost.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }

    showGameMenu(){
        fetch("/Frontend/html/gameMenu.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let create = document.getElementById("create_game");
            let join = document.getElementById("join_game");
            create.addEventListener("click", this.createGame);
            join.addEventListener("click", this.joinGame);
        });
    }
}