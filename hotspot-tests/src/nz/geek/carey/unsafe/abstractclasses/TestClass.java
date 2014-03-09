package nz.geek.carey.unsafe.abstractclasses;

public class TestClass extends BaseClass {
	public boolean set(Object o, Object n) {
		return updateState(o, n);
	}
}
