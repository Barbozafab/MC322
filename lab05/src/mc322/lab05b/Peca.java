package mc322.lab05b;

public class Peca {
    // Atributos
    private String tipo;
    private int posicaoI, posicaoJ;
    private boolean capturouPeca;
    private Peca pecaCapturada;

    // Construtor
    public Peca(String tipo, int posicaoI, int posicaoJ) {
        this.tipo = tipo;
        this.posicaoI = posicaoI;
        this.posicaoJ = posicaoJ;
        capturouPeca = false;
    }

    // Métodos para definir variáveis
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCapturouPeca(boolean capturouPeca) {
        this.capturouPeca = capturouPeca;
    }
    public void setPecaCapturada(Peca pecaCapturada) {
        this.pecaCapturada = pecaCapturada;
    }
    
    // Métodos para obter informações do objeto
    public String getTipo() {
        return tipo;
    }
    public int getPosicaoI() {
        return posicaoI;
    }
    public int getPosicaoJ() {
        return posicaoJ;
    }
    public boolean getCapturouPeca() {
        return capturouPeca;
    }
    public Peca getPecaCapturada() {
        return pecaCapturada;
    }

    // Verifica se o movimento é em diagonal e se, em todo o percurso, a peça permanece dentro do tabuleiro
    public boolean verificaMovimento(int posicoesI[], int posicoesJ[], Peca pecaNaPosicao[]) {
        if (Math.abs(posicoesI[posicoesI.length - 1] - posicaoI) == Math.abs(posicoesJ[posicoesJ.length - 1] - posicaoJ)) {
            for (int i = 0; i < posicoesI.length; i ++) {
                if ((posicoesI[i] < 0) || (posicoesI[i] > 7) || (posicoesJ[i] < 0) || (posicoesJ[i] > 7)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    } 
}