package nz.geek.carey.unsafe.abstractclasses;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import nz.geek.carey.unsafe.common.UnsafeLocator;

public class UnsafeUpdater<T, V> extends AtomicReferenceFieldUpdater<T, V> {
	private final long _refoffset;

	public UnsafeUpdater(Class<T> target, String field)
			throws SecurityException, NoSuchFieldException {
		_refoffset = UnsafeLocator.instance.objectFieldOffset(target
				.getDeclaredField(field));
	}

	@Override
	public boolean compareAndSet(T t, V o, V n) {
		return UnsafeLocator.instance.compareAndSwapObject(t, _refoffset, o, n);
	}

	@Override
	public V get(T t) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void lazySet(T t, V n) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(T t, V n) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean weakCompareAndSet(T t, V o, V n) {
		throw new UnsupportedOperationException();
	}
}
