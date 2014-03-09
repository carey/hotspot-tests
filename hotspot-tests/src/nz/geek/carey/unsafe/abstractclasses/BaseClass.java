package nz.geek.carey.unsafe.abstractclasses;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class BaseClass {
	protected static final AtomicReferenceFieldUpdater<BaseClass, Object> updater;

	static {
		AtomicReferenceFieldUpdater<BaseClass, Object> u = null;
		try {
			u = new UnsafeUpdater<BaseClass, Object>(BaseClass.class, "_ref");
		} catch (Exception ignored) {
		}
		updater = u != null ? u : AtomicReferenceFieldUpdater.newUpdater(
				BaseClass.class, Object.class, "_ref");
	}

	private volatile Object _ref;

	protected final boolean updateState(Object o, Object n) {
		return updater.compareAndSet(this, o, n);
	}

	protected final Object getState() {
		return _ref;
	}
}
