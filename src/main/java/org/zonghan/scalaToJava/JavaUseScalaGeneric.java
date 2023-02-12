package org.zonghan.scalaToJava;

/**
 * Created by 摇摆少年梦 on 2015/8/16.
 */
public class JavaUseScalaGeneric {
	public static void main(String[] args) {
		Student<String, Integer> student = new Student<String, Integer>("小李", 18);
		//Scala版本的getter方法
		System.out.println(student.name());
		//JavaBean版本的getter方法
		System.out.println(student.getName());
	}
}