package net.verymuchme.commonreturn;

import java.util.HashMap;

/**
 * <p>Class to provide common container for complex returned values. No external dependencies</p>
 * 
 * <p>Additional Information</p>
 * 
 * <p>To provide console debugging specify the command line option</p>
 * <ul><li>-Dnet.verymuchme.commonreturn.consoleTracing=true</li></ul>
 * 
 * 
 * @author tracy
 *
 * 
 */
public class CommonReturn {

	/**
	 * Console Tracing - false by default
	 */
	private boolean consoleTracing = false;
	
	/**
	 * Return status
	 */
	private Boolean returnStatus = null;
	
	/**
	 * Return exception
	 */
	private Exception returnException = null;
	
	/**
	 * HashMap of returned properties as strings
	 */
	private HashMap<String,String> stringProperties = new HashMap<String,String>();
	
	/**
	 * HashMap of returned properties as Objects
	 */
	private HashMap<String,Object> objectProperties = new HashMap<String,Object>();
	
	/**
	 * HashMap of return Boolean Properties - mostly a convenience
	 */
	private HashMap<String,Boolean> booleanProperties = new HashMap<String,Boolean>();
	
	/**
	 * Create a Common Status instance
	 */
	public CommonReturn() {
		configure();
	}
	
	/**
	 * Configure - Process any command-line properties
	 */
	private void configure() {
		String traceProperty = System.getProperty("net.verymuchme.commonreturn.consoleTracing");
		if ( (traceProperty != null) && traceProperty.equalsIgnoreCase("true") ) {
			this.consoleTracing = true;
		}
		
	}
	
	/**
	 * Get return status
	 * 
	 * @return  - true success, false otherwise
	 */
	public boolean getStatus() {
		if (this.returnStatus == null) {
			return false;
		}
		else {
			return this.returnStatus.booleanValue();
		}
	}
	
	/**
	 * Does this return represent a successful call?
	 * 
	 * @return true success, false otherwise
	 */
	public boolean success() {
		return this.getStatus();
	}
	
	/**
	 * Does this return represent a failed call? - Opposite of success().
	 * 
	 * @return true failure, false otherwise
	 */
	public boolean failure() {
		return (! success() );
		
	}
	
	/**
	 * Set the status as a boolean value
	 * 
	 * @param newStatus status as a boolean value 
	 */
	public void setStatus(boolean newStatus) {
		if (newStatus) {
			this.returnStatus = Boolean.TRUE;
		}
		else {
			this.returnStatus = Boolean.FALSE;
		}
	}
	
	/**
	 * Set the status as a Boolean object
	 * 
	 * @param newStatus status as a Boolean object 
	 */
	public void setStatus(Boolean newStatus) {
		this.returnStatus = newStatus;
	}

	/**
	 * Get the returned exception
	 * 
	 * @return Exception instance
	 */
	public Exception getException() {
		return this.returnException;
	}
	
	/**
	 * Set the returned exception 
	 * 
	 * @param newException Returned exception
	 */
	public void setException(Exception newException) {
		this.returnException = newException;
	}
	
	/**
	 * Set a returned property value as a string
	 * 
	 * @param propertyName Property name
	 * @param propertyValue Property value as a String.
	 */
	public void setProperty(String propertyName, String propertyValue) {
		this.stringProperties.put(propertyName, propertyValue);
	}
	
	/**
	 * Get a returned property string value
	 * 
	 * @param propertyName Property value as a String.
	 * 
	 * @return Property value as String, null if not present.
	 */
	public String getProperty(String propertyName) {
		return this.stringProperties.get(propertyName);
	}
	
	/**
	 * Set a returned property as an object. Sender must document object type.
	 * 
	 * @param propertyName Property Name
	 * @param propertyValue Property Value as an Object
	 */
	public void setOjectProperty(String propertyName, Object propertyValue) {
		this.objectProperties.put(propertyName,propertyValue);
	}
	
	/**
	 * Get a returned property as an object. Sender must documented object type
	 * 
	 * @param propertyName Property name
	 * 
	 * @return Property value as an object
	 */
	public Object getObjectProperty(String propertyName) {
		return this.objectProperties.get(propertyName);
	}
	
	/**
	 * Set a returned property as a Boolean object.
	 *  
	 * @param propertyName Property name
	 * @param booleanValue Boolean value for property
	 */
	public void setBooleanProperty(String propertyName, Boolean booleanValue) {
		this.booleanProperties.put(propertyName, booleanValue);
	}
	/**
	 * Get a returned property as a Boolean object
	 * 
	 * @param propertyName Property name
	 * @return Boolean value or null if not present
	 */
	public Boolean getBooleanProperty(String propertyName) {
		return this.booleanProperties.get(propertyName);
	}
}
