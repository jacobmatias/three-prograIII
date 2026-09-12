package Juego;

import java.util.ArrayList;

public class Juego {
    Tablero tablero;
    static int puntaje;
    static ArrayList<Integer> listaPuntaje = new ArrayList<>();

    public Juego() {
        this.tablero = new Tablero();
        puntaje = 0;
    }

    public Ficha devolverValor(int i, int j) {
        return tablero.devolverValor(i, j);
    }

    public void moverFicha(Direcciones direccion) {
        switch (direccion) {
            case DERECHA -> { tablero.moverDerecha(); }
            case IZQUIERDA -> { tablero.moverIzquierda(); } // Agregada la llamada que faltaba
            case ABAJO -> { tablero.moverAbajo(); }
            case ARRIBA -> { tablero.moverArriba(); }
        }
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public void resetPuntaje() {
    	puntaje = 0;
    }

    public boolean esGameOver() {
        return tablero.esGameOver();
    }
    
    public void guardarPuntaje() {
    	listaPuntaje.add(puntaje);
    	System.out.println(listaPuntaje);
    }
    
    public ArrayList<Integer> getListaPuntaje() {
        return listaPuntaje;
    }
}
