package problemloesen.projekt01;

import java.util.Vector;

public abstract class Point 
{
	protected Vector <Double> values;				// Values regarding one point, e.g.: x,y
	protected Point ancestor;						// Copy of this point before mutating 
	
	public Vector<Double> getValues() {
		return values;
	}
	public void setValues(Vector<Double> values) {
		this.values = values;
	}
	public Point getAncestor() {
		return ancestor;
	}
	public void setAncestor(Point ancestor) {
		this.ancestor = ancestor;
	}
}
