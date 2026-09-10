package Juego;

public class Juego {
    Tablero tablero;
    static int puntaje = 0;

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

    public static int getPuntaje() {
        return puntaje;
    }

    public boolean esGameOver() {
        return tablero.esGameOver();
    }
}
