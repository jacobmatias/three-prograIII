package Juego;

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
}
