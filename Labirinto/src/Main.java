//Artur Gabriel Hauache
//André Cani Smah

import Labirinto.LP;
import Labirinto.Labirinto;

public class Main {
    public static void main(String[] args) {
        LP labirintoParede[] =
                {
                        new LP(0,0), new LP(1,0), new LP(2,0), new LP(3,0), new LP(4,0), new LP(5,0), new LP(6,0), new LP(7,0), new LP(8,0), new LP(9,0),
                        new LP(0,1), new LP(2,1), new LP(4,1), new LP(8,1), new LP(9,1),
                        new LP(0,2), new LP(2,2), new LP(4,2), new LP(6,2), new LP(9,2),
                        new LP(0,3), new LP(2,3), new LP(4,3), new LP(6,3), new LP(8,3), new LP(9,3),
                        new LP(0,4), new LP(4,4), new LP(6,4), new LP(8,4), new LP(9,4),
                        new LP(0,5), new LP(1,5), new LP(2,5), new LP(6,5), new LP(8,5), new LP(9,5),
                        new LP(0,6), new LP(2,6), new LP(3,6), new LP(4,6), new LP(5,6), new LP(6,6), new LP(8,6), new LP(9,6),
                        new LP(0,7), new LP(9,7),
                        new LP(0,8), new LP(1,8), new LP(2,8), new LP(3,8), new LP(4,8), new LP(5,8), new LP(6,8), new LP(7,8), new LP(9,8),
                        new LP(0,9), new LP(1,9), new LP(2,9), new LP(3,9), new LP(4,9), new LP(5,9), new LP(6,9), new LP(7,9), new LP(8,9), new LP(9,9),
                };

        var entrada = new LP(1,1);
        var saida = new LP(1,6);

        new Labirinto(labirintoParede, entrada, saida);
    }
}
