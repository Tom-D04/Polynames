export class CardService{
    constructor(){
    }

    static async getCards(){
        const response = await fetch('http://localhost:8081/getcards');
        if(response.status === 200){
            let data = await response.json();
            return data;
        }
    }

    // static async selectCard(){
    //     const response = await fetch('http://localhost:8081/selectcard');
    //     if(response.status === 200){
    //         let data = await response.json();
    //         return data;
    //     }
    // }
}