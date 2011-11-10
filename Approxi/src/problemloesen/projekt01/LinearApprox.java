package problemloesen.projekt01;

import java.util.Vector;

public class LinearApprox
{
	int grad;									// Grad des Polynoms; muss >= 0 
	double koeffizienten[] = new double[10];  	// Globales Array für Koeffizienten des Polynoms
	Vector <Point> koeffizientenPoints;

    public LinearApprox ()  
    {
    }
    
    public LinearApprox (int grad)  
    {
    	this.grad = grad;
    }
    
    public void start () 
    {
    //   an = 200.0*(random()-0.5);
    //Initialisierung:
    double sinuskurve[] = new double[1000];
    double ergebnis[] = new double[1000];
    double MAX; //old
    
    double a = 0;
    double b = Math.PI;
    double s = 50;
    int n = 5;

    double maxAbweichungWert[] = {0.0 ,Double.MAX_VALUE};	// maximale Abweichung g(x) - f(x)
    int maxAbweichungSchritt = 0;							// Schritt an dem die max. Abweichung vorliegt
    double schrittweite = 0.1;								//
    double vergleichswerte[][];
    double ergebnissePoly[][];
    double abweichung[][];
    //= 		new  double[(int) ((a - b) / schrittweite) + 1];
   
    // Koeffizienten Initialisieren
    koeffizienten[0] = 0.0;
    koeffizienten[1] = 0.0;
    koeffizienten[2] = 1.0;
    koeffizienten[3] = 0.0;
    koeffizienten[4] = 0.0;
    koeffizienten[5] = 0.0;
    
    // Koeffizienten mit Points 
    koeffizientenPoints = new Vector<Point>(n + 1);			// Polynom n-ten Grades brauch n+1  
    koeffizientenPoints.add(new PointApprox(0.0));			// n 0
    koeffizientenPoints.add(new PointApprox(0.0));			// n 1 
    koeffizientenPoints.add(new PointApprox(1.0));			// n 2 
    koeffizientenPoints.add(new PointApprox(0.0));			// n 3
    koeffizientenPoints.add(new PointApprox(0.0));			// n 4
    koeffizientenPoints.add(new PointApprox(0.0));			// n 5
    
    //sinuskurve = sinusx(a,b,s);
    vergleichswerte = calculateToApprox_for_interval(a,b,schrittweite);
    //MAX = maxnorm(sinuskurve,n,s,a,b);
    
    // Initialisieren 
    ergebnissePoly = new double [vergleichswerte.length][2];
    abweichung = new double [vergleichswerte.length][2];
    for (int i = 0; i < vergleichswerte.length; i++) 
    {
    	ergebnissePoly[i][0] = vergleichswerte[i][0]; //copy x value
    	abweichung[i][0] = vergleichswerte[i][0];
	}
    
    // TODO hier schleife, koeffizienten auswählen
    
    // Abweichung berechnen
    System.out.println("------------------------------");
    System.out.println("X\t\tg(x)\t\tf(x)\t\tDelta");
    for (int i = 0; i < vergleichswerte.length; i++) 
    {
    	ergebnissePoly[i][1] = poly(3, vergleichswerte[i][1]); //calc y value
    	abweichung[i][1] = Math.abs(vergleichswerte[i][1] - ergebnissePoly[i][1]);
    	System.out.println(vergleichswerte[i][0] + "\t" +  vergleichswerte[i][1] + "\t" + ergebnissePoly[i][1]+ "\t" + abweichung[i][1]);
    	///
    	// Maximum finden 
    	if (abweichung[i][1] < maxAbweichungWert[1])
    	{
    		maxAbweichungWert[0] = abweichung[i][0];
    		maxAbweichungWert[1] = abweichung[i][1];
    		maxAbweichungSchritt = i;
    	}
	}
    System.out.println(maxAbweichungWert[0] + "\t" + maxAbweichungWert[1]);
    
    
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
    
    public double poly_alt (double x)
    {
    	double a = 0;
    	for (int i = 0; i < koeffizienten.length; i++)
    	{
    		a += Math.pow(x, i) * koeffizienten[i];
    	}
    	return a;
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
    	System.out.println("Nr.\t" + "X\t\t\t" + "Y");
    	for (double x = intervalStart; x <= intervalEnd; x += stepSize)
    	{
    		result[i][0] = x;
    		result[i][1] = calculateToApprox_for_x(x);
    		System.out.println(i + "\t" + result[i][0] + "\t" + result[i][1]);
    		i++;
    	}
    	return result;
    }
    
    public double calculateToApprox_for_x(double x)
    {
    	//define g(x) here 
    	return Math.sin(x)/x;
    }

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public double[] getKoeffizienten() {
		return koeffizienten;
	}

	public void setKoeffizienten(double[] koeffizienten) {
		this.koeffizienten = koeffizienten;
	}
    
    
}
