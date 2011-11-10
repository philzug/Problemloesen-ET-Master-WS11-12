package problemloesen.projekt01.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problemloesen.projekt01.LinearApprox;

public class LinearApproxCalculationTests {

	LinearApprox approx;

	@Before
	public void setUp() throws Exception {
		approx = new LinearApprox(5);
		return;
	}

	@After
	public void tearDown() throws Exception {
		approx = null;
	}

	@Test
	public void testOne() {
		double ergebnis[][] = approx.calculateToApprox_for_interval(0, Math.PI,
				0.01);
		System.out.println("Nr.\t" + "X\t" + "Y");
		for (int i = 0; i < ergebnis.length; i++) {
//			System.out.println(i + "\t" + ergebnis[i][0] + "\t"
//					+ (ergebnis[i][1]));
		}
		// TODO find real assertion
		assert (true);
	}

	@Test
	public void testPoly() {
		double koeffizienten[] = { 0.0, 0.0, 1.0 };
		approx.setKoeffizienten(koeffizienten);
		for (int i = 0; i < 100000000; i++) {
			double erg = approx.poly(2, i);
//			System.out.println(erg);
//			assertEquals(Math.pow(i, 2), erg, 0.001);
			
		}
		assert(true);
	}

	@Test
	public void testPolyAlt() {
		double koeffizienten[] = { 0.0, 0.0, 1.0 };
		approx.setKoeffizienten(koeffizienten);
		for (int i = 0; i < 100000000; i++) {
			double erg = approx.poly_alt(i);
//			System.out.println(Math.round(erg));
//			assertEquals(Math.pow(i, 2), erg, 0.001);
			
		}
		assert(true);
	}

}
