package org.zonghan.scalaToJava;

import minmax.MinMax;
import scala.Array;
import scala.Int;

/**
 * Created by wuzonghan on 17/2/14.
 */
public class MainJava {
	public static void main(String[] args) {
		Array<Int> intsA = new Array<Int>(1);
		int[] ints = new int[]{1,2,3};
		int x = 1;
		MinMax m = new MinMax();
		m.testInt(x);
		m.getResult(ints);
 	}
}
