package net.verymuchme.commonreturn;

/**
 * Class to provide generic NullObject support
 * 
 * @author tflynn
 *
 */
public final class NullObject<T> {
	
	private final Class<T> klass;
	
	public NullObject(Class<T> klass) {
		super();
		this.klass = klass;
	}
	
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() == otherObject.getClass()) return true;

		return false;
	}

	public T instance() {
		T inst = null;
		try {
			inst = klass.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return inst;
	}

}
