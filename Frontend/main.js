import { RoomCode } from "./src/view/roomCode.js";

function run(){
    let roomCode = new RoomCode();
    roomCode.showRoomCode();
}

window.addEventListener("load", run);