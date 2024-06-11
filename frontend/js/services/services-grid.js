
export class CardGridService {
    
    async getCardsd(){
        const response = await fetch('');
        const data = await response.json();
        return data;
    }
    
}


