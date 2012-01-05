package net.verymuchme.commonreturn;

import java.io.IOException;


/**
 * <p>Class to provide common container for complex returned values. No external dependencies</p>
 * 
 * @author tflynn
 */
public final class CommonReturn<T> {
	
	public static final Throwable NULL_THROWABLE = (new NullObject<Throwable>(Throwable.class)).instance();
	public static final String NULL_STRING = (new NullObject<String>(String.class)).instance();
	
	private final T valueObject;
	private final Throwable throwable;
	private final Status status;
	private final String errorText;
	
	public CommonReturn(T valueObject) {
		this.valueObject = valueObject;
		this.throwable = NULL_THROWABLE;
		this.status = Status.UNDEFINED;
		this.errorText = NULL_STRING;
	}

	public CommonReturn(T valueObject, Throwable throwable) {
		this.valueObject = valueObject;
		this.throwable = throwable;
		this.status = Status.UNDEFINED;
		this.errorText = NULL_STRING;
	}

	public CommonReturn(T valueObject, Throwable throwable, Status status) {
		this.valueObject = valueObject;
		this.throwable = throwable;
		this.status = status;
		this.errorText = NULL_STRING;
	}

	public CommonReturn(T valueObject, Throwable throwable, Status status, String errorText) {
		this.valueObject = valueObject;
		this.throwable = throwable;
		this.status = status;
		this.errorText = errorText;
	}
	
	public T getValue() {
		return this.valueObject;
	}
	
	public Throwable getThrowable() {
		return this.throwable;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public String getErrorText() {
		return this.errorText;
	}
}
