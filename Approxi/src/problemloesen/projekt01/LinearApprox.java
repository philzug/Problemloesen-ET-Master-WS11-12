package problemloesen.projekt01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.TreeMap;

public class LinearApprox
{
	short grad;									// Grad des Polynoms; muss >= 0 
	double koeffizienten[] = new double[10];  	// Globales Array für Koeffizienten des Polynoms

    public LinearApprox ()  
    {
    }
    
    public LinearApprox (int grad)  
    {
    	
    }
    
    public void init ()
    {
    	
    	return;
    }

    public void start () 
    {
    //   an = 200.0*(random()-0.5);
    //Initialisierung:
    double sinuskurve[] = new double[1000];
    double ergebnis[] = new double[1000];
    double MAX;
    
    
    double a = 0;
    double b = Math.PI;
    double s = 50;
    int n = 5;
  
   
    koeffizienten[0] = 0;
    koeffizienten[1] = 0;
    koeffizienten[2] = 1;
    koeffizienten[3] = 0;
    koeffizienten[4] = 0;
    koeffizienten[5] = 0;
    
    
    
    
    sinuskurve = sinusx(a,b,s);
    MAX = maxnorm(sinuskurve,n,s,a,b);
    
    for(int i=0;i<50;i++){
     System.out.printf("%f \n", MAX);
    }
    
     
  //  IO.OutputApproxi("c:\\Daten für Speicher\\Master\\Master 2.Semester\\Problemlösen\\Projekt\\test.csv",sinuskurve); 
  //  IO.readFile("c:\\Daten für Speicher\\Master\\Master 2.Semester\\Problemlösen\\Projekt\\test.csv");
    
  }
    

    
    
    public double maxnorm(double Ergebnis[],int n, double s, double a, double b)
    {
       double m[] = new double[1000];
       int i = 0;
       double Max;
        
        for(double c=a;c<b;c+=b/s){
            
            m[i] = Math.abs(Ergebnis[i]-poly(n,c));
            i++;
               
        
        }
        Max = maximum(m);
        
       return Max;
    }
    
    static public double maximum(double x[]){
        double maxi = x[0];
        for(int i=0;i<x.length;i++){
            if (x[i] > maxi){
             maxi = x[i];
            }
        }
       return maxi;
    }
    
    
    public double poly(int n, double x)
    {
    	double res=0;
    	
    	res += koeffizienten[n];
        for(int i=n-1;i>=0;i--){
        	res += koeffizienten[i];
            res*=x;       
        }
     return  res;
    }
    
    static public double[] sinusx(double a, double b, double s)
    {
        double E[] = new double[1000];
        int i = 0;
        double x = b/s;
        
        for(double c=a;c<b;c+=x){
        	if(c > 0){
        		E[i] = Math.sin(c)/c;
        		i++;
        	}
        }
       
        return E;
    }
    
    /**
     * 
     * @param intervalStart
     * @param intervalEnd
     * @param stepSize
     * @return	List with x and y pairs   
     */
    public double[][] calculateToApprox_for_interval (double intervalStart, double intervalEnd, double stepSize)
    {
    	int numberOfSteps = (int) ((intervalEnd - intervalStart) / stepSize);
    	// for all steps one x,y pair
    	double result[][] = new double [numberOfSteps + 1] [2];
    	int i = 0;
//    	System.out.println("Nr.\t" + "X\t\t\t" + "Y");
    	for (double x = intervalStart; x <= intervalEnd; x += stepSize)
    	{
    		result[i][0] = x;
    		result[i][1] = calculateToApprox_for_x(x);
//    		System.out.println(i + "\t" + result[i][0] + "\t" + result[i][1]);
    		i++;
    	}
    	return result;
    }
    
    public double calculateToApprox_for_x(double x)
    {
    	//define g(x) here 
    	return Math.sin(x)/x;
    }
    
    
}
