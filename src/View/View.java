package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Juego.Ficha;
import Juego.Juego;
import Juego.PruebaMatriz;

import javax.swing.BorderFactory;
import javax.swing.JButton;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

    private JFrame frame;
    private JLabel[][] jlabels = new JLabel[4][4];
    Juego juego=new Juego();
    int [][] matriz = PruebaMatriz.crearMatrizInicial();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                View window = new View();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public View() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.white);
        frame.setBounds(100, 100, 574, 575);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel tituloJuego = new JLabel("THREES");
        tituloJuego.setBackground(Color.LIGHT_GRAY);
        tituloJuego.setFont(new Font("Times New Roman", Font.BOLD, 27));
        tituloJuego.setForeground(Color.GREEN);
        tituloJuego.setBounds(205, 31, 116, 25);
        frame.getContentPane().add(tituloJuego);

        JButton flechaArriba = new JButton("▲");
        flechaArriba.setBackground(Color.GREEN);
        flechaArriba.setFocusable(false);
        flechaArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PruebaMatriz.callMoverArriba();
            	actualizarTableroView();
            }
        });
        flechaArriba.setBounds(237, 427, 50, 35);
        frame.getContentPane().add(flechaArriba);

        JButton flechaAbajo = new JButton("▼");
        flechaAbajo.setBackground(Color.GREEN);
        flechaAbajo.setFocusable(false);
        flechaAbajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PruebaMatriz.callMoverAbajo();
            	actualizarTableroView();
            }
        });
        flechaAbajo.setBounds(237, 490, 50, 35);
        frame.getContentPane().add(flechaAbajo);

        JButton flechaDerecha = new JButton("▶");
        flechaDerecha.setBackground(Color.GREEN);
        flechaDerecha.setFocusable(false);
        flechaDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PruebaMatriz.callMoverDerecha();
            	actualizarTableroView();
            }
        });
        flechaDerecha.setBounds(299, 459, 50, 35);
        frame.getContentPane().add(flechaDerecha);

        JButton flechaIzquierda = new JButton("◀");
        flechaIzquierda.setBackground(Color.GREEN);
        flechaIzquierda.setFocusable(false);
        flechaIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PruebaMatriz.callMoverIzquierda();
            	actualizarTableroView();
            }
        });
        flechaIzquierda.setBounds(177, 459, 50, 35);
        frame.getContentPane().add(flechaIzquierda);

        int ejeX = 132;
        int ejeY = 96;
        int width = 70;
        int height = 70;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                jlabels[i][j] = new JLabel();
                int valorFicha = PruebaMatriz.devolverValor(i, j);
                jlabels[i][j].setText(String.valueOf(valorFicha));
                jlabels[i][j].setOpaque(true);
                jlabels[i][j].setBackground(Color.white);
                jlabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jlabels[i][j].setFont(new Font("Arial", Font.BOLD, 35));
                jlabels[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));
                jlabels[i][j].setBounds(ejeX, ejeY, width, height);

                frame.add(jlabels[i][j]);
                ejeX += 68;
            }
            ejeX = 132;
            ejeY +=68;
        }
        PruebaMatriz.generarAleatorio(1, 4);
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
                    PruebaMatriz.callMoverArriba();
                    actualizarTableroView();
                }
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
                    PruebaMatriz.callMoverAbajo();
                    actualizarTableroView();
                }
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
                    PruebaMatriz.callMoverIzquierda();
                    actualizarTableroView();
                }
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
                    PruebaMatriz.callMoverDerecha();
                    actualizarTableroView();
                }
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }
    
    private void actualizarTableroView() {
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
            	int nuevoValor = PruebaMatriz.devolverValor(i, j);
            	jlabels[i][j].setText(String.valueOf(nuevoValor));
        	}
    	}    
    }
}