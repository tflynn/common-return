package net.verymuchme.commonreturn;

/**
 * Class to provide standard statuses for CommonReturn
 * 
 * @author tflynn
 *
 */
public enum Status {
	
	UNDEFINED(0),
	SUCCESS(1),
	FAILURE(2),
	ERROR(3);

	private final int enumValue;

	Status(int enumValue) {
		this.enumValue = enumValue;
	}
	
}

