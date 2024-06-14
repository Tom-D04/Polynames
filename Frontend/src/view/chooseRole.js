export class ChooseRole{
    constructor(){
    }

    showChooseRole(){
        fetch("/Frontend/html/chooseRole.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
            let spyMaster = document.getElementById("spy_master");
            let operative = document.getElementById("operative");
            spyMaster.addEventListener("click", );
            operative.addEventListener("click", );
        });
    }

    
}