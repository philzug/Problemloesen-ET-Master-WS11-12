
public class HookeJeeves {
	
	public double taste(double x, double h, double e){
		
		double x0;
		
		x0 = x;
		for(int i=0; i<2; i++){ 							//alle Dimensionen
			if(f(x0+e*h) < f(x0)) x0 = x0 + e*h;
			else if (f(x0-e*h) < f(x0)) x0 = x0 - e*h;
		}
		
		return x0;
		
	}
	
	public void voranschreiten(double h, double hmin, double x0){
		
		double x1;
		double x2;
		double reduction_factor;
		
		while (h>hmin)
		{
			x1 = taste(x0,h);
			if (f(x1) < f(x0))
			{
				x2 = x1 + (x1 - x0);
				if(f(x2) < f(x1)) x0 = x2;
				else x0 = x1;
			}
			else h = h*reduction_factor;
		}
		
		
	}
	
}
