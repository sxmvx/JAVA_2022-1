import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel implements ActionListener {
	JTextField a, b, c, d;
	JLabel text;
	double A, B, C, D;  

	public MyPanel() {
		a = new JTextField("a", 10);
		b = new JTextField("b", 10);
		c = new JTextField("c", 10);
		d = new JTextField("d", 10);
		text = new JLabel("y = ax^3 + bx^2 + cx + d");
		add(a);
		add(b);
		add(c);
		add(d);
		add(text);
		JButton button = new JButton("DRAW");
		add(button);
		button.addActionListener(this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, 200, 400, 200);
		g2.drawLine(200, 0, 200, 400);
		g2.setPaint(Color.red);
		for (int i = -20; i < 20; i++) {
			int x = i;
			int y = (int) (A * x * x * x + B * x * x - C * x + D);
			g2.fillOval(200 + x - 2, 200 - (y - 2), 4, 4);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		D = Double.parseDouble(d.getText());
		repaint();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(500, 400);
		f.setVisible(true);
	}
}