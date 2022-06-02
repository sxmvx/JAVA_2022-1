import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private int zoom, endX, endY;
	private double incX, minX, maxX;
	private MyGraph graph, graph2;

	public MyPanel(){
		zoom = 30;
		endX = 580;
		endY = 520;
		graph = null;
		graph2 = null;
		minX = -10;
		maxX = 10;
		incX = 0.1;
		this.setSize(endX,endY);
	}

	public void paint(Graphics g) {
		this.drawAxis(g);
		this.drawGraph(g);
		this.drawGraph2(g);
	}
	
	public void clearGraph() {
		graph = null;
		graph2 = null;
	}
	
	public void drawGraph2(Graphics g) {
		if(graph2==null) return;
		
		double x1 = minX;
		double y1 = graph2.f(x1);
		for(double x= minX + incX; x < maxX; x = x + incX){
			double x2 = x;
			double y2 = graph2.f(x2);
			g.setColor(Color.RED);
			g.drawLine((int) (x1*zoom + endX/2), (int) (endY/2 - y1*zoom),
                                      (int) (x2*zoom + endX/2), (int) (endY/2 - y2*zoom));
			x1 = x2;
			y1 = y2;
		}
	}

	public void drawGraph(Graphics g) {
		if (graph == null)
			return;

		double x1 = minX;
		double y1 = graph.f(x1);
		for (double x = minX + incX; x < maxX; x = x + incX) {
			double x2 = x;
			double y2 = graph.f(x2);
			g.setColor(Color.BLUE);
			g.drawLine((int) (x1 * zoom + endX / 2), (int) (endY / 2 - y1 * zoom), (int) (x2 * zoom + endX / 2),
					(int) (endY / 2 - y2 * zoom));
			x1 = x2;
			y1 = y2;
		}
	}
	
	public void addGraph(MyGraph g) {
		graph2 = g;
	}

	public void setGraph(MyGraph g) {
		graph = g;
	}

	public void drawAxis(Graphics g) {
		// draw edge line
		g.drawLine(0, 0, 0, endY);
		g.drawLine(0, 0, endX, 0);
		g.drawLine(0, endY, endX, endY);
		g.drawLine(endX, 0, endX, endY);
		// x line y line
		g.drawLine(0, endY / 2, endX, endY / 2);
		g.drawLine(endX / 2, 0, endX / 2, endY);
		// x,y arrow
		g.drawLine(endX - 5, (endY / 2) - 5, endX, endY / 2);
		g.drawLine(endX - 5, (endY / 2) + 5, endX, endY / 2);
		g.drawLine(endX / 2 - 5, 5, endX / 2, 0);
		g.drawLine(endX / 2 + 5, 5, endX / 2, 0);
		// 0,x,y
		g.drawString("0", endX / 2 + 2, endY / 2 + 12);
		g.drawString("X", endX - 14, endY / 2 + 12);
		g.drawString("Y", endX / 2 + 10, 13);
		// marking
		for (int k = 1; k < 10; k = k + 1) {
			g.drawLine(endX / 2 + zoom * k, endY / 2 - 3, endX / 2 + zoom * k, endY / 2 + 3);
			g.drawLine(endX / 2 - zoom * k, endY / 2 - 3, endX / 2 - zoom * k, endY / 2 + 3);
		}
		for (int k = 1; k < 9; k = k + 1) {
			g.drawLine(endX / 2 - 3, endY / 2 + zoom * k, endX / 2 + 3, endY / 2 + zoom * k);
			g.drawLine(endX / 2 - 3, endY / 2 - zoom * k, endX / 2 + 3, endY / 2 - zoom * k);
		}
	}
}