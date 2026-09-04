package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Juego.Ficha;
import Juego.Juego;

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
    Ficha [][] fichas = juego.MatrizInicial();

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
        flechaArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        flechaArriba.setBounds(237, 427, 50, 35);
        frame.getContentPane().add(flechaArriba);

        JButton flechaAbajo = new JButton("▼");
        flechaAbajo.setBackground(Color.GREEN);
        flechaAbajo.setBounds(237, 490, 50, 35);
        frame.getContentPane().add(flechaAbajo);

        JButton flechaDerecha = new JButton("▶");
        flechaDerecha.setBackground(Color.GREEN);
        flechaDerecha.setBounds(299, 459, 50, 35);
        frame.getContentPane().add(flechaDerecha);

        JButton fechaIzquierda = new JButton("◀");
        fechaIzquierda.setBackground(Color.GREEN);
        fechaIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        fechaIzquierda.setBounds(177, 459, 50, 35);
        frame.getContentPane().add(fechaIzquierda);

        int ejeX = 132;
        int ejeY = 96;
        int width = 70;
        int height = 70;

        for (int x = 0; x < jlabels.length; x++) {
            for (int y = 0; y < jlabels.length; y++) {
                fichas[x][y] = fichas[x][y];
                jlabels[x][y] = new JLabel();
                jlabels[x][y].setText(" " + String.valueOf(fichas[x][y].getValor()));
                jlabels[x][y].setOpaque(true);
                jlabels[x][y].setBackground(Color.white);
                jlabels[x][y].setHorizontalAlignment(SwingConstants.CENTER);
                jlabels[x][y].setFont(new Font("Arial", Font.BOLD, 35));
                jlabels[x][y].setBorder(BorderFactory.createLineBorder(Color.RED));
                jlabels[x][y].setBounds(ejeX, ejeY, width, height);

                frame.add(jlabels[x][y]);
                ejeX += 68;
            }
            ejeX = 132;
            ejeY +=68;
        }

    }
}