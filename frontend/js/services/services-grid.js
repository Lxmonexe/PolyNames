export class CardGridService {

    static async createGrid(codePartie){
        const response = await fetch(`http://localhost:8080/partie/code/creer/grille/${codePartie}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }
        );
        if(response.status === 200){
            return response
        }
    }
    
    static async getGrid(codePartie){
        const response = await fetch(`http://localhost:8080/partie/code/grille/${codePartie}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        }
        );
        if(response.status === 200){
            const data = await response.json();
            return data
        }
    }

    static async carteDecouverte(codePartie, mot){
        const response = await fetch(`http://localhost:8080/partie/grille/${codePartie}/${mot}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }
        );
        if(response.status === 200){
            return response
        }
    }
}


