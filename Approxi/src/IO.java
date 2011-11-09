import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class IO {
	
	static double a;
	static double b;
    static double l;
    static double s;
    static double ge;
    static double ebeiwert;
    static int n;
	
	public void InputPerl()
	{
	
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	//System.out.print("Geben Sie Anzahl n ein: ");
	//String zeile = null;
	try {
		
		//zeile = console.readLine();
		//s = console.readLine();
		System.out.print("Geben Sie die Anzahl der Kugeln n ein: ");
		n = Integer.parseInt(console.readLine());
		System.out.print("Geben Sie den Abstand a ein: ");
		a = Double.parseDouble(console.readLine());
		System.out.print("Geben Sie die Länge l ein: ");
		l = Double.parseDouble(console.readLine());
		System.out.print("Geben Sie das Gewicht g ein: ");
		ge = Double.parseDouble(console.readLine());
		System.out.print("Geben Sie das Elastizitätsmodul e ein: ");
		ebeiwert = Double.parseDouble(console.readLine());
		//c = (char)d;
		
		
	} catch (IOException e) {
		// Sollte eigentlich nie passieren
		e.printStackTrace();
	}
	System.out.println("Ihre Eingabe war n: " + n);
	System.out.println("Ihre Eingabe war a: " + a);
	System.out.println("Ihre Eingabe war l: " + l);
	System.out.println("Ihre Eingabe war g: " + ge);
	System.out.println("Ihre Eingabe war e: " + ebeiwert);
   }
	
	public void InputApproxi()
	{
	
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	//System.out.print("Geben Sie Anzahl n ein: ");
	//String zeile = null;
	try {
		
		//zeile = console.readLine();
		//s = console.readLine();
		System.out.print("Geben Sie Anzahl n ein: ");
		n = Integer.parseInt(console.readLine());
		System.out.print("Geben Sie Intervallanfang a ein: ");
		a = Double.parseDouble(console.readLine());
		System.out.print("Geben Sie Intervallende b ein: ");
		b = Double.parseDouble(console.readLine());
		//c = (char)d;
		
		
	} catch (IOException e) {
		// Sollte eigentlich nie passieren
		e.printStackTrace();
	}
	System.out.println("Ihre Eingabe war n: " + n);
	System.out.println("Ihre Eingabe war n: " + a);
	System.out.println("Ihre Eingabe war n: " + b);
   }
	
	
	
   public static void OutputPerl(String sFileName, double array[])
   {
	 	try
	 	{
	 		File file = new File(sFileName);
	 		if(file.exists()){
	            file.delete();
	        }
	 		
	 	    FileWriter writer = new FileWriter(sFileName);   
	 	    
	 	    for(int i=0;i<array.length;i++){
	 	    	;
	 	    	writer.append(Double.toString(array[i]));
	 	    	writer.append(';');
	 	    	writer.append('\n');
	 	    }
	 	     
	 	    writer.flush();
	 	    writer.close();
	 	}
	 	catch(IOException e)
	 	{
	 	     e.printStackTrace();
	 	} 
   }
   
   static void readFile(String sFileName)
   {
   	try {
   	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sFileName)));
   	
   	String line;
   	try {
   	while ((line =br.readLine())!=null)
   	{System.out.println(line);
   	}}
   	catch (IOException e) {
   	e.printStackTrace();}}
   	catch (FileNotFoundException e) {
   	e.printStackTrace();

   	}
   	
   }
   
   public static void OutputApproxi(String sFileName, double array[])
   {
	 	try
	 	{
	 		File file = new File(sFileName);
	 		if(file.exists()){
	            file.delete();
	        }
	 		
	 	    FileWriter writer = new FileWriter(sFileName);   
	 	    
	 	    for(int i=0;i<array.length;i++){
	 	    	;
	 	    	writer.append(Double.toString(array[i]));
	 	    	writer.append(';');
	 	    	writer.append('\n');
	 	    }
	 	     
	 	    writer.flush();
	 	    writer.close();
	 	}
	 	catch(IOException e)
	 	{
	 	     e.printStackTrace();
	 	} 
   }
   
	
}
