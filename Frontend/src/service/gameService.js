export class gameService{
    constructor(){
        this.time = 0;
        this.timer = this.startTimer();
    }

    static async getHint(){
        const response = await fetch('http://localhost:8081/hint');
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    static async setHint(hint, number){
        const response = await fetch('http://localhost:8081/sethint', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                hint: hint,
                number: number
                })
        });
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    startTimer(){
        return setInterval(() =>{
            let time = 0;
            let showTime = 0;
            time++;

            if(time < 10){
                showTime = "0" + time;
            }
            else{
                showTime = time;
            }
            document.getElementById("timer").innerHTML = showTime;
        }, 1000);
    }
}