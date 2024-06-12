
export class CardGridService {
    
    static async getGrid(codePartie){
        const response = await fetch(`http://localhost:8080/partie/code/grille/${codePartie}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        }
        );
        if(response.status === 200){
            return response.json()
        }
    }
    
}


