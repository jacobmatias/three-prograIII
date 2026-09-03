package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    Direccion direccion;
    Tablero tablero;

    public Juego () {

    }

    public void moverFicha(String s) {
        if (s.equals("ARRIBA")) {
            this.direccion.moverArriba();
        }
        else if (s.equals("ABAJO")) {
            this.direccion.moverAbajo();
        }
        else if (s.equals("IZQUIERDA")) {
            this.direccion.moverIzquierda();
        }
        else if (s.equals("DERECHA")) {
            this.direccion.moverDerecha();
        }

    }

    public Ficha[][] MatrizInicial(){
        List<Ficha> lista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Ficha nueva = new Ficha();
            lista.add(nueva);
        }
        for (int i = 9; i < 16; i++) {
            lista.add(new Ficha(0));
        }

        System.out.println(lista);
        Collections.shuffle(lista);
        System.out.println(lista);

        Ficha[][] miMatriz2 = new Ficha[4][4];

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
        return miMatriz2;
    }}


