package Calc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PaintContext;
import java.awt.Polygon;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JPanel;

public class Interface extends JPanel {
	
	String f;int max;
    int N = 1000;
	
 Interface(String f,int max){
		this.f=f;
		this.max=max;
	 }
	
 public void start(){
 
 double[] x = new double[N+1];
 double[] y = new double[N+1];
 
 x[0]=max;
 
 String l,k;
	 int i=1;
     while(i<=1000){  
     l="";k="";
     x[i] = x[i-1]+20.0/1000;
     l=tobigdecimal(x[i]);
   
 try{     
	  k= virgule_to_point(Calcul.Cl(Calculatrice.fonction(f,l)));
      y[i]= Double.parseDouble(virgule_to_point(Calcul.Cl(Calculatrice.fonction(f,l))));
      
 }catch(NumberFormatException e)
       {i=i+1; y[i]=Double.parseDouble("NaN");}
 
     i++; 
     
     }
     
     
 //rescale the coordinate system 
 StdDraw.setXscale(-5.0, 5.0);
 StdDraw.setYscale(-5.0, 5.0);
 StdDraw.line(0.0,-20.0,0.0,20.0);
 StdDraw.line(-20.0,0.0,20.0,0.0);
 StdDraw.line(1.0,-0.05,1,0.05);
 StdDraw.line(-0.05,1.0,0.05,1.0);
 
 //plot the approximation to the function
 StdDraw.setPenColor(Color.RED);
 
 for (int j=1; j< N; j++){
     StdDraw.line(x[j], y[j], x[j+1], y[j+1]);
	 }
 
}

public String  tobigdecimal(double d) { 
	MathContext mc = new MathContext(10); 
	BigDecimal b = new BigDecimal(d,mc); 
	return b.toPlainString();
   }
 
public String virgule_to_point(String s){	
	for(int i = 0; i < s.length(); i++){
		   if(s.charAt(i)==','){s=s.substring(0,i)+"."+s.substring(i+1,s.length());break;}
	   }
	return s;
   }
	
}


	

