export class ChooseRole{
    constructor(){
    }

    showChooseRole(){
        fetch("/Frontend/html/chooseRole.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }
}