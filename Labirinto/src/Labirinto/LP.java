package Labirinto;

public class LP {
    public int x;
    public int y;
    public int direcao;

    public LP(int x, int y, int direcao){
        this.x = x;
        this.y = y;
        this.direcao = direcao;
    }

    public LP(int x, int y){
        this.x = x;
        this.y = y;
        this.direcao = -1;
    }
}
