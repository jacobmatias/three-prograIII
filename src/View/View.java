package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Juego.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View {

    private JFrame frame;
    private JLabel[][] jlabels = new JLabel[4][4];
    private JLabel lblPuntaje;
    private JLabel lblGameOver; 
    private Juego juego = new Juego();
    

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
        frame.setBounds(100, 100, 574, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel tituloJuego = new JLabel("THREES");
        tituloJuego.setBackground(Color.LIGHT_GRAY);
        tituloJuego.setFont(new Font("Times New Roman", Font.BOLD, 27));
        tituloJuego.setForeground(Color.GREEN);
        tituloJuego.setBounds(205, 20, 116, 25);
        frame.getContentPane().add(tituloJuego);

        lblPuntaje = new JLabel("Puntos: 0");
        lblPuntaje.setFont(new Font("Arial", Font.BOLD, 16));
        lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntaje.setBounds(180, 55, 170, 25);
        frame.getContentPane().add(lblPuntaje);

        lblGameOver = new JLabel("GAME OVER");
        lblGameOver.setFont(new Font("Arial", Font.BOLD, 32));
        lblGameOver.setForeground(Color.RED);
        lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameOver.setBounds(132, 370, 270, 45); // Posicionado entre el tablero y los botones
        lblGameOver.setVisible(false); // Oculto al inicio
        frame.getContentPane().add(lblGameOver);
        
        JButton flechaArriba = new JButton("▲");
        flechaArriba.setBackground(Color.GREEN);
        flechaArriba.setFocusable(false);
        flechaArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juego.moverFicha(Direcciones.ARRIBA);
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
                juego.moverFicha(Direcciones.ABAJO);
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
                juego.moverFicha(Direcciones.DERECHA);
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
                juego.moverFicha(Direcciones.IZQUIERDA);
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
                jlabels[i][j].setOpaque(true);
                jlabels[i][j].setBackground(Color.white);
                jlabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jlabels[i][j].setFont(new Font("Arial", Font.BOLD, 35));
                jlabels[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));
                jlabels[i][j].setBounds(ejeX, ejeY, width, height);

                frame.getContentPane().add(jlabels[i][j]);
                ejeX += 68;
            }
            ejeX = 132;
            ejeY += 68;
        }

        // Carga el estado inicial en los JLabels
        actualizarTableroView();

        // KeyListener ajustado a la instancia de 'juego'
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    juego.moverFicha(Direcciones.ARRIBA);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    juego.moverFicha(Direcciones.ABAJO);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    juego.moverFicha(Direcciones.IZQUIERDA);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    juego.moverFicha(Direcciones.DERECHA);
                }
                actualizarTableroView();
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    private void actualizarTableroView() {
        lblPuntaje.setText("Puntos: " + juego.getPuntaje());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int valorFicha = juego.devolverValor(i, j).getValor();
                if (valorFicha == 0) {
                    jlabels[i][j].setText("");
                } else {
                    jlabels[i][j].setText(String.valueOf(valorFicha));
                }
            }
        }
        
     // --- REVISAR SI PERDIÓ ---
        if (juego.esGameOver()) {
            lblGameOver.setVisible(true);
        }

        frame.requestFocusInWindow();
        frame.requestFocusInWindow();
    }
    
    
}