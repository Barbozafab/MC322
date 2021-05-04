package mc322.lab05b;

public class Tabuleiro {
    // Atributos
    private Peca tab[][];
    private boolean erro;

    // Construtor
    public Tabuleiro() {
        tab = new Peca[8][8];
        erro = false;
    }

    // Insere a peça recebido no tabuleiro
    public void inserePeca(Peca peca) {
        if ((peca.getPosicaoI() >= 0) && (peca.getPosicaoI() < 8) && (peca.getPosicaoJ() >= 0) || (peca.getPosicaoJ() < 8)) {
            tab[peca.getPosicaoI()][peca.getPosicaoJ()] = peca;
        }
    }

    // Remove a peça informada do tabuleiro
    private void removePeca(Peca peca) {
        tab[peca.getPosicaoI()][peca.getPosicaoJ()] = null;
    }

    // Monta o percurso e solicita o movimento recebido à peça; se o movimento for válido, atualiza o tabuleiro
    public boolean solicitaMovimento(String comando) {
        int tamanhoPercurso;
        int posicoesI[], posicoesJ[];
        Peca pecaNaPosicao[];

        int OrigemJ = comando.charAt(0) - 97;
        int OrigemI = comando.charAt(1) - 49;
        int DestinoJ = comando.charAt(3) - 97;
        int DestinoI = comando.charAt(4) - 49;
        
        if (Math.abs(DestinoI - OrigemI) < Math.abs(DestinoJ - OrigemJ)) {
            tamanhoPercurso = Math.abs(DestinoJ - OrigemJ);
        } else {
            tamanhoPercurso = Math.abs(DestinoI - OrigemI);
        }
        
        posicoesI = new int[tamanhoPercurso];
        posicoesJ = new int[tamanhoPercurso];
        pecaNaPosicao = new Peca[tamanhoPercurso];

        erro = false;
        
        if ((DestinoI != OrigemI) && (DestinoJ != OrigemJ)) {
            if (DestinoI > OrigemI) {
                if (DestinoJ > OrigemJ) {
                    posicoesI[0] = OrigemI + 1;
                    posicoesJ[0] = OrigemJ + 1;
                    pecaNaPosicao[0] = tab[posicoesI[0]][posicoesJ[0]];
                    for (int i = 1; i < tamanhoPercurso; i ++) {
                        if (posicoesI[i - 1] != DestinoI) {
                            posicoesI[i] = posicoesI[i - 1] + 1;
                        } else {
                            posicoesI[i] = posicoesI[i - 1];
                        }
                        if (posicoesJ[i - 1] != DestinoJ) {
                            posicoesJ[i] = posicoesJ[i - 1] + 1;
                        } else {
                            posicoesJ[i] = posicoesJ[i - 1];
                        }
                        pecaNaPosicao[i] = tab[posicoesI[i]][posicoesJ[i]];
                    }
                } else {
                    posicoesI[0] = OrigemI + 1;
                    posicoesJ[0] = OrigemJ - 1;
                    pecaNaPosicao[0] = tab[posicoesI[0]][posicoesJ[0]];
                    for (int i = 1; i < tamanhoPercurso; i ++) {
                        if (posicoesI[i - 1] != DestinoI) {
                            posicoesI[i] = posicoesI[i - 1] + 1;
                        } else {
                            posicoesI[i] = posicoesI[i - 1];
                        }
                        if (posicoesJ[i - 1] != DestinoJ) {
                            posicoesJ[i] = posicoesJ[i - 1] - 1;
                        } else {
                            posicoesJ[i] = posicoesJ[i - 1];
                        }
                    }
                }
            } else {
                if (DestinoJ > OrigemJ) {
                    posicoesI[0] = OrigemI - 1;
                    posicoesJ[0] = OrigemJ + 1;
                    pecaNaPosicao[0] = tab[posicoesI[0]][posicoesJ[0]];
                    for (int i = 1; i < tamanhoPercurso; i ++) {
                        if (posicoesI[i - 1] != DestinoI) {
                            posicoesI[i] = posicoesI[i - 1] - 1;
                        } else {
                            posicoesI[i] = posicoesI[i - 1];
                        }
                        if (posicoesJ[i - 1] != DestinoJ) {
                            posicoesJ[i] = posicoesJ[i - 1] + 1;
                        } else {
                            posicoesJ[i] = posicoesJ[i - 1];
                        }
                    }
                } else {
                    posicoesI[0] = OrigemI - 1;
                    posicoesJ[0] = OrigemJ - 1;
                    pecaNaPosicao[0] = tab[posicoesI[0]][posicoesJ[0]];
                    for (int i = 1; i < tamanhoPercurso; i ++) {
                        if (posicoesI[i - 1] != DestinoI) {
                            posicoesI[i] = posicoesI[i - 1] - 1;
                        } else {
                            posicoesI[i] = posicoesI[i - 1];
                        }
                        if (posicoesJ[i - 1] != DestinoJ) {
                            posicoesJ[i] = posicoesJ[i - 1] - 1;
                        } else {
                            posicoesJ[i] = posicoesJ[i - 1];
                        }
                    }
                }
            }
        } else {
            erro = true;
            return false;
        }

        if (tab[OrigemI][OrigemJ].verificaMovimento(posicoesI, posicoesJ, pecaNaPosicao) == true) {
            if (tab[OrigemI][OrigemJ].getTipo() == "b") {
                if (DestinoI == 7) {
                    inserePeca(new Dama("B", DestinoI, DestinoJ));
                } else {
                    inserePeca(new Peao("b", DestinoI, DestinoJ));  
                }
            } else if (tab[OrigemI][OrigemJ].getTipo() == "p") {
                if (DestinoI == 0) {
                    inserePeca(new Dama("P", DestinoI, DestinoJ));
                } else {
                    inserePeca(new Peao("p", DestinoI, DestinoJ));  
                }
            } else {
                inserePeca(new Dama(tab[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
            }
            
            if (tab[OrigemI][OrigemJ].getCapturouPeca() == true) {
                removePeca(tab[OrigemI][OrigemJ].getPecaCapturada());
            }
            
            removePeca(tab[OrigemI][OrigemJ]); 
            return true;
        }
        erro = true;
        return false;
    }

    // Imprime o estado atual do tabuleiro
    public String imprimirTabuleiro() {
        String saida = "";
        for (int i = 0; i < 8; i ++) {
            System.out.print(i + 1);
            for (int j = 0; j < 8; j ++) {
                System.out.print(" " + ((tab[i][j] != null) ? tab[i][j].getTipo() : "-"));
                saida += ((tab[i][j] != null) ? tab[i][j].getTipo() : "-");
            }
            System.out.println();
            saida += "\n";
        }
        System.out.println("  a b c d e f g h");
        System.out.println();
        return saida;
    }

    // Registra o estado atual do tabuleiro no arquivo .csv indicado
    public void exportarArquivo(String caminhoSaida) {
        CSVHandling csv = new CSVHandling();
        csv.setDataExport(caminhoSaida);

        String estado[];
        int n = 0;

        if (erro == false) {
            estado = new String[64];
        } else {
            estado = new String[1];
        }

        if (erro == false) {
            for (int j = 0; j < 8; j ++) {
                for (int i = 0; i < 8; i ++) {
                    if (tab[i][j] ==  null) {
                        estado[n] = "" + (char)(j + 97) + (char)(i + 49) + "_";
                    } else {
                        estado[n] = "" + (char)(j + 97) + (char)(i + 49) + tab[i][j].getTipo();
                    }
                    n ++;
                }
            }
        } else {
            estado[n] = "erro";
        }

        csv.exportState(estado);
    }
}