//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package tp;

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

        moverDerecha(miMatriz2);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(miMatriz2[i][j] + " ");
            }
            System.out.println();
        }
        //><
        return ;


    }
    /*public static void moverDerecha(int[][] miMatriz){
        for(int i=3;i>=0;i--){
            int[] filaNuevo = new int[4];
            for(int j=3;j>=0;j--){
                int valor=miMatriz[i][j];
                if(j==3 || filaNuevo[j+1]!=0){
                    filaNuevo[j]=valor;
                    continue;
                }
                if(valor==0){continue;}
                filaNuevo[j+1]=valor;
                }
            miMatriz[i]=filaNuevo;
        }*/

    public static void moverDerecha(int[][] miMatriz){
        for(int i=3;i>=0;i--){
            miMatriz[i]=moverFila(miMatriz[i]);
        }
}

    public static int[] moverFila(int[]fila){
        int[] filaNuevo = new int[4];
        for(int j=3;j>=0;j--){
            int valor=fila[j];
            if(j==3 || filaNuevo[j+1]!=0){
                filaNuevo[j]=valor;
                continue;
            }
            if(valor==0){continue;}
            filaNuevo[j+1]=valor;
        }
        return filaNuevo;

    }}





