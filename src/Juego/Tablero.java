package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tablero {
    Ficha[][] matriz = new Ficha[4][4];
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
                this.matriz[i][j] = lista.get(k++);
            }
        }
    }

    public Ficha devolverValor(int i, int j) {
        return matriz[i][j];
    }

    public void moverArriba() {
        Ficha[][] nuevaMatriz = this.matriz;
        for (int columnas = 0; columnas <= 3; columnas++) {
            for (int filas = 0; filas <= 3; filas++) {
                if (filas > 0) {
                    if (nuevaMatriz[filas - 1][columnas].getValor() == 0) {
                        nuevaMatriz[filas - 1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas - 1][columnas], nuevaMatriz[filas][columnas]);
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    } else if (comprobarCombinables(nuevaMatriz[filas][columnas].getValor(), nuevaMatriz[filas - 1][columnas].getValor())) {
                        nuevaMatriz[filas - 1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas - 1][columnas], nuevaMatriz[filas][columnas]);
                        Juego.puntaje += nuevaMatriz[filas - 1][columnas].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
            }
        }
        this.matriz = nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.ARRIBA);
    }

    public void moverAbajo() {
        Ficha[][] nuevaMatriz = this.matriz;
        for (int columnas = 0; columnas <= 3; columnas++) {
            for (int filas = 3; filas >= 0; filas--) {
                if (filas < 3) {
                    if (nuevaMatriz[filas + 1][columnas].getValor() == 0) {
                        nuevaMatriz[filas + 1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas + 1][columnas], nuevaMatriz[filas][columnas]);
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    } else if (comprobarCombinables(nuevaMatriz[filas][columnas].getValor(), nuevaMatriz[filas + 1][columnas].getValor())) {
                        nuevaMatriz[filas + 1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas + 1][columnas], nuevaMatriz[filas][columnas]);
                        Juego.puntaje += nuevaMatriz[filas + 1][columnas].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
            }
        }
        this.matriz = nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.ABAJO);
    }

    public void moverIzquierda() {
        Ficha[][] nuevaMatriz = this.matriz;
        for (int filas = 0; filas <= 3; filas++) {
            for (int columnas = 0; columnas <= 3; columnas++) {
                if (columnas > 0) {
                    if (nuevaMatriz[filas][columnas - 1].getValor() == 0) {
                        nuevaMatriz[filas][columnas - 1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas - 1], nuevaMatriz[filas][columnas]);
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    } else if (comprobarCombinables(nuevaMatriz[filas][columnas].getValor(), nuevaMatriz[filas][columnas - 1].getValor())) {
                        nuevaMatriz[filas][columnas - 1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas - 1], nuevaMatriz[filas][columnas]);
                        Juego.puntaje += nuevaMatriz[filas][columnas - 1].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
            }
        }
        this.matriz = nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.IZQUIERDA);
    }

    public void moverDerecha() {
        Ficha[][] nuevaMatriz = this.matriz;
        for (int filas = 0; filas <= 3; filas++) {
            for (int columnas = 3; columnas >= 0; columnas--) {
                if (columnas < 3) {
                    if (nuevaMatriz[filas][columnas + 1].getValor() == 0) {
                        nuevaMatriz[filas][columnas + 1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas + 1], nuevaMatriz[filas][columnas]);
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    } else if (comprobarCombinables(nuevaMatriz[filas][columnas].getValor(), nuevaMatriz[filas][columnas + 1].getValor())) {
                        nuevaMatriz[filas][columnas + 1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas + 1], nuevaMatriz[filas][columnas]);
                        Juego.puntaje += nuevaMatriz[filas][columnas + 1].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
            }
        }
        this.matriz = nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.DERECHA);
    }

    private static boolean comprobarCombinables(int valor, int valor2) {
        return (valor >= 3 && valor2 == valor) || (valor2 == 2 && valor == 1) || (valor2 == 1 && valor == 2);
    }

    public static void agregarFicha(Ficha[][] matriz, Direcciones direccion) {
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
            matriz[posicion[0]][posicion[1]] = new Ficha();
        } else if (posicionesVacia.size() == 1) {
            int[] posicion = posicionesVacia.getFirst();
            matriz[posicion[0]][posicion[1]] = new Ficha();
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
                if (matriz[i][j].esVacia()) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int actual = matriz[i][j].getValor();
                if (j + 1 < 4 && comprobarCombinables(actual, matriz[i][j + 1].getValor())) {
                    return false;
                }
                if (i + 1 < 4 && comprobarCombinables(actual, matriz[i + 1][j].getValor())) {
                    return false;
                }
            }
        }
        return true;
    }
}


