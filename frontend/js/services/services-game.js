export class GameService{
    
    static async postGameCode(id){
        const response = await fetch(`http://localhost:8080/partie/code/` + id, {
            method: 'POST',    
        })
        const data = await response.json()
        return data
    }
}