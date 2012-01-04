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
	
	public String toString() {
		String stringValue;
		
        switch (enumValue) {
        case 0:
        	stringValue = "UNDEFINED";
            break;
        case 1:
        	stringValue = "SUCCESS";
            break;
        case 2:
        	stringValue = "FAILURE";
            break;
        case 3:
        	stringValue = "ERROR";
            break;
        default:
        	stringValue = "UNDEFINED";
            break;
        }
        return stringValue;
    }

}

