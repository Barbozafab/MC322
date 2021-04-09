package mc322.lab03;

public class AquarioLombriga {
    // Atributos
    String aquario = "";
    int tamanhoAquario, tamanhoLombriga, posicaoLombriga;
    boolean viradaParaDireita = true;
    
    // Construtor
    AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoLombriga) {
        this.tamanhoAquario = tamanhoAquario;
        this.tamanhoLombriga = tamanhoLombriga;
        this.posicaoLombriga = posicaoLombriga - 1;
        
        if (this.tamanhoLombriga > tamanhoAquario) { // Exceção -> Lombriga maior que aquário
            this.tamanhoAquario = this.tamanhoLombriga;
        }
        if (this.tamanhoLombriga + this.posicaoLombriga > tamanhoAquario) { // Exceção -> Lombriga não cabe na posição recebida
            this.posicaoLombriga = 0;
        }
        
        int n = 0;
        for (int i = 0; i < this.posicaoLombriga; i ++) {
            aquario += "#";
            n ++;
        }
        for (int j = 1; j < this.tamanhoLombriga; j ++) {
            aquario += "@";
            n ++;
        }
        aquario += "0";
        n ++;
        while (n < this.tamanhoAquario) {
            aquario += "#";
            n ++;
        }
    }
    
    // Cresce a lombriga em uma unidade, se couber no aquário
    void crescer() {
        if (viradaParaDireita == true) {
            if (posicaoLombriga > 0) {
                aquario = aquario.substring(0, posicaoLombriga - 1) + "@" + aquario.substring(posicaoLombriga);
                tamanhoLombriga ++;
                posicaoLombriga --;
            }
        } else {
            if (posicaoLombriga < tamanhoAquario - 1) {
                aquario = aquario.substring(0, posicaoLombriga) + "@" + aquario.substring(posicaoLombriga + 1);
                tamanhoLombriga ++;
                posicaoLombriga ++;
            }
        }
    }
    
    // Move a lombriga se houver espaço; caso contrário, vira-a de lado
    void mover() {
        if (viradaParaDireita == true) {
            if (posicaoLombriga + tamanhoLombriga < tamanhoAquario) {
                aquario = aquario.substring(0, posicaoLombriga) + "#" + aquario.substring(posicaoLombriga, tamanhoAquario - 1);
                posicaoLombriga ++;
            } else {
                virar();
            }
        } else {
            if (posicaoLombriga - tamanhoLombriga >= 0) {
                aquario = aquario.substring(0, posicaoLombriga - tamanhoLombriga) + aquario.substring(posicaoLombriga - tamanhoLombriga + 1) + "#";
                posicaoLombriga --;
            } else {
                virar();
            }
        }
    }
    
    // Vira a lombriga de lado
    void virar() {
        char[] aquarioChars = aquario.toCharArray();
        aquarioChars[posicaoLombriga] = '0';
        if (viradaParaDireita == true) {
            aquarioChars[posicaoLombriga + tamanhoLombriga - 1] = '@';
            posicaoLombriga = posicaoLombriga + tamanhoLombriga - 1;
            viradaParaDireita = false;
        } else {
            aquarioChars[posicaoLombriga - tamanhoLombriga + 1] = '@';
            posicaoLombriga = posicaoLombriga - tamanhoLombriga + 1;
            viradaParaDireita = true;
        }
        aquario = String.valueOf(aquarioChars);
    }
    
    // Retorna uma string com o estado atual do aquário
    String apresenta() {
        return aquario;
    }
}