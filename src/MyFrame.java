import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MyFrame extends Frame implements ActionListener {
	
	MyPanel panel;
	CubicEquation ce = new CubicEquation();
	Panel p1, p2, bp1, bp2, lp;
	TextField t1, t2, t3, t4;
	Button b1, b2, b3, capture;
	
	public MyFrame(){
		super("ÇÔSWU °øºÎ");
		this.addWindowListener((WindowListener) new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//panel
		panel = new MyPanel();
		bp1 = new Panel(null);
		bp1.setBounds(0, 0, 580, 550);
		bp2 = new Panel(new BorderLayout());
		lp = new Panel();
		bp1.add(panel, BorderLayout.CENTER);
		
		p1 = new Panel(new FlowLayout());
		bp2.add(p1, BorderLayout.NORTH);
		
		p2 = new Panel(new FlowLayout());
		bp2.add(p2, BorderLayout.SOUTH);
		
		lp.add(bp1, BorderLayout.CENTER);
		lp.add(bp2, BorderLayout.SOUTH);
		this.add(lp);
		
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
		capture = new Button("Capture");
		
		//component add
		p1.add(l1); p1.add(t1);	p1.add(l2);	p1.add(t2); p1.add(l3);
		p1.add(t3); p1.add(l4);	p1.add(t4);	p1.add(b1); p1.add(b2); p1.add(b3);
		p2.add(capture);
		
		MouseListener listener = new Code();
		capture.addMouseListener(listener);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		double a = Double.parseDouble(t1.getText());
		double b = Double.parseDouble(t2.getText());
		double c = Double.parseDouble(t3.getText());
		double d = Double.parseDouble(t4.getText());
		if(arg0.getSource()==b1)
		{
			panel.setGraph(new MyGraph(a, b, c, d));
			if(a==0 && b==0)
				ce.solve(c, d);
			else if(a==0 && b!=0)
				ce.secondSolve(b, c, d);
			else if(a!=0)
				ce.thirdSolve(a, b, c, d);
		}
		else if(arg0.getSource()==b2)
		{
			panel.addGraph(new MyGraph(a, b, c, d));
			if(a==0 && b==0)
				ce.solve(c, d);
			else if(a==0 && b!=0)
				ce.secondSolve(b, c, d);
			else if(a!=0)
				ce.thirdSolve(a, b, c, d);
		}
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
		MyFrame f1 = new MyFrame();
		f1.setSize(600, 700);
		f1.setVisible(true);
		
	}

}