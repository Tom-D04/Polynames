export class CardService{
    constructor(){
    }

    static async getCards(){
        const response = await fetch('http://localhost:8080/getcards');
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    static async getWord(){
        const response = await fetch('http://localhost:8080/getword');
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    static async getWordById(id){
        const response = await fetch(`http://localhost:8080/getword/${id}`);
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    static async selectCard(){
        const response = await fetch('http://localhost:8080/selectcard');
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }
}