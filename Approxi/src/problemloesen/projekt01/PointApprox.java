package problemloesen.projekt01;

import java.util.Vector;

/**
 * @brief 	Koeffizient eines Polynoms
 * @author 	Philipp
 *
 */
public class PointApprox extends Point {
	
	/**
	 * 
	 * @param value		Wert des Koeffizienten
	 */
	public PointApprox (Double value)
	{
		this.values = new Vector<Double>(1);
		values.add(value);
		return;
	}
	
	@Override
	/**
	 * @return Clone of this object
	 */
	public PointApprox clone()
	{
		PointApprox clone = new PointApprox(this.values.firstElement());
		return clone;
	}

}
