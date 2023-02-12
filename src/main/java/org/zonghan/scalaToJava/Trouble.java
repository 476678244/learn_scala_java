package org.zonghan.scalaToJava;

/**
 * Created by wuzonghan on 17/2/15.
 */
public class Trouble {
	public static void main(String[] args) {
		Integer[] arr1 = new Integer[2];
		arr1[0] = new Integer(1);
		Object[] arr2 = arr1;
		arr2[1] = new Double(2.0);
		for (Integer i : arr1) {
			System.out.println(i);
		}
	}
}
