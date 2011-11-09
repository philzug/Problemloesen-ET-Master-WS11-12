
public class Pointperl {
	
	public int number;
	public double x;
	public double y;
	public double weight;
	public double min[] = new double[2];
	public double dxlength;
	public double length1;  //Länge l zur vorherigen Kugel
	public double length2;	//Länge l zur nächsten Kugel
	Pointperl next;
	Pointperl last;
	
	public Pointperl(int number, double x, double y, double weight){
		this.number = number;
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	
	void in(Pointperl z) {	
		z.next = next;
		next = z;
	}
	
	void inend(Pointperl z) {	
		z.last = last;
		last = z;
	}
	
	Pointperl setnumber(int number){
		this.number = number;
		return this;
	}
	
	int getnumber(){
		return number;
	}
	
	void setxvalue(double x){
		this.x = x;
	}
	
	void setyvalue(double y){
		this.y = y;
	}
	
	double getxvalue(){
		return this.x;
	}
	
	double getyvalue(){
		return this.y;
	}
	
	void setweight(double weight){
		
		this.weight = weight;			
	}
	
	double getweight(){
		return this.weight;
	}
	
	void setmin(double min[]){
		this.min = min;
	}
	
	double[] getmin(){
		return min;
	}
	
	void setdxlength(double dxlength){
		this.dxlength = dxlength;
	}
	
	double getdxlength(){
		return dxlength;
	}

	public double getLength1() {
		return length1;
	}

	public void setLength1(double length1) {
		this.length1 = length1;
	}

	public double getLength2() {
		return length2;
	}

	public void setLength2(double length2) {
		this.length2 = length2;
	}
	
	
	
}
