package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PruebaMatriz {

	static int puntaje = 0;
	static int nextRandom;
	static int[][] matriz;
    public static void main(String[] args) {

    	//prueba aleatorio
    	nextRandom = generarAleatorio(1,4);
        System.out.println(nextRandom);
        
        //creo una lista y lleno las primeras 9 posiciones con aleatorios y las ultimas 7 con 0
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lista.add(generarAleatorio(1,4));
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
        imprimirMatriz(miMatriz2);
        
        moverDerecha(miMatriz2);
        imprimirMatriz(miMatriz2);moverDerecha(miMatriz2);
        imprimirMatriz(miMatriz2);moverDerecha(miMatriz2);
        imprimirMatriz(miMatriz2);moverDerecha(miMatriz2);
        imprimirMatriz(miMatriz2);
//        moverIzquierda(miMatriz2);
//        imprimirMatriz(miMatriz2);
//        moverArriba(miMatriz2);
//        imprimirMatriz(miMatriz2);
//        moverAbajo(miMatriz2);
//        imprimirMatriz(miMatriz2);
        System.out.println(String.valueOf(puntaje));
    } 
    public static int[][] crearMatrizInicial(){
    	matriz = new int[4][4];
    	
    	List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lista.add(generarAleatorio(1,4));
        }
        for (int i = 9; i < 16; i++) {
            lista.add(0);
        }
        Collections.shuffle(lista);
//        int[][] nuevaMatriz = new int[4][4];
        
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = lista.get(k);
                k++;
            }
        }
        return matriz;
    }
    
    
    public static void callMoverDerecha() {
		moverDerecha(matriz);
    }
    public static void moverDerecha(int[][] miMatriz2){
    	int[][] nuevaMatriz = miMatriz2;
    	for (int i=0;i <= 3; ) {
    		for (int j=3;j >= 0;) {
    			int valor = nuevaMatriz[i][j];
    			if (j<3) {
    				if   (nuevaMatriz[i][j+1] == 0) {
    					nuevaMatriz[i][j+1] = nuevaMatriz[i][j+1] + valor;
    					nuevaMatriz[i][j] = 0;
    				}
    				else if   (valor >= 3 && nuevaMatriz[i][j+1] == valor || nuevaMatriz[i][j+1] == 2 && valor == 1 || nuevaMatriz[i][j+1] == 1 && valor == 2) {
        					nuevaMatriz[i][j+1] = nuevaMatriz[i][j+1] + valor;
        					puntaje = puntaje + nuevaMatriz[i][j+1];
        					nuevaMatriz[i][j] = 0;
        				}		
    			}
    			j--;
    		}
    		i++;
    	} 
    	agregarFicha(nuevaMatriz, 1);
    }

    
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
    
    
    public static void callMoverAbajo() {
		moverAbajo(matriz);
    }
    public static void moverAbajo(int[][] miMatriz2){
    	int[][] nuevaMatriz = miMatriz2;
    	for (int j=0;j <= 3; ) {
    		for (int i=3;i >= 0;) {
    			int valor = nuevaMatriz[i][j];
    			if (i<3) {
    				if (nuevaMatriz[i+1][j] == 0){
    					nuevaMatriz[i+1][j] = nuevaMatriz[i+1][j] + valor;
    					nuevaMatriz[i][j] = 0;
    				}
    				else if   (valor >= 3 && nuevaMatriz[i+1][j] == valor || nuevaMatriz[i+1][j] == 2 && valor == 1 || nuevaMatriz[i+1][j] == 1 && valor == 2) {
        				nuevaMatriz[i+1][j] = nuevaMatriz[i+1][j] + valor;
        				aumentarPuntaje(nuevaMatriz[i+1][j]);
        				nuevaMatriz[i][j] = 0;
        			}		
    			}
    			i--;
    		}
    		j++;
    	}
    	agregarFicha(nuevaMatriz, 4);
    	
    }
    
    public static void imprimirMatriz(int[][] miMatriz2) {
    	for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(miMatriz2[i][j] + " ");
            }
            System.out.println();
        }
    	System.out.println();
    }
    public static int[][] agregarFicha(int[][] matriz, int direccion) {
    	if (direccion == 4) {
    		int i=0;
    		int j=0;
       		ArrayList<Integer> posicionesVacias = new ArrayList<>();
       		for (j = 0;j <= 3;) {
  	    		if (matriz[i][j] == 0) {
  	    			posicionesVacias.add(j);
  	    			
       			}
  	    		j++;
       		}
       		System.out.println(posicionesVacias);
       		if (posicionesVacias.size() > 1) {
       			int posicionAleatoria = generarAleatorio(1,posicionesVacias.size());
           		j = posicionesVacias.get(posicionAleatoria);
       		}
       		else j = posicionesVacias.get(0);
       		matriz[i][j] = nextRandom;
       		nextRandom = generarAleatorio(1,4);
       		return matriz;
       	}
    	if (direccion == 3) {
    		int i=3;
    		int j=0;
       		ArrayList<Integer> posicionesVacias = new ArrayList<>();
       		for (j =0;j <=3;) {
  	    		if (matriz[i][j] == 0) {
  	    			posicionesVacias.add(j);
  	    			
       			}
  	    		j++;
       		}
       		System.out.println(posicionesVacias);
       		if (posicionesVacias.size() > 1) {
       			int posicionAleatoria = generarAleatorio(1,posicionesVacias.size());
           		j = posicionesVacias.get(posicionAleatoria);
       		}
       		else j = posicionesVacias.get(0);
       		matriz[i][j] = nextRandom;
       		nextRandom = generarAleatorio(1,4);
       		return matriz;
       	}
    	if (direccion == 2) {
    		int i=0;
    		int j=3;
       		ArrayList<Integer> posicionesVacias = new ArrayList<>();
       		for (i = 3;i >= 0;) {
  	    		if (matriz[i][j] == 0) {
  	    			posicionesVacias.add(i);
  	    			
       			}
  	    		i--;
       		}
       		System.out.println(posicionesVacias);
       		if (posicionesVacias.size() > 1) {
       			int posicionAleatoria = generarAleatorio(1,posicionesVacias.size());
           		i = posicionesVacias.get(posicionAleatoria);
       		}
       		else i = posicionesVacias.get(0);
       		matriz[i][j] = nextRandom;
       		nextRandom = generarAleatorio(1,4);
       		return matriz;
       	}
    	if (direccion == 1) {
    		int i=0;
    		int j=0;
       		ArrayList<Integer> posicionesVacias = new ArrayList<>();
       		for (i = 0;i <= 3;) {
  	    		if (matriz[i][j] == 0) {
  	    			posicionesVacias.add(i);
  	    			
       			}
  	    		i++;
       		}
       		System.out.println(posicionesVacias);
       		if (posicionesVacias.size() > 1) {
       			int posicionAleatoria = generarAleatorio(1,posicionesVacias.size());
           		i = posicionesVacias.get(posicionAleatoria);
       		}
       		else i = posicionesVacias.get(0);
       		matriz[i][j] = nextRandom;
       		nextRandom = generarAleatorio(1,4);
       		return matriz;
       	}
    	return matriz;
    }
    public static int aumentarPuntaje(int puntos) {
    	puntaje = puntaje + puntos;
    	return puntaje;
    }
    public static int generarAleatorio(int desde, int hasta){
    	Random numeroAleatorio = new Random();
        nextRandom = numeroAleatorio.nextInt(desde, hasta); 
        System.out.println(nextRandom);
        return nextRandom;
    }
    public static int devolverValor(int i, int j) {
    	int valor = matriz[i][j];
    	return valor;
    }
    
}
