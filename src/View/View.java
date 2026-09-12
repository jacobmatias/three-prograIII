package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Juego.*;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;

public class View {

    private JFrame frame;
    private JLabel[][] jlabels = new JLabel[4][4];
    private JLabel lblPuntaje;
    private JLabel lblSiguienteFicha;
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
        frame.getContentPane().setBackground(Color.black);
        frame.setBounds(100, 100, 574, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel tituloJuego = new JLabel("THREES");
        tituloJuego.setFont(new Font("Rockwell", Font.BOLD, 35));
        tituloJuego.setForeground(Color.GREEN);
        tituloJuego.setBounds(203, 25, 155, 41);
        frame.getContentPane().add(tituloJuego);

        lblPuntaje = new JLabel("SCORE: " + juego.getPuntaje());
        lblPuntaje.setOpaque(true);
        lblPuntaje.setBackground(new Color(220, 245, 225));
        lblPuntaje.setBorder(new LineBorder(new Color(70, 150, 90), 2, true));       
        lblPuntaje.setFont(new Font("Arial", Font.BOLD, 16));
        lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntaje.setBounds(10, 11, 110, 34);
        frame.getContentPane().add(lblPuntaje);
        
        lblSiguienteFicha = new JLabel("\"<html><div align='center'>NEXT<br><font size='6'>\"");
        lblSiguienteFicha.setOpaque(true);
        lblSiguienteFicha.setBackground(new Color(220, 245, 225));
        lblSiguienteFicha.setFont(new Font("Arial", Font.BOLD, 16));
        lblSiguienteFicha.setHorizontalAlignment(SwingConstants.CENTER);
        lblSiguienteFicha.setBounds(454, 11, 77, 74);
        frame.getContentPane().add(lblSiguienteFicha);
       
        JButton flechaArriba = new JButton("▲");
        flechaArriba.setBackground(Color.GREEN);
        flechaArriba.setFocusable(false);
        flechaArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juego.moverFicha(Direccion.ARRIBA);
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
                juego.moverFicha(Direccion.ABAJO);
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
                juego.moverFicha(Direccion.DERECHA);
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
                juego.moverFicha(Direccion.IZQUIERDA);
                actualizarTableroView();
            }
        });
        flechaIzquierda.setBounds(177, 459, 50, 35);
        frame.getContentPane().add(flechaIzquierda);
        
        JButton btnReset = new JButton("↻ NEW GAME");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juego = new Juego();
                actualizarTableroView();
                frame.requestFocusInWindow();
            }
        });
        btnReset.setBounds(438, 527, 110, 23);
        frame.getContentPane().add(btnReset);
        
        JButton btnNewButton = new JButton("Score History");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mostrarHistorial();
        	}
        });
        btnNewButton.setBounds(10, 527, 127, 23);
        frame.getContentPane().add(btnNewButton);
        


        int ejeX = 132;
        int ejeY = 96;
        int width = 70;
        int height = 70;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                jlabels[i][j] = new JLabel();
                jlabels[i][j].setOpaque(true);
                jlabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jlabels[i][j].setFont(new Font("Arial", Font.BOLD, 35));
                jlabels[i][j].setBackground(new Color(220, 245, 225));
                jlabels[i][j].setBorder(new LineBorder(new Color(70, 150, 90), 2, true));
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
                    juego.moverFicha(Direccion.ARRIBA);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    juego.moverFicha(Direccion.ABAJO);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    juego.moverFicha(Direccion.IZQUIERDA);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    juego.moverFicha(Direccion.DERECHA);
                }
                actualizarTableroView();
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    private void actualizarTableroView() {
    	lblPuntaje.setText("SCORE: " + juego.getPuntaje());
    	
    	lblSiguienteFicha.setText("<html><div align='center'>NEXT<br><font size='6'>" 
        	    + juego.mostrarValorSiguienteFicha() 
        	    + "</font></div></html>");
    	
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int valorFicha = juego.devolverValor(i, j).getValor();
                if (valorFicha == 0 || juego.esGameOver()) {
                    jlabels[i][j].setText("");
                } else {
                    jlabels[i][j].setText(String.valueOf(valorFicha));
                }
            }
        }
     // --- REVISAR SI PERDIÓ ---
        if (juego.esGameOver()) {         
        	mostrarGameOver();
        	juego.guardarPuntaje();
        }
        
        frame.requestFocusInWindow();
        frame.requestFocusInWindow();
    }
    
    private void mostrarGameOver() {
    	JFrame ventanaGameOver = new JFrame("THREES");
        ventanaGameOver.setSize(300, 150);
        ventanaGameOver.setLocationRelativeTo(frame);
        ventanaGameOver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaGameOver.getContentPane().setBackground(Color.WHITE);
        ventanaGameOver.setBackground(Color.WHITE);

        JLabel mensajeGameOver = new JLabel("GAME OVER");
        mensajeGameOver.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeGameOver.setFont(new Font("Arial", Font.BOLD, 32));
        mensajeGameOver.setForeground(Color.black);
        mensajeGameOver.setOpaque(false);
        ventanaGameOver.getContentPane().add(mensajeGameOver);

        ventanaGameOver.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                juego = new Juego();
                actualizarTableroView();
                frame.requestFocusInWindow();
            }
        });
        
        ventanaGameOver.setVisible(true);
    }
    
    private void mostrarHistorial() {

        JFrame ventanaHistorial = new JFrame("SCORE HISTORY");
        ventanaHistorial.setSize(300, 350);
        ventanaHistorial.setLocationRelativeTo(frame);
        ventanaHistorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titulo = new JLabel("SCORE HISTORY");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(45, 120, 65));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 20, 300, 40);

        ventanaHistorial.getContentPane().setLayout(null);
        ventanaHistorial.getContentPane().add(titulo);

        int nro = 1;
        int posicionY = 80;
        for (Integer puntaje : juego.getListaPuntaje()) {
            JLabel lblPuntaje = new JLabel("Juego " + nro + ": " + puntaje);
            lblPuntaje.setFont(new Font("Arial", Font.BOLD, 15));
            lblPuntaje.setBounds(5, posicionY, 200, 30);

            ventanaHistorial.getContentPane().add(lblPuntaje);
            posicionY += 35;
            nro++;
        }
        ventanaHistorial.setVisible(true);
    }
}