package mc322.lab05a;

public class Tabuleiro {
    // Atributos
    private Peao tabPeao[][];
    private Dama tabDama[][];

    // Construtor
    public Tabuleiro() {
        tabPeao = new Peao[8][8];
        tabDama = new Dama[8][8];
    }

    // Insere o peão recebido no tabuleiro
    public void inserePeao(Peao peao) {
        if (peao.getPosicaoI() < 8 && peao.getPosicaoJ() < 8) {
            tabPeao[peao.getPosicaoI()][peao.getPosicaoJ()] = peao;
            if (peao.getPosicaoI() > 0) {
                if (peao.getPosicaoJ() > 0) {
                    peao.setPeaoNO(tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1]);
                    if (tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1] != null) {
                        tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1].setPeaoSE(peao);
                    }
                    peao.setDamaNO(tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1]);
                    if (tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1] != null) {
                        tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1].setPeaoSE(peao);
                    }
                } else {
                    peao.setPeaoNO(null);
                    peao.setDamaNO(null);
                }
                if (peao.getPosicaoJ() < 7) {
                    peao.setPeaoNE(tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1]);
                    if (tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1] != null) {
                        tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1].setPeaoSO(peao);
                    }
                    peao.setDamaNE(tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1]);
                    if (tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1] != null) {
                        tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1].setPeaoSO(peao);
                    }
                } else {
                    peao.setPeaoNE(null);
                    peao.setDamaNE(null);
                }
            } 
            if (peao.getPosicaoI() < 7) {
                if (peao.getPosicaoJ() > 0) {
                    peao.setPeaoSO(tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1]);
                    if (tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1] != null) {
                        tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1].setPeaoNE(peao);
                    }
                    peao.setDamaSO(tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1]);
                    if (tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1] != null) {
                        tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1].setPeaoNE(peao);
                    }
                } else {
                    peao.setPeaoSO(null);
                    peao.setDamaSO(null);
                }
                if (peao.getPosicaoJ() < 7) {
                    peao.setPeaoSE(tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1]);
                    if (tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1] != null) {
                        tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1].setPeaoNO(peao);
                    }
                    peao.setDamaSE(tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1]);
                    if (tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1] != null) {
                        tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1].setPeaoNO(peao);
                    }
                } else {
                    peao.setPeaoSE(null);
                    peao.setDamaSE(null);
                }
            } 
        }
    }

    // Insere a dama recebida no tabuleiro
    public void insereDama(Dama dama) {
        if (dama.getPosicaoI() < 8 && dama.getPosicaoJ() < 8) {
            tabDama[dama.getPosicaoI()][dama.getPosicaoJ()] = dama;
            if (dama.getPosicaoI() > 0) {
                if (dama.getPosicaoJ() > 0) {
                    dama.setPeaoNO(tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1]);
                    if (tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1] != null) {
                        tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1].setDamaSE(dama);
                    }
                    dama.setDamaNO(tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1]);
                    if (tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1] != null) {
                        tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1].setDamaSE(dama);
                    }
                } else {
                    dama.setPeaoNO(null);
                    dama.setDamaNO(null);
                }
                if (dama.getPosicaoJ() < 7) {
                    dama.setPeaoNE(tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1]);
                    if (tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1] != null) {
                        tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1].setDamaSO(dama);
                    }
                    dama.setDamaNE(tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1]);
                    if (tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1] != null) {
                        tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1].setDamaSO(dama);
                    }
                } else {
                    dama.setPeaoNE(null);
                    dama.setDamaNE(null);
                }
            } 
            if (dama.getPosicaoI() < 7) {
                if (dama.getPosicaoJ() > 0) {
                    dama.setPeaoSO(tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1]);
                    if (tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1] != null) {
                        tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1].setDamaNE(dama);
                    }
                    dama.setDamaSO(tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1]);
                    if (tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1] != null) {
                        tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1].setDamaNE(dama);
                    }
                } else {
                    dama.setPeaoSO(null);
                    dama.setDamaSO(null);
                }
                if (dama.getPosicaoJ() < 7) {
                    dama.setPeaoSE(tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1]);
                    if (tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1] != null) {
                        tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1].setDamaNO(dama);
                    }
                    dama.setDamaSE(tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1]);
                    if (tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1] != null) {
                        tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1].setDamaNO(dama);
                    }
                } else {
                    dama.setPeaoSE(null);
                    dama.setDamaSE(null);
                }
            } 
        }
    }

    // Remove o peão indicado do tabuleiro
    private void removePeao(Peao peao) {
        if (peao.getPosicaoI() > 0) {
            if (peao.getPosicaoJ() > 0) {
                if (tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1] != null) {
                    tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1].setPeaoSE(null);
                }
                if (tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1] != null) {
                    tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() - 1].setPeaoSE(null);
                }
            }
            if (peao.getPosicaoJ() < 7) {
                if (tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1] != null) {
                    tabPeao[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1].setPeaoNE(null);
                }
                if (tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1] != null) {
                    tabDama[peao.getPosicaoI() - 1][peao.getPosicaoJ() + 1].setPeaoNE(null);
                }
            }
        }
        if (peao.getPosicaoI() < 7) {
            if (peao.getPosicaoJ() > 0) {
                if (tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1] != null) {
                    tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1].setPeaoSO(null);
                }
                if (tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1] != null) {
                    tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() - 1].setPeaoSO(null);
                }
            }
            if (peao.getPosicaoJ() < 7) {
                if (tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1] != null) {
                    tabPeao[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1].setPeaoNO(null);
                }
                if (tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1] != null) {
                    tabDama[peao.getPosicaoI() + 1][peao.getPosicaoJ() + 1].setPeaoNO(null);
                }
            }
        }
        tabPeao[peao.getPosicaoI()][peao.getPosicaoJ()] = null;
    }
    
    // Remove a dama indicada do tabuleiro
    private void removeDama(Dama dama) {
        if (dama.getPosicaoI() > 0) {
            if (dama.getPosicaoJ() > 0) {
                if (tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1] != null) {
                    tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1].setDamaSE(null);
                }
                if (tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1] != null) {
                    tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() - 1].setDamaSE(null);
                }
            }
            if (dama.getPosicaoJ() < 7) {
                if (tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1] != null) {
                    tabPeao[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1].setDamaNE(null);
                }
                if (tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1] != null) {
                    tabDama[dama.getPosicaoI() - 1][dama.getPosicaoJ() + 1].setDamaNE(null);
                }
            }
        }
        if (dama.getPosicaoI() < 7) {
            if (dama.getPosicaoJ() > 0) {
                if (tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1] != null) {
                    tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1].setDamaSO(null);
                }
                if (tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1] != null) {
                    tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() - 1].setDamaSO(null);
                }
            }
            if (dama.getPosicaoJ() < 7) {
                if (tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1] != null) {
                    tabPeao[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1].setDamaNO(null);    
                }
                if (tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1] != null) {
                    tabDama[dama.getPosicaoI() + 1][dama.getPosicaoJ() + 1].setDamaNO(null);
                }
            }
        }
        tabDama[dama.getPosicaoI()][dama.getPosicaoJ()] = null;
    }
    
    // Executa o movimento pedido.
    // Retorna true se o movimento for válido ou false se for inválido.
    public boolean executaMovimento(String comando) {
        int OrigemJ = comando.charAt(0) - 97;
        int OrigemI = Math.abs(comando.charAt(1) - 56);
        int DestinoJ = comando.charAt(3) - 97;
        int DestinoI = Math.abs(comando.charAt(4) - 56);

        if (tabPeao[OrigemI][OrigemJ] != null) {
            if (tabPeao[OrigemI][OrigemJ].verificaMovimento(DestinoI, DestinoJ) == true) {
                if (tabPeao[OrigemI][OrigemJ].getTipo() == "b" && DestinoI == 0) {
                    insereDama(new Dama("B", DestinoI, DestinoJ));
                } else if (tabPeao[OrigemI][OrigemJ].getTipo() == "p" && DestinoI == 7) {
                    insereDama(new Dama("P", DestinoI, DestinoJ));
                } else {
                    inserePeao(new Peao(tabPeao[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
                }
                if (tabPeao[OrigemI][OrigemJ].capturouPeao() == true) {
                    removePeao(tabPeao[tabPeao[OrigemI][OrigemJ].getPosicaoCapturadoI()][tabPeao[OrigemI][OrigemJ].getPosicaoCapturadoJ()]);
                }
                if (tabPeao[OrigemI][OrigemJ].capturouDama() == true) {
                    removeDama(tabDama[tabPeao[OrigemI][OrigemJ].getPosicaoCapturadoI()][tabPeao[OrigemI][OrigemJ].getPosicaoCapturadoJ()]);
                }
                removePeao(tabPeao[OrigemI][OrigemJ]);
                return true;
            }
        }
        if (tabDama[OrigemI][OrigemJ] != null) {
            boolean capturouPeao = false, capturouDama = false;
            int posicaoCapturadoI = -1, posicaoCapturadoJ = -1;
            if (tabDama[OrigemI][OrigemJ].verificaMovimento(DestinoI, DestinoJ) == true) {
                if ((tabPeao[DestinoI][DestinoJ] == null) && (tabDama[DestinoI][DestinoJ] == null)) {
                    if (DestinoI > OrigemI) {
                        if (DestinoJ > OrigemJ) {
                            for (int n = 1; n <= Math.abs(DestinoI - OrigemI); n ++) {
                                if (tabPeao[OrigemI + n][OrigemJ + n] != null) {
                                    posicaoCapturadoI = OrigemI + n;
                                    posicaoCapturadoJ = OrigemJ + n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabPeao[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouPeao = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                                if (tabDama[OrigemI + n][OrigemJ + n] != null) {
                                    posicaoCapturadoI = OrigemI + n;
                                    posicaoCapturadoJ = OrigemJ + n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabDama[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouDama = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                            }
                            if (capturouPeao == true) {
                                if ((DestinoI == posicaoCapturadoI + 1) && (DestinoJ == posicaoCapturadoJ + 1)) {
                                    removePeao(tabPeao[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            if (capturouDama == true) {
                                if ((DestinoI == posicaoCapturadoI + 1) && (DestinoJ == posicaoCapturadoJ + 1)) {
                                    removeDama(tabDama[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            insereDama(new Dama(tabDama[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
                            removeDama(tabDama[OrigemI][OrigemJ]);
                            return true;
                        }
                        if (DestinoJ < OrigemJ) {
                            for (int n = 1; n <= Math.abs(DestinoI - OrigemI); n ++) {
                                if (tabPeao[OrigemI + n][OrigemJ - n] != null) {
                                    posicaoCapturadoI = OrigemI + n;
                                    posicaoCapturadoJ = OrigemJ - n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabPeao[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouPeao = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                                if (tabDama[OrigemI + n][OrigemJ - n] != null) {
                                    posicaoCapturadoI = OrigemI + n;
                                    posicaoCapturadoJ = OrigemJ - n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabDama[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouDama = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                            }
                            if (capturouPeao == true) {
                                if ((DestinoI == posicaoCapturadoI + 1) && (DestinoJ == posicaoCapturadoJ - 1)) {
                                    removePeao(tabPeao[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            if (capturouDama == true) {
                                if ((DestinoI == posicaoCapturadoI + 1) && (DestinoJ == posicaoCapturadoJ - 1)) {
                                    removeDama(tabDama[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            insereDama(new Dama(tabDama[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
                            removeDama(tabDama[OrigemI][OrigemJ]);
                            return true;
                        }
                    }
                    if (DestinoI < OrigemI) {
                        if (DestinoJ > OrigemJ) {
                            for (int n = 1; n <= Math.abs(DestinoI - OrigemI); n ++) {
                                if (tabPeao[OrigemI - n][OrigemJ + n] != null) {
                                    posicaoCapturadoI = OrigemI - n;
                                    posicaoCapturadoJ = OrigemJ + n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabPeao[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouPeao = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                                if (tabDama[OrigemI - n][OrigemJ + n] != null) {
                                    posicaoCapturadoI = OrigemI - n;
                                    posicaoCapturadoJ = OrigemJ + n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabDama[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouDama = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                            }
                            if (capturouPeao == true) {
                                if ((DestinoI == posicaoCapturadoI - 1) && (DestinoJ == posicaoCapturadoJ + 1)) {
                                    removePeao(tabPeao[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            if (capturouDama == true) {
                                if ((DestinoI == posicaoCapturadoI - 1) && (DestinoJ == posicaoCapturadoJ + 1)) {
                                    removeDama(tabDama[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            insereDama(new Dama(tabDama[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
                            removeDama(tabDama[OrigemI][OrigemJ]);
                            return true;
                        }
                        if (DestinoJ < OrigemJ) {
                            for (int n = 1; n <= Math.abs(DestinoI - OrigemI); n ++) {
                                if (tabPeao[OrigemI - n][OrigemJ - n] != null) {
                                    posicaoCapturadoI = OrigemI - n;
                                    posicaoCapturadoJ = OrigemJ - n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabPeao[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouPeao = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                                if (tabDama[OrigemI - n][OrigemJ - n] != null) {
                                    posicaoCapturadoI = OrigemI - n;
                                    posicaoCapturadoJ = OrigemJ - n;
                                    if (tabDama[OrigemI][OrigemJ].getTipo().compareToIgnoreCase(tabDama[posicaoCapturadoI][posicaoCapturadoJ].getTipo()) != 0) {
                                        capturouDama = true;
                                    } else {
                                        return false;
                                    }
                                    break;
                                }
                            }
                            if (capturouPeao == true) {
                                if ((DestinoI == posicaoCapturadoI - 1) && (DestinoJ == posicaoCapturadoJ - 1)) {
                                    removePeao(tabPeao[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            if (capturouDama == true) {
                                if ((DestinoI == posicaoCapturadoI - 1) && (DestinoJ == posicaoCapturadoJ - 1)) {
                                    removeDama(tabDama[posicaoCapturadoI][posicaoCapturadoJ]);
                                } else {
                                    return false;
                                }
                            }
                            insereDama(new Dama(tabDama[OrigemI][OrigemJ].getTipo(), DestinoI, DestinoJ));
                            removeDama(tabDama[OrigemI][OrigemJ]);
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("* Movimento Inválido *");
        return false;
    }

    // Imprime o tabuleiro e retorna uma String contendo o estado atual do tabuleiro
    public String mostraTabuleiro() {
        int n = 8;
        String saida = "";
        for (int i = 0; i < 8; i ++) {
            System.out.print(n);
            for (int j = 0; j < 8; j ++) {
                System.out.print(" " + ((tabDama[i][j] != null) ? tabDama[i][j].getTipo() : ((tabPeao[i][j] != null) ? tabPeao[i][j].getTipo() : "-")));
                saida += ((tabDama[i][j] != null) ? tabDama[i][j].getTipo() : ((tabPeao[i][j] != null) ? tabPeao[i][j].getTipo() : "-"));
            }
            System.out.println();
            saida += "\n";
            n --;
        }
        System.out.println("  a b c d e f g h");
        System.out.println();
        return saida;
    }
}