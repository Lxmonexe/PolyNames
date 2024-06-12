export class PseudoService {
    async getPseudo(){
        const response = await fetch('');
        const data = await response.json();
        return data;
    }

    static async postPseudo(pseudo){
        const response = await fetch(`http://localhost:8080/partie/creer/joueur/${pseudo}`, {
            method: 'POST',
            body: JSON.stringify(pseudo),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        });
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }
    }
}