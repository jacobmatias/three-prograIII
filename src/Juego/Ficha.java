package Juego;

import java.util.Random;

public class Ficha {
    private int valor;

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

    public static Ficha convinarFichas(Ficha ficha1, Ficha ficha2){
        Ficha fichafinal= new Ficha(ficha1.getValor()+ ficha2.getValor());
        return fichafinal;
    }
}
