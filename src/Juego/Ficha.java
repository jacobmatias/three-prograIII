package Juego;

import java.util.Random;

public class Ficha {
    int valor;

    public Ficha () {
        Random random = new Random();
        this.valor = random.nextInt(2) + 1;
        ;
    }
    public Ficha (int valor) {

        this.valor = valor;

    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
