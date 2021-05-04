package mc322.lab05b;

public class Dama extends Peca {
    // Construtor
    public Dama(String tipo, int posicaoI, int posicaoJ) {
        super(tipo, posicaoI, posicaoJ);
    }

    // Verifica se o movimento solicitado é válido e condizente com o de uma Dama
    public boolean verificaMovimento(int posicoesI[], int posicoesJ[], Peca pecaNaPosicao[]) {
        if (super.verificaMovimento(posicoesI, posicoesJ, pecaNaPosicao) == true) {
            if (pecaNaPosicao[pecaNaPosicao.length - 1] == null) {
                for (int i = 0; i < pecaNaPosicao.length - 1; i ++) {
                    if (pecaNaPosicao[i] != null) {
                        if (super.getCapturouPeca() == false) {
                            if (super.getTipo().compareToIgnoreCase(pecaNaPosicao[i].getTipo()) != 0) {
                                super.setCapturouPeca(true);
                                super.setPecaCapturada(pecaNaPosicao[i]);
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}