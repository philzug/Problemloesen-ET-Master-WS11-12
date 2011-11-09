package problemloesen.projekt01;

public class StringofPerl {
	static Pointperl list = new Pointperl(0,0,0,0);						//First Head of Pointer List
	static Pointperl relist = new Pointperl(0,0,0,0);					//Weiterer Head of Pointer List
	static Pointperl listend = new Pointperl(0,0,0,0);					//Last Head of Pointer List
	static Pointperl relistend = new Pointperl(0,0,0,0);				//Weiterer Last Head of Pointer List
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 5;				//Anzahl Kugeln
		double w = 0.001;		//Gewicht pro Kugel in Kg
		double a = 0.2;			//Abstand in Meter
		double dlength;
		double b1=0;				//Temporäre Variable
		double b2=0;
		
	//	IO inout = new IO();
	//	inout.InputPerl();
		
		for(int i=n+1;i>1;i--){
			
			b1 = b1+a/(n+1);		//Schrittweite für Startwerte der Positionen der Kugeln
			b2 = a-b1;
			list.in(new Pointperl(i,b2,0,0));	//Perlenkette erzeugen
			System.out.println("b:" + b2);
		}
		relist.next = list.next;	//Listenkopfanfang merken
		
		while(list.next != null){
					listend.inend(list.next);
					list.next = list.next.next;
				}
		
		relistend.last = listend.last;	//Listenkopfende merken
	
		
		weightsofPerls(n,w);	//Gewichte den Perlen/Kugeln zuordnen
		
		calclength(a);			//Berechnung der einzelnen Längen der Kugeln zu den vorherigen Kugeln
		
		dlength = randi();						//Berechnung von dlength
		
		minimum(0.05,0.5,dlength);	//Berechnet die minimale potentielle Energie jeder Kugel
		
		list.next = relist.next;	//Listenkopf bei Anfang
		listend.last = relistend.last; //Listenkopf bei Ende
		
		while(list.next != null){
	//		System.out.println("Minimale pot. Energie:   " + list.next.getmin() + "      "+ "dlength:  " + list.next.dxlength);
			System.out.println("list.next Length1:  "+list.next.getLength1());
			System.out.println("list.next Length2:  "+list.next.getLength2());
			list.next = list.next.next;
		}
/*		while(listend.last != null){
			//		System.out.println("Minimale pot. Energie:   " + list.next.getmin() + "      "+ "dlength:  " + list.next.dxlength);
					System.out.println("list.last"+listend.last.getLength1());
					listend.last = listend.last.last;
				}*/
		
	}
	
	public static void calclength(double distance){
		double currentpos[] = new double[2]; 	//Position des aktuellen Elements
		double prepos[] = {0.0,0.0};			//Position des vorherigen Elements; Initialisiert mit x = 0 und y = 0
		list.next = relist.next;
		
		while(list.next != null){
			currentpos[0] = list.next.getxvalue();
			currentpos[1] = list.next.getyvalue();
		//	System.out.println(list.next.getxvalue());
			
			list.next.setLength1(Math.sqrt(Math.pow(currentpos[0]-prepos[0],2)+Math.pow(currentpos[1]-prepos[1],2)));
			prepos[0] = currentpos[0];
			prepos[1] = currentpos[1];
			list.next = list.next.next;
		}	
		
		list.next = relist.next;
		
		while(list.next != null){
			prepos[0] = list.next.getxvalue();
			prepos[1] = list.next.getyvalue();
			
			if(list.next.next == null){
				currentpos[0] = distance;
				currentpos[1] = 0;
				list.next.setLength2(Math.sqrt(Math.pow(currentpos[0]-prepos[0],2)+Math.pow(currentpos[1]-prepos[1],2)));
				list.next = list.next.next;
			}
			else{
				currentpos[0] = list.next.next.getxvalue();
				currentpos[1] = list.next.next.getyvalue();
				//	System.out.println(list.next.getxvalue());
			
				list.next.setLength2(Math.sqrt(Math.pow(currentpos[0]-prepos[0],2)+Math.pow(currentpos[1]-prepos[1],2)));
				prepos[0] = currentpos[0];
				prepos[1] = currentpos[1];
				list.next = list.next.next;
			}
		}
		list.next = relist.next;
		
		
	}
	
	public static double randi(){
		
		double wert;
		
		wert = Math.random()*0.01;
	//	System.out.println(wert);	
		return wert;
	}
	
public static double minimum_x(double length, double ebeiwert, double dlength){
		
		double g = 9.81;	//Erdbeschleunigung in m/s^2
		double min;
		
		list.next = relist.next;
		//System.out.println(list.next.getnumber());
		
			min = list.next.getweight()*g-ebeiwert*dlength/length;
		return min;		
	} 
	
	public static void minimum(double length, double ebeiwert, double dlength){
		
		double g = 9.81;	//Erdbeschleunigung in m/s^2
		
		list.next = relist.next;
		//System.out.println(list.next.getnumber());
		
		while(list.next != null){
			list.next.setdxlength(dlength);
	//		list.next.setmin(list.next.getweight()*g-ebeiwert*dlength/length);

			list.next = list.next.next;
		}
		
	} 
	
	
	public static void weightsofPerls(int n, double w){
		
		int counter = 0; 				//Zähler für Gewichtezuordnung der Kugeln
		
		if(isOdd(n)){									//für ungerade n
			while(list.next != null){
				if(list.next.getnumber() <= (n/2)+1){	//solange n kleiner als Mitte der Perlenkette
					System.out.println();
					list.next.setweight(w*(((n-1)/2+0.5)-counter++));  //Gewichte den jeweiligen Kugeln zuordnen
				//	System.out.println("kleiner ungerade n: "+list.next.getnumber() +": " + list.next.getweight());
				}
				if(list.next.getnumber() > (n/2)+1){	//solange n größer als Mitte der Perlenkette
					list.next.setweight(w*(1.5+counter++));				//Gewichte den jeweiligen Kugeln zuordnen
				//	System.out.println("größer ungerade n: "+ list.next.getnumber() +": " + list.next.getweight());	
				}
				if(counter > n/2){
					counter = 0;
				}
				list.next = list.next.next;
			}
			counter = 0;
		}
		
		if(isEven(n)){  								//für gerade n
			while(list.next != null){
				if(list.next.getnumber() <= (n/2)){		//solange n kleiner als Mitte der Perlenkette
				//	System.out.println(list.next.getnumber());
					list.next.setweight(w*(n/2-counter++));			//Gewichte den jeweiligen Kugeln zuordnen
				//	System.out.println("kleiner gerade n: "+ list.next.getweight());
				}
				if(list.next.getnumber() > (n/2)){		//solange n größer als Mitte der Perlenkette
				//	System.out.println(list.next.getnumber());
					list.next.setweight(w*(1+counter++));			//Gewichte den jeweiligen Kugeln zuordnen
				//	System.out.println("größer gerade n: "+ list.next.getweight());
				}
				if(counter == n/2){
					counter = 0;
				}
				list.next = list.next.next;
			}
			counter = 0;
		}
		
	}
	
	public static boolean isEven(int n) {	//für gerade n
		return (n % 2) == 0;
	}

	public static boolean isOdd(int n) {	//für ungerade n
		return !isEven(n);
	}
	
	
	
	
	
	
	
	
	
	/*public static double[] reference(double a, double distance, int n){
		
		double yvalue[] = new double[1000];
		double xvalue[] = new double[1000];
		double length[] = new double[1000];
		
		int i=0;
		
		for(double c = distance*(-0.5); c <= distance*0.5+distance/(n+1) ;c += distance/(n+1)){
			yvalue[i] = a*Math.cosh(c/a)-a;
			xvalue[i] = c;
			i++;
		}
		
		i=0;
		for(double c = distance*(-0.5); c <= distance*0.5 ;c += distance/(n+1)){
			length[i] = Math.sqrt(Math.pow(xvalue[i]-xvalue[i+1],2)+Math.pow(yvalue[i]-yvalue[i+1],2));
			i++;
		}
		
	return yvalue;
	}
	*/
	

}
