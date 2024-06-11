export class PseudoService {
    async getPseudo(){
        const response = await fetch('');
        const data = await response.json();
        return data;
    }

    async postPseudo(pseudo){
        const response = await fetch('', {
            method: 'POST',
            body: JSON.stringify(pseudo),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        });
        const data = await response.json();
        return data;
    }
}