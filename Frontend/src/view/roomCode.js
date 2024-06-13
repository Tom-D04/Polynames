export class RoomCode{
    constructor(){
    }

    cancel(){
        fetch("/Frontend/html/gameMenu.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }

    showRoomCode(){
        fetch("/Frontend/html/roomCode.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let cancel = document.getElementById("cancel_join");
            cancel.addEventListener("click", this.cancel);
        });
    }
}