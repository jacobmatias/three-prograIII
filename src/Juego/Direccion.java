package Juego;

public class Direccion {
    private int x;
    private int y;

    public Direccion (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverArriba() {
        this.y--;
    }

    public void moverAbajo() {
        this.y++;
    }

    public void moverIzquierda() {
        this.x--;
    }

    public void moverDerecha() {
        this.x++;
    }
}
