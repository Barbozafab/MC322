package mc322.lab05a;

public class Dama {
    // Atributos
    private String tipo;
    private int posicaoI, posicaoJ;
    private Peao peaoNE = null, peaoNO = null, peaoSO = null, peaoSE = null;
    private Dama damaNE = null, damaNO = null, damaSO = null, damaSE = null;

    // Construtor
    public Dama(String tipo, int posicaoI, int posicaoJ) {
        this.tipo = tipo;
        this.posicaoI = posicaoI;
        this.posicaoJ = posicaoJ;
    }

    // Métodos para definir vizinhos
    public void setPeaoNE(Peao peao) {
        this.peaoNE = peao;
    }
    public void setPeaoNO(Peao peao) {
        this.peaoNO = peao;
    }
    public void setPeaoSO(Peao peao) {
        this.peaoSO = peao;
    }
    public void setPeaoSE(Peao peao) {
        this.peaoSE = peao;
    }
    public void setDamaNE(Dama dama) {
        this.damaNE = dama;
    }
    public void setDamaNO(Dama dama) {
        this.damaNO = dama;
    }
    public void setDamaSO(Dama dama) {
        this.damaSO = dama;
    }
    public void setDamaSE(Dama dama) {
        this.damaSE = dama;
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
    public Peao getPeaoNE() {
        return peaoNE;
    }
    public Peao getPeaoNO() {
        return peaoNO;
    }
    public Peao getPeaoSO() {
        return peaoSO;
    }
    public Peao getPeaoSE() {
        return peaoSE;
    }
    public Dama getDamaNE() {
        return damaNE;
    }
    public Dama getDamaNO() {
        return damaNO;
    }
    public Dama getDamaSO() {
        return damaSO;
    }
    public Dama getDamaSE() {
        return damaSE;
    }

    // Verifica se o destino é uma posição atingível pela dama.
    // Retorna true se o movimento for válido ou false se for inválido.
    public boolean verificaMovimento(int intDestinoI, int intDestinoJ) {
        if (Math.abs(intDestinoI - posicaoI) == Math.abs(intDestinoJ - posicaoJ)) {
            return true;
        }
        return false;
    }
}