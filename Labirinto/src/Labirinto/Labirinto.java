package Labirinto;

import Estruturas.Pilha.LinkedStack;

import java.util.ArrayList;

public class Labirinto {
    LP labirinto[];
    LinkedStack pilha;
    LP temporario;
    ArrayList<LP> labirintoExtra = new ArrayList<LP>();
    ArrayList<LP> caminho = new ArrayList<LP>();;


    public Labirinto(LP labirinto[], LP entrada, LP saida) {
        this.labirinto = labirinto;
        pilha = new LinkedStack();
        var tempoComeco = System.currentTimeMillis();
        resolverLabirinto(entrada, saida);
        var tempoFinal = System.currentTimeMillis();
        var tempo = tempoFinal - tempoComeco;
        System.out.println("Tempo: " + tempo + "ms");
    }

    private void resolverLabirinto(LP entrada, LP saida) {
        pilha.add(entrada);
        int direcao = 0;

        while (!pilha.isEmpty())
        {

            testarDirecao(direcao, pilha.valor(), entrada);
            if (temporario.direcao != -1)
            {
                pilha.add(temporario);
                direcao = 0;
            }

            else
            {
                temporario = pilha.remove();
                labirintoExtra.add(temporario);
                direcao = temporario.direcao;
            }

            if (pilha.valor().x == saida.x && pilha.valor().y == saida.y){
                break;
            }
        }

        if (pilha.isEmpty()){throw new IllegalStateException("Sem saida pro labirinto");}

        while (!pilha.isEmpty()){
            caminho.add(pilha.remove());

        }


        boolean wall = false;
        for (int y = 0; y<10; y++) {
            for (int x = 0; x<10; x++) {
                for (int i = 0; i < labirinto.length; i++) {
                    if (labirinto[i].x == x && labirinto[i].y == y){
                        System.out.print("#");
                        wall = true;
                        break;
                    }

                }


                if (entrada.x == x && entrada.y == y) {
                    System.out.print("E");
                    wall = true;
                }

                else if (saida.x == x && saida.y == y) {
                    System.out.print("S");
                    wall = true;
                }

                else if (contemList(x,y, caminho)) {
                    System.out.print("*");
                    wall = true;
                }


                if (!wall) System.out.print(" ");
                wall = false;
            }
            System.out.println();

        }

    }


    private boolean contem(int x, int y) {
        for (int i = 0; i < labirinto.length; i++) {
            if (labirinto[i].x == x && labirinto[i].y == y) {
                return true;
            }
        }
        return false;
    }

    private boolean contemList(int x, int y, ArrayList<LP> lab) {
        for (int i = 0; i < lab.size(); i++) {
            if (lab.get(i).x == x && lab.get(i).y == y) {
                return true;
            }
        }
        return false;
    }

    private int direcao(int direcao)
    {
        if (direcao == 3){return -1;}
        return (direcao+1)%4;
    }

    private void testarDirecao(int direcao, LP posicao, LP entrada)
    {
        int x = posicao.x;
        int y = posicao.y;

        if (direcao == 0){y = posicao.y - 1;}

        else if (direcao == 1){x = posicao.x + 1;}

        else if (direcao == 2){y = posicao.y + 1;}

        else if (direcao == 3){x = posicao.x - 1;}

        else if (direcao == -1){
            temporario = new LP(x,y,direcao);
            return;
        }

        int debug = (direcao + 2) % 4;
        if (contem(x,y) || contemList(x, y, labirintoExtra) || posicao.direcao == debug && (posicao.x != entrada.x || posicao.y != entrada.y))
        {
            testarDirecao(direcao(direcao), posicao, entrada);
        }

        else
        {
            temporario = new LP(x,y,direcao);
            return;
        }

    }


}
