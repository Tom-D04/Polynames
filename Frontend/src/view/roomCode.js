export class RoomCode{
    constructor(){
    }

    cancel(){
        // Go back to the game menu
        fetch("\Polynames\Frontend\src\view\gameMenu.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }

    showRoomCode(){
        fetch("\Polynames\Frontend\src\view\roomCode.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let cancel = document.getElementById("cancel_join");
            cancel.addEventListener("click", this.cancel);
        });
    }
}