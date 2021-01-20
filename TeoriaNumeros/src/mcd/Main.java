package mcd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel panel;
	private JTextField a;
	private JTextField b;
	private JTextField c;
	private JTextField d;
	private JTextField x;
	public int contador;
	private JTextArea salida;
	private int mcd;
	public ArrayList<Integer> numeros = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 481);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		this.setTitle("Algoritmo extendido de Euclides");
		contenido();

	}

	public void contenido() {

		contador = 4;
		a = new JTextField();
		a.setBackground(new Color(255, 255, 255));
		a.setBounds(23, 27, 86, 20);
		panel.add(a);
		a.setColumns(10);
		a.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		b = new JTextField();
		b.setBounds(137, 27, 86, 20);
		panel.add(b);
		b.setColumns(10);
		b.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		c = new JTextField();
		c.setBounds(254, 27, 86, 20);
		panel.add(c);
		c.setColumns(10);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		d = new JTextField();
		d.setBounds(371, 27, 86, 20);
		panel.add(d);
		d.setColumns(10);
		d.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		x = new JTextField();
		x.setBounds(23, 68, 86, 20);
		panel.add(x);
		x.setVisible(false);
		x.setColumns(10);
		x.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JButton sumar = new JButton("agregar n\u00FAmero");
		sumar.setBackground(Color.LIGHT_GRAY);
		sumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contador += 1;
				visible(contador);
				panel.repaint();
			}
		});
		sumar.setBounds(333, 82, 124, 23);
		panel.add(sumar);

		JButton igual = new JButton("=");
		igual.setBackground(Color.LIGHT_GRAY);
		igual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (contador == 2) {
					if (a.getText().equals("") || b.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "todas las casillas deben estar llenas");
					} else {
						numeros.add(Integer.valueOf(a.getText()));
						numeros.add(Integer.valueOf(b.getText()));
					}
				} else if (contador == 3) {
					if (a.getText().equals("") || b.getText().equals("") || c.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "todas las casillas deben estar llenas");
					} else {
						numeros.add(Integer.valueOf(a.getText()));
						numeros.add(Integer.valueOf(b.getText()));
						numeros.add(Integer.valueOf(c.getText()));
					}
				} else if (contador == 4) {
					if (a.getText().equals("") || b.getText().equals("") || c.getText().equals("")
							|| d.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "todas las casillas deben estar llenas");
					} else {
						numeros.add(Integer.valueOf(a.getText()));
						numeros.add(Integer.valueOf(b.getText()));
						numeros.add(Integer.valueOf(c.getText()));
						numeros.add(Integer.valueOf(d.getText()));
					}
				} else if (contador == 5) {
					if (a.getText().equals("") || b.getText().equals("") || c.getText().equals("")
							|| d.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "todas las casillas deben estar llenas");
					} else {
						numeros.add(Integer.valueOf(a.getText()));
						numeros.add(Integer.valueOf(b.getText()));
						numeros.add(Integer.valueOf(c.getText()));
						numeros.add(Integer.valueOf(d.getText()));
						numeros.add(Integer.valueOf(x.getText()));
					}
				}
				ordenar();
				mcd = solucion();
				salida.setText(salida.getText() + "el MCD es: " + mcd);
				numeros.clear();
			}
		});
		igual.setBounds(368, 163, 89, 23);
		panel.add(igual);

		JButton btnNewButton = new JButton("quitar n\u00FAmero");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contador -= 1;
				visible(contador);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(330, 116, 127, 23);
		panel.add(btnNewButton);

		salida = new JTextArea();
		salida.setBackground(Color.WHITE);
		salida.setForeground(Color.BLACK);
		salida.setBounds(23, 109, 269, 322);
		panel.add(salida);

		JButton limpiar = new JButton("limpiar");
		limpiar.setBackground(Color.LIGHT_GRAY);
		limpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeros.clear();
				a.setText("");
				b.setText("");
				c.setText("");
				d.setText("");
				x.setText("");
				salida.setText("");
			}
		});
		limpiar.setBounds(368, 208, 89, 23);
		panel.add(limpiar);

	}

	private int solucion() {
		for (int a = numeros.size() - 1; a > 0; a--) {
			int i = a - 1;
			int j = a;
			int primero = numeros.get(i);
			int segundo = numeros.get(j);
			do {
				if (primero < segundo) {
					salida.setText(salida.getText() + segundo + " = " + primero + " * " + segundo / primero + " + "
							+ segundo % primero + " \n");
					if (segundo % primero == 0) {
						if (i == 0) {
							return primero;
						} else {
							numeros.set(i, primero);
						}
					} else {
						numeros.set(i, (solucion(primero, segundo % primero)));
						if (i == 0) {
							return numeros.get(i);
						}
					}
				} else if (primero > segundo) {
					salida.setText(salida.getText() + primero + " = " + segundo + " * " + primero / segundo + " + "
							+ primero % segundo + " \n");
					if (primero % segundo == 0) {
						if (i == 0) {
							return segundo;
						} else {
							numeros.set(i, (segundo));
						}
					} else {
						numeros.set(i, (solucion(segundo, primero % segundo)));
						if (i == 0) {
							return (numeros.get(i));
						}
					}
				}
			} while (segundo % primero == 0);
		}
		return 1;
	}

	private int solucion(int primero, int segundo) {
		if (primero > segundo) {
			salida.setText(salida.getText() + primero + " = " + segundo + " * " + primero / segundo + " + "
					+ primero % segundo + " \n");
			if (primero % segundo == 0) {
				return segundo;
			} else {
				return solucion(segundo, primero % segundo);
			}
		} else if (primero < segundo) {
			salida.setText(salida.getText() + segundo + " = " + primero + " * " + segundo / primero + " + "
					+ segundo % primero + " \n");
			if (segundo % primero == 0) {
				return primero;
			} else {
				return solucion(primero, segundo % primero);
			}
		}
		return 1;
	}

	private void ordenar() {
		int aux;
		for (int j = 0; j < numeros.size(); j++) {
			for (int i = numeros.size() - 1; i > 0; i--) {
				int a = i - 1;
				if (numeros.get(i) > numeros.get(a)) {
					aux = numeros.get(i);
					numeros.set(i, numeros.get(a));
					numeros.set(a, aux);
				}
			}
		}
	}

	public void visible(int contador) {
		if (contador == 2) {
			c.setVisible(false);
			d.setVisible(false);
			x.setVisible(false);
		} else if (contador == 3) {
			c.setVisible(true);
			d.setVisible(false);
			x.setVisible(false);
		} else if (contador == 4) {
			c.setVisible(true);
			d.setVisible(true);
			x.setVisible(false);
		} else if (contador == 5) {
			c.setVisible(true);
			d.setVisible(true);
			x.setVisible(true);
		}
	}

	class FondoPanel extends JPanel {
		private Image imagen;

		public void paint(Graphics g) {
			imagen = new ImageIcon(getClass().getResource("src\\fondo\\fondo.jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);

		}
	}
}
