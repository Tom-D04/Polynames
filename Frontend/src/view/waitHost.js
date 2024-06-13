export class waitHost{
    constructor(){
    }

    showWaitHost(){
        fetch("/Frontend/html/waitHost.html").then(response => response.text()).then(text => {
            document.body.innerHTML = text;
        });
    }
}