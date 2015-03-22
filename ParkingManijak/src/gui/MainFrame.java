package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	JFrame mainFrame;
	JPanel paintPanel;
	
	KeyListener globalKeyListener;
	boolean up,down, left,right;

	@SuppressWarnings("serial")
	public MainFrame() {
		mainFrame = new JFrame("Main parking maniac");
		mainFrame.setSize(new Dimension(800, 600));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initGlobalKeyListener();
		mainFrame.addKeyListener(globalKeyListener);

		paintPanel = new JPanel() {
			@Override
			public void paint(Graphics _g) {
				super.paint(_g);
				Graphics2D g = (Graphics2D) _g;
				g.setColor(Color.GREEN);
				g.drawRect(40, 40, 150, 80);
				
				if (up) {
					g.setColor(Color.RED);
					g.fill(new Rectangle2D.Double(130, 130, 30, 30));
				}
				if (down) {
					g.setColor(Color.BLACK);
					g.fill(new Rectangle2D.Double(130, 170, 30, 30));
				}
				if (left) {
					g.setColor(Color.BLUE);
					g.fill(new Rectangle2D.Double(90, 170, 30, 30));
				}
				if (right) {
					g.setColor(Color.GREEN);
					g.fill(new Rectangle2D.Double(170, 170, 30, 30));
				}
			}
		};
		mainFrame.setContentPane(paintPanel);
	}
	
	int [] pressedKeys = new int[1000];

	private void initGlobalKeyListener() {
		globalKeyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() < 1000) {
					pressedKeys[e.getKeyCode()] = 0;
					refreshKeys(e);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() < 1000) {
					pressedKeys[e.getKeyCode()] = 1;
					refreshKeys(e);
				}
			}
		};
	}
	
	private void refreshKeys(KeyEvent e) {
		System.out.println("e="+ e.getKeyCode());
		up = pressedKeys[38] > 0;
		down = pressedKeys[40] > 0;
		left = pressedKeys[37] > 0;
		right = pressedKeys[39] > 0;
		paintPanel.repaint(5);
	}

	public void show() {
		mainFrame.setVisible(true);
	}

	private void initPaintBuffer() {
	}

	public static void main(String[] args) {
		// test me
		new MainFrame().show();
	}
}
