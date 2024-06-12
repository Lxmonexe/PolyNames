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
    
}