import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame01 extends Frame implements ActionListener {
	
	MyPanel01 panel;
	Panel p1;
	TextField t1, t2, t3, t4;
	Button b1, b2, b3;
	
	public MyFrame01(){
		super("ÇÔSWU °øºÎ");
		this.addWindowListener((WindowListener) new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//panel
		panel = new MyPanel01();
		this.add(panel, BorderLayout.CENTER);
		
		p1 = new Panel(new FlowLayout());
		this.add(p1, BorderLayout.SOUTH);
		
		//component
		t1 = new TextField(3);
		t2 = new TextField(3);
		t3 = new TextField(3);
		t4 = new TextField(3);
		
		Label l1 = new Label("y=");
		Label l2 = new Label("x^3 +");
		Label l3 = new Label("x^2 +");
		Label l4 = new Label("x +");
		
		b1 = new Button("BLUE");
		b1.addActionListener(this);
		b2 = new Button("RED");
		b2.addActionListener(this);
		b3 = new Button("Clear");
		b3.addActionListener(this);
		
		//component add
		p1.add(l1); p1.add(t1);	p1.add(l2);	p1.add(t2); p1.add(l3);
		p1.add(t3); p1.add(l4);	p1.add(t4);	p1.add(b1); p1.add(b2); p1.add(b3);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		double A = Double.parseDouble(t1.getText());
		double B = Double.parseDouble(t2.getText());
		double C = Double.parseDouble(t3.getText());
		double D = Double.parseDouble(t4.getText());
		if(arg0.getSource()==b1)
			panel.setGraph(new MyGraph(A, B, C, D));
		else if(arg0.getSource()==b2)
			panel.addGraph(new MyGraph(A, B, C, D));
		else if(arg0.getSource()==b3)
			{
				panel.clearGraph();
				panel.setGraph(null);
				panel.addGraph(null);
			}
		panel.repaint();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame01 f1 = new MyFrame01();
		f1.setSize(600, 600);
		f1.setVisible(true);
		
		JFrame capture = new JFrame();
		capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}

}
