import java.text.*;

public class CubicEquation {

	void thirdSolve(double a, double b, double c, double d) {
		double x1 = 0;
		double x2 = 0;
		double x3 = 0;
		double F = 0;
		double G = 0;
		double H = 0;
		double I = 0;
		double J = 0;
		double K = 0;
		double L = 0;
		double M = 0;
		double N = 0;
		double P = 0;
		double D = 0;
		DecimalFormat de = new DecimalFormat("##.######");
		
		D = Math.pow(c,  2)*Math.pow(b, 2)-4*d*Math.pow(b, 3)-4*a*Math.pow(c, 3)
				+18*a*b*c*d-27*Math.pow(d, 2)*Math.pow(a, 2);
		F = (((3*c)/a)-(Math.pow(b, 2)/Math.pow(a, 2)))/3;
		G = ((2*Math.pow(b, 3)/Math.pow(a, 3))-((9*b*c)/Math.pow(a, 2))+(27*d/a))/27;
		H = (Math.pow(G, 2)/4)+(Math.pow(F, 3)/27);
		
		System.out.println("입력한 함수의 Y축과의 교점을 계산합니다.");
		System.out.println("방정식 "+a+"x^3+"+b+"x^2+"+c+"x+"+d+"=0 의 근을 계산합니다.");
		
		if(D==0) {
			x1 = Math.cbrt(d/a)*(-1);
			System.out.println("x1 = x2 = x3 = "+de.format(x1));
			System.out.println("y="+a+"x^3+"+b+"x^2+"+c+"x+"+d+"의 함수는 x좌표가 "+x1+"일 때 Y축과 접합니다.");
		}
		else if(D>0) {
			I = Math.sqrt(Math.pow(G, 2)/4-H);
			J = Math.cbrt(I);
			K = Math.acos(-(G/(2*I)));
			L = J*(-1);
			M = Math.cos(K/3);
			N = Math.sqrt(3)*Math.sin(K/3);
		  	P = (b/(3*a))*(-1);
			x1 = (2*J)*Math.cos(K/3)-(b/(3*a));
			x2 = L*(M+N)+P;
			x3 = L*(M-N)+P;
			System.out.println("x1 = "+de.format(x1));
			System.out.println("x2 = "+de.format(x2));
			System.out.println("x3 = "+de.format(x3));
			System.out.println("y="+a+"x^3+"+b+"x^2+"+c+"x+"+d+"의 함수는 x좌표가 "+x1+", "+x2+", "+x3+"일 때 Y축과 접합니다.");
		}
		else {
			System.out.println("허근이 존재합니다. Y축과의 교점이 0개입니다.");
		}
	}
	
	void secondSolve(double a, double b, double c) {
		double D = b*b-4*a*c;
		double x1 = (-b+Math.sqrt(D))/(2*a);
		double x2 = (-b-Math.sqrt(D))/(2*a);
		
		System.out.println("입력한 함수의 Y축과의 교점을 계산합니다.");
		System.out.println("방정식 "+a+"x^2+"+b+"x+"+c+"=0 의 근을 계산합니다.");
		
		if(D<0)
		{
			System.out.println("실근이 존재하지 않습니다. Y축과의 교점이 0개입니다.");
		}
		else if(D==0) {
			System.out.println("x1 = x2 = "+(-b/(2*a)));
			System.out.println("y="+a+"x^2+"+b+"x+"+c+"의 함수는 x좌표가 "+x1+"일 때 Y축과 접합니다.");
		}
		else {
			System.out.println("x1 = "+((-b+Math.sqrt(D))/(2*a)));
			System.out.println("x2 = "+((-b-Math.sqrt(D))/(2*a)));
			System.out.println("y="+a+"x^2+"+b+"x+"+c+"의 함수는 x좌표가 "+x1+", "+x2+"일 때 Y축과 접합니다.");
		}
		
	}
	
	void solve(double a, double b) {
		
		System.out.println("입력한 함수의 Y축과의 교점을 계산합니다.");
		System.out.println("방정식 "+a+"x+"+b+"=0 의 근을 계산합니다.");
		double D = -b/a;
		System.out.println("x = "+D);
		System.out.println("y="+a+"x+"+b+"의 함수는 x좌표가 "+D+"일 때 Y축과 접합니다.");
	}
}
