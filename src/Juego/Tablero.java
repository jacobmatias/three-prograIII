package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tablero {
    private Ficha[][] matrizTablero = new Ficha[4][4];
    static Ficha siguienteFicha;
    static int nextRandom;
    

    public Tablero() {
        List<Ficha> lista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lista.add(new Ficha());
        }
        for (int i = 9; i < 16; i++) {
            lista.add(new Ficha(0));
        }
        Collections.shuffle(lista);

        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrizTablero[i][j] = lista.get(k++);
            }
        }
        siguienteFicha = new Ficha();
    }

    public Ficha devolverValor(int i, int j) {
        return matrizTablero[i][j];
    }
    
    public int moverArriba() {
        int puntosObtenidos = 0;
        boolean huboMovimiento = false;

        for (int columnas = 0; columnas <= 3; columnas++) {
            for (int filas = 0; filas <= 3; filas++) {
                if (filas > 0 && matrizTablero[filas][columnas].getValor() != 0) {
                    int valOrigen = matrizTablero[filas][columnas].getValor();
                    int valDestino = matrizTablero[filas - 1][columnas].getValor();

                    if (valDestino == 0) {
                        matrizTablero[filas - 1][columnas] = Ficha.convinarFichas(matrizTablero[filas - 1][columnas], matrizTablero[filas][columnas]);
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    } else if (comprobarCombinables(valOrigen, valDestino)) {
                        matrizTablero[filas - 1][columnas] = Ficha.convinarFichas(matrizTablero[filas - 1][columnas], matrizTablero[filas][columnas]);
                        puntosObtenidos += matrizTablero[filas - 1][columnas].getValor();
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    }
                }
            }
        }

        if (huboMovimiento) {
            agregarFicha(matrizTablero, Direccion.ARRIBA);
        }
        return puntosObtenidos;
    }

    public int moverAbajo() {
        int puntosObtenidos = 0;
        boolean huboMovimiento = false;

        for (int columnas = 0; columnas <= 3; columnas++) {
            for (int filas = 3; filas >= 0; filas--) {
                if (filas < 3 && matrizTablero[filas][columnas].getValor() != 0) {
                    int valOrigen = matrizTablero[filas][columnas].getValor();
                    int valDestino = matrizTablero[filas + 1][columnas].getValor();

                    if (valDestino == 0) {
                        matrizTablero[filas + 1][columnas] = Ficha.convinarFichas(matrizTablero[filas + 1][columnas], matrizTablero[filas][columnas]);
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    } else if (comprobarCombinables(valOrigen, valDestino)) {
                        matrizTablero[filas + 1][columnas] = Ficha.convinarFichas(matrizTablero[filas + 1][columnas], matrizTablero[filas][columnas]);
                        puntosObtenidos += matrizTablero[filas + 1][columnas].getValor();
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    }
                }
            }
        }

        if (huboMovimiento) {
            agregarFicha(matrizTablero, Direccion.ABAJO);
        }
        return puntosObtenidos;
    }

    public int moverIzquierda() {
        int puntosObtenidos = 0;
        boolean huboMovimiento = false;

        for (int filas = 0; filas <= 3; filas++) {
            for (int columnas = 0; columnas <= 3; columnas++) {
                if (columnas > 0 && matrizTablero[filas][columnas].getValor() != 0) {
                    int valOrigen = matrizTablero[filas][columnas].getValor();
                    int valDestino = matrizTablero[filas][columnas - 1].getValor();

                    if (valDestino == 0) {
                        matrizTablero[filas][columnas - 1] = Ficha.convinarFichas(matrizTablero[filas][columnas - 1], matrizTablero[filas][columnas]);
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    } else if (comprobarCombinables(valOrigen, valDestino)) {
                        matrizTablero[filas][columnas - 1] = Ficha.convinarFichas(matrizTablero[filas][columnas - 1], matrizTablero[filas][columnas]);
                        puntosObtenidos += matrizTablero[filas][columnas - 1].getValor();
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    }
                }
            }
        }

        if (huboMovimiento) {
            agregarFicha(matrizTablero, Direccion.IZQUIERDA);
        }
        return puntosObtenidos;
    }

    public int moverDerecha() {
        int puntosObtenidos = 0;
        boolean huboMovimiento = false;

        for (int filas = 0; filas <= 3; filas++) {
            for (int columnas = 3; columnas >= 0; columnas--) {
                if (columnas < 3 && matrizTablero[filas][columnas].getValor() != 0) {
                    int valOrigen = matrizTablero[filas][columnas].getValor();
                    int valDestino = matrizTablero[filas][columnas + 1].getValor();

                    if (valDestino == 0) {
                        matrizTablero[filas][columnas + 1] = Ficha.convinarFichas(matrizTablero[filas][columnas + 1], matrizTablero[filas][columnas]);
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    } else if (comprobarCombinables(valOrigen, valDestino)) {
                        matrizTablero[filas][columnas + 1] = Ficha.convinarFichas(matrizTablero[filas][columnas + 1], matrizTablero[filas][columnas]);
                        puntosObtenidos += matrizTablero[filas][columnas + 1].getValor();
                        matrizTablero[filas][columnas] = new Ficha(0);
                        huboMovimiento = true;
                    }
                }
            }
        }

        if (huboMovimiento) {
            agregarFicha(matrizTablero, Direccion.DERECHA);
        }
        return puntosObtenidos;
    }
    
    
    private static boolean comprobarCombinables(int valor, int valor2) {
        return (valor >= 3 && valor2 == valor) || (valor2 == 2 && valor == 1) || (valor2 == 1 && valor == 2);
    }

    public void agregarFicha(Ficha[][] matriz, Direccion direccion) {
        List<int[]> posicionesVacia = new ArrayList<>();

        switch (direccion) {
            case DERECHA -> {
                for (int filas = 0; filas <= 3; filas++) {
                    if (matriz[filas][0].getValor() == 0) {
                        posicionesVacia.add(new int[]{filas, 0});
                    }
                }
            }
            case IZQUIERDA -> {
                for (int filas = 0; filas <= 3; filas++) {
                    if (matriz[filas][3].getValor() == 0) {
                        posicionesVacia.add(new int[]{filas, 3});
                    }
                }
            }
            case ABAJO -> {
                for (int columnas = 0; columnas <= 3; columnas++) {
                    if (matriz[0][columnas].getValor() == 0) {
                        posicionesVacia.add(new int[]{0, columnas});
                    }
                }
            }
            case ARRIBA -> {
                for (int columnas = 0; columnas <= 3; columnas++) {
                    if (matriz[3][columnas].getValor() == 0) {
                        posicionesVacia.add(new int[]{3, columnas});
                    }
                }
            }
        }

        if (posicionesVacia.size() > 1) {
            int posicionAleatoria = generarAleatorio(0, posicionesVacia.size());
            int[] posicion = posicionesVacia.get(posicionAleatoria);
            matriz[posicion[0]][posicion[1]] = siguienteFicha;
            siguienteFicha = new Ficha();
        } else if (posicionesVacia.size() == 1) {
            int[] posicion = posicionesVacia.getFirst();
            matriz[posicion[0]][posicion[1]] = siguienteFicha;
            siguienteFicha = new Ficha();
        }
    }

    public static int generarAleatorio(int desde, int hasta) {
        Random numeroAleatorio = new Random();
        nextRandom = numeroAleatorio.nextInt(desde, hasta);
        return nextRandom;
    }

    public boolean esGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizTablero[i][j].esVacia()) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int actual = matrizTablero[i][j].getValor();
                if (j + 1 < 4 && comprobarCombinables(actual, matrizTablero[i][j + 1].getValor())) {
                    return false;
                }
                if (i + 1 < 4 && comprobarCombinables(actual, matrizTablero[i + 1][j].getValor())) {
                    return false;
                }
            }
        }
        return true;
    }
    public Ficha getSiguienteFicha() {
        return siguienteFicha;
    }
}


