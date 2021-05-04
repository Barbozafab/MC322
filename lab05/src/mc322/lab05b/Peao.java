package mc322.lab05b;

public class Peao extends Peca {
    // Construtor
    public Peao(String tipo, int posicaoI, int posicaoJ) {
        super(tipo, posicaoI, posicaoJ);
    }

    // Verifica se o movimento solicitado é válido e condizente com o de um Peão
    public boolean verificaMovimento(int posicoesI[], int posicoesJ[], Peca pecaNaPosicao[]) {
        if (super.verificaMovimento(posicoesI, posicoesJ, pecaNaPosicao) == true) {
            if (pecaNaPosicao.length == 1) {
                if (pecaNaPosicao[0] == null) {
                    if (super.getTipo() == "b") {
                        if (posicoesI[0] == super.getPosicaoI() + 1) {
                            return true;
                        }
                    } else if (super.getTipo() == "p") {
                        if (posicoesI[0] == super.getPosicaoI() - 1) {
                            return true;
                        }
                    }
                    
                }
            } else if (pecaNaPosicao.length == 2) {
                if ((pecaNaPosicao[0] != null) && (pecaNaPosicao[1] == null)) {
                    if (super.getTipo().compareToIgnoreCase(pecaNaPosicao[0].getTipo()) != 0) {
                        super.setCapturouPeca(true);
                        super.setPecaCapturada(pecaNaPosicao[0]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}