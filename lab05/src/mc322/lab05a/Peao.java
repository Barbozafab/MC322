package mc322.lab05a;

public class Peao {
    // Atributos
    private String tipo;
    private int posicaoI, posicaoJ;
    private Peao peaoNE = null, peaoNO = null, peaoSO = null, peaoSE = null;
    private Dama damaNE = null, damaNO = null, damaSO = null, damaSE = null;
    private boolean capturouPeao, capturouDama;
    private int posicaoCapturadoI, posicaoCapturadoJ;

    // Construtor
    public Peao(String tipo, int posicaoI, int posicaoJ) {
        this.tipo = tipo;
        this.posicaoI = posicaoI;
        this.posicaoJ = posicaoJ;
        capturouPeao = false;
        capturouDama = false;
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
    public boolean capturouPeao() {
        return capturouPeao;
    }
    public boolean capturouDama() {
        return capturouDama;
    }
    public int getPosicaoCapturadoI() {
        return posicaoCapturadoI;
    }
    public int getPosicaoCapturadoJ() {
        return posicaoCapturadoJ;
    }

    // Verifica se o destino é uma posição atingível pelo peão e
    // se o movimento é permitido de acordo com as regras do jogo.
    // Retorna true se o movimento for válido ou false se for inválido. 
    public boolean verificaMovimento(int intDestinoI, int intDestinoJ) {
        if (Math.abs(intDestinoI - posicaoI) == Math.abs(intDestinoJ - posicaoJ)) {
            if (intDestinoI == posicaoI + 1) {
                if (tipo == "p") {
                    if (intDestinoJ == posicaoJ + 1) {
                        if (peaoSE == null && damaSE == null) {
                            return true;
                        }
                    }
                    if (intDestinoJ == posicaoJ - 1) {
                        if (peaoSO == null && damaSO == null) {
                            return true;
                        }
                    }
                }
            } 
            if (intDestinoI == posicaoI - 1) {
                if (tipo == "b") {
                    if (intDestinoJ == posicaoJ + 1) {
                        if (peaoNE == null && damaNE == null) {
                            return true;
                        }
                    }
                    if (intDestinoJ == posicaoJ - 1) {
                        if (peaoNO == null && damaNO == null) {
                            return true;
                        }
                    }
                }
            } 
            if (intDestinoI == posicaoI + 2) {
                if (intDestinoJ == posicaoJ + 2) {
                    if ((peaoSE != null) && (tipo.compareToIgnoreCase(peaoSE.getTipo()) != 0) && (peaoSE.getPeaoSE() == null) && (peaoSE.getDamaSE() == null)) {
                        capturouPeao = true;
                    }
                    if ((damaSE != null) && (tipo.compareToIgnoreCase(damaSE.getTipo()) != 0) && (damaSE.getPeaoSE() == null) && (damaSE.getDamaSE() == null)) {
                        capturouDama = true;
                    }
                    if (capturouPeao == true || capturouDama == true) {
                        posicaoCapturadoI = posicaoI + 1;
                        posicaoCapturadoJ = posicaoJ + 1;
                        return true;
                    }
                }
                if (intDestinoJ == posicaoJ - 2) {
                    if ((peaoSO != null) && (tipo.compareToIgnoreCase(peaoSO.getTipo()) != 0) && (peaoSO.getPeaoSO() == null) && (peaoSO.getDamaSO() == null)) {
                        capturouPeao = true;
                    }
                    if ((damaSO != null) && (tipo.compareToIgnoreCase(damaSO.getTipo()) != 0) && (damaSO.getPeaoSO() == null) && (damaSO.getDamaSO() == null)) {
                        capturouDama = true;
                    }
                    if (capturouPeao == true || capturouDama == true) {
                        posicaoCapturadoI = posicaoI + 1;
                        posicaoCapturadoJ = posicaoJ - 1;
                        return true;
                    }
                }
            }
            if (intDestinoI == posicaoI - 2) {
                if (intDestinoJ == posicaoJ + 2) {
                    if ((peaoNE != null) && (tipo.compareToIgnoreCase(peaoNE.getTipo()) != 0) && (peaoNE.getPeaoNE() == null) && (peaoNE.getDamaNE() == null)) {
                        capturouPeao = true;
                    }
                    if ((damaNE != null) && (tipo.compareToIgnoreCase(damaNE.getTipo()) != 0) && (damaNE.getPeaoNE() == null) && (damaNE.getDamaNE() == null)) {
                        capturouDama = true;
                    }
                    if (capturouPeao == true || capturouDama == true) {
                        posicaoCapturadoI = posicaoI - 1;
                        posicaoCapturadoJ = posicaoJ + 1;
                        return true;
                    }
                }
                if (intDestinoJ == posicaoJ - 2) {
                    if ((peaoNO != null) && (tipo.compareToIgnoreCase(peaoNO.getTipo()) != 0) && (peaoNO.getPeaoNO() == null) && (peaoNO.getDamaNO() == null)) {
                        capturouPeao = true;
                    }
                    if ((damaNO != null) && (tipo.compareToIgnoreCase(damaNO.getTipo()) != 0) && (damaNO.getPeaoNO() == null) && (damaNO.getDamaNO() == null)) {
                        capturouDama = true;
                    }
                    if (capturouPeao == true || capturouDama == true) {
                        posicaoCapturadoI = posicaoI - 1;
                        posicaoCapturadoJ = posicaoJ - 1;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}