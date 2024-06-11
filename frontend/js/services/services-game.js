export class GameService{
    
    static async postGameCode(id){
        let data = null;
        const response = await fetch(`http://localhost:8080/partie/code/:${id}`, {
            method: "POST",
            
        });
        if (response.status === 200) {
            data = await response.json();    
            return data
        }
        
        return null
    }
}