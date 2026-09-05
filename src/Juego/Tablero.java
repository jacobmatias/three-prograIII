package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tablero {
    Ficha [][] matriz=new Ficha[4][4];
    static int nextRandom;


    public Tablero () {
            List<Ficha> lista = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                Ficha nueva = new Ficha();
                lista.add(nueva);
            }
            for (int i = 9; i < 16; i++) {
                lista.add(new Ficha(0));
            }
            Collections.shuffle(lista);

            int k = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    this.matriz[i][j] = lista.get(k);
                    k++;
                }
            }}
    public Ficha devolverValor(int i, int j) {
        Ficha ficha = matriz[i][j];
        return ficha;
    }
    /*
        public static void callMoverIzquierda() {
		moverIzquierda(matriz);
    }
    public static void moverIzquierda(int[][] miMatriz2){
    	int[][] nuevaMatriz = miMatriz2;
    	for (int i=0;i <= 3; ) {
    		for (int j=0;j <= 3;) {
    			int valor = nuevaMatriz[i][j];
    			if (j>0) {
    				if   (nuevaMatriz[i][j-1] == 0) {
    					nuevaMatriz[i][j-1] = nuevaMatriz[i][j-1] + valor;
    					nuevaMatriz[i][j] = 0;
    				}
    				else if   (valor >= 3 && nuevaMatriz[i][j-1] == valor || nuevaMatriz[i][j-1] == 2 && valor == 1 || nuevaMatriz[i][j-1] == 1 && valor == 2) {
        					nuevaMatriz[i][j-1] = nuevaMatriz[i][j-1] + valor;
        					puntaje = puntaje + nuevaMatriz[i][j-1];
        					nuevaMatriz[i][j] = 0;
        				}
    			}
    			j++;
    		}
    		i++;
    	}
    	agregarFicha(nuevaMatriz, 2);
    }


    public static void callMoverArriba() {
		moverArriba(matriz);
    }
    public static void moverArriba(int[][] miMatriz2){
    	int[][] nuevaMatriz = miMatriz2;
    	for (int j=0;j <= 3; ) {
    		for (int i=0;i <= 3;) {
    			int valor = nuevaMatriz[i][j];
    			if (i>0) {
    				if (nuevaMatriz[i-1][j] == 0) {
    					nuevaMatriz[i-1][j] = nuevaMatriz[i-1][j] + valor;
    					nuevaMatriz[i][j] = 0;
    				}
    				else if   (valor >= 3 && nuevaMatriz[i-1][j] == valor || nuevaMatriz[i-1][j] == 2 && valor == 1 || nuevaMatriz[i-1][j] == 1 && valor == 2) {
        				nuevaMatriz[i-1][j] = nuevaMatriz[i-1][j] + valor;
        				puntaje = puntaje + nuevaMatriz[i-1][j];
        				nuevaMatriz[i][j] = 0;
        			}

    			}
    			i++;
    		}
    		j++;
    	}
    	agregarFicha(nuevaMatriz, 3);
    }


     */
    public void moverArriba(){
        int puntaje=0;
        Ficha[][] nuevaMatriz = this.matriz;
        for (int columnas=0;columnas <= 3; ) {
            for (int filas=0;filas <= 3;) {
                if (filas>0) {
                    if   (nuevaMatriz[filas-1][columnas].getValor() == 0) {
                        nuevaMatriz[filas-1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas-1][columnas] ,nuevaMatriz[filas][columnas] );
                        nuevaMatriz[filas][columnas] =  new Ficha(0);
                    }
                    else if   (comprobarCombinables(nuevaMatriz[filas][columnas].getValor() , nuevaMatriz[filas-1][columnas].getValor())) {
                        nuevaMatriz[filas-1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas-1][columnas],nuevaMatriz[filas][columnas]);
                        puntaje = puntaje + nuevaMatriz[filas-1][columnas].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
                filas++;
            }
            columnas++;
        }
        this.matriz=nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.ARRIBA);
    }


    public void moverAbajo(){
        int puntaje=0;
        Ficha[][] nuevaMatriz = this.matriz;
        for (int columnas=0;columnas <= 3; ) {
            for (int filas=3;filas >= 0;) {
                if (filas<3) {
                    if   (nuevaMatriz[filas+1][columnas].getValor() == 0) {
                        nuevaMatriz[filas+1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas+1][columnas] ,nuevaMatriz[filas][columnas] );
                        nuevaMatriz[filas][columnas] =  new Ficha(0);
                    }
                    else if   (comprobarCombinables(nuevaMatriz[filas][columnas].getValor() , nuevaMatriz[filas+1][columnas].getValor())) {
                        nuevaMatriz[filas+1][columnas] = Ficha.convinarFichas(nuevaMatriz[filas+1][columnas],nuevaMatriz[filas][columnas]);
                        puntaje = puntaje + nuevaMatriz[filas+1][columnas].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
                filas--;
            }
            columnas++;
        }
        this.matriz=nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.ABAJO);
    }

    public void moverDerecha(){
        int puntaje=0;
        Ficha[][] nuevaMatriz = this.matriz;
        for (int filas=0;filas <= 3; ) {
            for (int columnas=3;columnas >= 0;) {
                if (columnas<3) {
                    if   (nuevaMatriz[filas][columnas+1].getValor() == 0) {
                        nuevaMatriz[filas][columnas+1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas+1] ,nuevaMatriz[filas][columnas] );
                        nuevaMatriz[filas][columnas] =  new Ficha(0);
                    }
                    else if   (comprobarCombinables(nuevaMatriz[filas][columnas].getValor() , nuevaMatriz[filas][columnas+1].getValor())) {
                        nuevaMatriz[filas][columnas+1] = Ficha.convinarFichas(nuevaMatriz[filas][columnas+1],nuevaMatriz[filas][columnas]);
                        puntaje = puntaje + nuevaMatriz[filas][columnas+1].getValor();
                        nuevaMatriz[filas][columnas] = new Ficha(0);
                    }
                }
                columnas--;
            }
            filas++;
        }
        this.matriz=nuevaMatriz;
        agregarFicha(nuevaMatriz, Direcciones.DERECHA);
    }

    private static boolean comprobarCombinables(int valor, int valor2) {
        return valor >= 3 && valor2 == valor || valor2 == 2 && valor == 1 || valor2 == 1 && valor == 2;
    }

    public static void agregarFicha(Ficha[][] matriz, Direcciones direccion) {
        int filas=0;
        int columnas=0;
        List<int[]> posicionesVacia = new ArrayList<>();

        switch (direccion){
            case DERECHA ->  {

            for (filas = 0;filas <= 3;) {
                if (matriz[filas][columnas].getValor() == 0) {
                    posicionesVacia.add(new int[] {filas,0});

                }
                filas++;
            }}
            case IZQUIERDA ->  {

            for (columnas =0;columnas <=3;) {
                if (matriz[filas][columnas].getValor() == 0) {
                    posicionesVacia.add(new int[] {filas,3});

                }
                columnas++;
            }}
            case ABAJO ->  {

            for (columnas = 3;columnas >= 0;) {
                if (matriz[filas][columnas].getValor() == 0) {
                    posicionesVacia.add(new int[] {0,columnas});

                }
                columnas--;
            }}

            case ARRIBA ->  {

            for (columnas = 0;columnas <= 3;) {
                if (matriz[3][columnas].getValor() == 0) {
                    posicionesVacia.add(new int[] {3,columnas});

                }
                columnas++;
            }
            }
        }
//columnas
        if (posicionesVacia.size() > 1) {
            System.out.println("chau");
            int posicionAleatoria = generarAleatorio(1,posicionesVacia.size());
            int[] posicion= posicionesVacia.get(posicionAleatoria);
            filas=posicion[0];
            columnas = posicion[1];
            matriz[filas][columnas] = new Ficha();
        }
        else if (posicionesVacia.size() > 1) {
            System.out.println("hola");
            int[] posicion= posicionesVacia.getFirst();
            filas=posicion[0];
            columnas = posicion[1];
            matriz[filas][columnas] = new Ficha();}

}
    public static int generarAleatorio(int desde, int hasta){
        Random numeroAleatorio = new Random();
        nextRandom = numeroAleatorio.nextInt(desde, hasta);
        System.out.println(nextRandom);
        return nextRandom;
    }}




