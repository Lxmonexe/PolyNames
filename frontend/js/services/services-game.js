export class GameService{
    
    static async postGameCode(code){
        const response = await fetch(`http://localhost:8080/partie/code/:${code}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        const data = await response.json()
        return data
    }
}