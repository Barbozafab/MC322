package mc322.lab03;

public class Animacao {
    // Atributos
    String animacao;
    char[] animacaoChars;
    int passoAtual;
    AquarioLombriga umaLombriga;
    
    // Construtor
    Animacao(String animacao) {
        this.animacao = animacao;
        this.animacaoChars = this.animacao.toCharArray();
        passoAtual = 6;
        umaLombriga = new AquarioLombriga(Integer.parseInt(this.animacao.substring(0, 2)), 
                                          Integer.parseInt(this.animacao.substring(2, 4)),
                                          Integer.parseInt(this.animacao.substring(4, 6)));
    }
    
    // Retorna uma string com o estado atual do aquário
    String apresenta() {
        String apresentacao = umaLombriga.apresenta();
        return apresentacao;
    }
    
    // Executa um passo da animação da lombriga
    void passo() {
        switch (animacaoChars[passoAtual]) {
            case 'C':
                umaLombriga.crescer();
                break;
            case 'M':
                umaLombriga.mover();
                break;
            case 'V':
                umaLombriga.virar();
                break;
        }
        passoAtual ++;
    }
}