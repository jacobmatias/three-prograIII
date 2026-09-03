import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
    public class PruebaMatriz {
        public static void main(String[] args) {

            //prueba aleatorio
            Random numeroAleatorio = new Random();
            int random = numeroAleatorio.nextInt(1, 4);
            System.out.println(random);

            //creo una lista y lleno las primeras 9 posiciones con aleatorios y las ultimas 7 con 0
            List<Integer> lista = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                int nuevoAleatorio = numeroAleatorio.nextInt(1, 4);
                lista.add(nuevoAleatorio);
            }
            for (int i = 9; i < 16; i++) {
                lista.add(0);
            }

            //imprimo para ver la lista generada, la mezclo y veo como queda
            System.out.println(lista);
            Collections.shuffle(lista);
            System.out.println(lista);

            //genero matriz y la lleno con la nueva lista mezclada
            int[][] miMatriz2 = new int[4][4];

            int k = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    miMatriz2[i][j] = lista.get(k);
                    k++;
                }
            }

            //imprimo la matriz para ver como quedo
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(miMatriz2[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

