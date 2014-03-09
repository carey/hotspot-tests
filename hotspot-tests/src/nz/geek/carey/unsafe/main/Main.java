package nz.geek.carey.unsafe.main;

import nz.geek.carey.unsafe.abstractclasses.TestClass;

public class Main {
	public static void main(String[] args) {
		String s1 = "s1";
		String s2 = "s2";
		TestClass test = new TestClass();
		test.set(null, s1);
		for (int i = 10; i < 100000000; i++) {
			test.set(s1, s2);
			test.set(s2, s1);
		}
	}
}
