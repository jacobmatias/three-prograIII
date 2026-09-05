package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    Tablero tablero;
    static int puntaje=0;

    public Juego () {
        this.tablero=new Tablero();
    }

    public Ficha devolverValor(int i,int j){
        return tablero.devolverValor(i,j);
    }

    public void moverFicha(Direcciones direccion) {
        switch (direccion)
        {
            case DERECHA ->{tablero.moverDerecha();}
            case IZQUIERDA -> {}
            case ABAJO -> {}
            case ARRIBA -> {}
        }
    }

}


