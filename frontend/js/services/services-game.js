export class GameService{
    
    static async postGameCode(id){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/code/${id}`, {
            method: "POST",
        });
        if (response.status === 200) {
            data = await response;    
            return data;
        }
        
        return 
    }

    static async getPartie(id){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/rejoindre/code/${id}`);
        if (response.status === 200) {
            return true;
        }
        if (response.status === 404 || response.status === 500) {
            return false;
        }
    }

    static async postHint(hint, number){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/indice/${hint}/${number}`, {
            method: "POST",
        });
        if (response.status === 200) {
            data = await response;    
            return data;
        }
    }

    static async updateScore(id, score){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/code/score/${id}/${score}`, {
            method: "POST",
        });
        if (response.status === 200) {
            data = response;    
            return data;
        }
    }

    static async nextTurn(){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/tour-suivant`, {
            method: "POST",
        });
        if (response.status === 200) {
            data = await response;    
            return data;
        }
    }

    static async endGame(id){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/fin-partie/${id}`, {
            method: "POST",
        });
        if (response.status === 200) {
            data = await response;    
            return data;
        }
    }
}