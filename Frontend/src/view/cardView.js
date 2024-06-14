export class CardView{
    constructor(){
    }

    static async showCardsSpyMaster(){
        const cards = await CardService.getCards();
        cards.forEach(card =>{
            this.#showCardSpyMaster(card);
            console.log(card);
        })
    }

    static #showCardSpyMaster(cardInfo){
        const card = document.createElement('div');
        card.classList.add('card');
        document.querySelector('.cards').appendChild(grid);
        grid.innerHTML = `
            <button style="background-color: ${cardInfo.color}, id=${cardInfo.word}> ${cardInfo.word} </button>
            `;
    }

    static async showCardsOperative(){
        const cards = await CardService.getCards();
        cards.forEach(card =>{
            this.#showCardOperative(card);
            console.log(card);
        })
    }

    static #showCardOperative(cardInfo){
        const card = document.createElement('div');
        card.classList.add('card');
        document.querySelector('.cards').appendChild(grid);
        grid.innerHTML = `
            <button id=${cardInfo.word}> ${cardInfo.word} </button>
            `;
        document.getElementById(cardInfo.word).addEventListener('click', async () => {
            document.getElementById(cardInfo.word).style.backgroundColor = cardInfo.color;
            document.getElementById(cardInfo.word).disabled = true;
        });
    }

}