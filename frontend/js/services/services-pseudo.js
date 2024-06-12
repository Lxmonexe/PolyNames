export class PseudoService {
    async getPseudo(){
        const response = await fetch('');
        const data = await response.json();
        return data;
    }

    static async postPseudo(pseudo, codePartie){
        const response = await fetch(`http://localhost:8080/partie/creer/joueur/${codePartie}/${pseudo}`, {
            method: 'POST',
        });
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }
    }


}