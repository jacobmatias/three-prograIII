package Juego;

import java.util.Random;

public class Ficha {
    int valor;

    public Ficha () {
        Random random = new Random();
        this.valor = random.nextInt(2) + 1;
        ;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
