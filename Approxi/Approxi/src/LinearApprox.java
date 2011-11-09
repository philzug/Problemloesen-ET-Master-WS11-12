

/**
 * Beschreiben Sie hier die Klasse Approx.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class LinearApprox
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
	static double A[] = new double[1000];  //Globales Array für Koeffizienten des Polynoms
	static double res=0;                     //Ergebnis des Polynoms	

    /**
     * Konstruktor für Objekte der Klasse Approx
     */
    public LinearApprox(int n)  //n ist der Grad des Polynoms
    {
        // Instanzvariable initialisieren
        
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public static void main(String[] args) 
	
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
  
   
    A[0] = 0;
    A[1] = 0;
    A[2] = 1;
    A[3] = 0;
    A[4] = 0;
    A[5] = 0;
    
    
    
    
    sinuskurve = sinusx(a,b,s);
    MAX = maxnorm(sinuskurve,n,s,a,b);
    
    for(int i=0;i<50;i++){
     System.out.printf("%f \n", MAX);
    }
    
     
  //  IO.OutputApproxi("c:\\Daten für Speicher\\Master\\Master 2.Semester\\Problemlösen\\Projekt\\test.csv",sinuskurve); 
  //  IO.readFile("c:\\Daten für Speicher\\Master\\Master 2.Semester\\Problemlösen\\Projekt\\test.csv");
    
  }
    

    
    
    static public double maxnorm(double Ergebnis[],int n, double s, double a, double b)
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
    
    
    static public double poly(int n, double x)
    {
    	double res=0;
    	
    	res += A[n];
        for(int i=n-1;i>=0;i--){
        	res += A[i];
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
    
    
}
