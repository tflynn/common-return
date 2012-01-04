package net.verymuchme.commonreturn;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import junit.framework.TestCase;
import junit.framework.Assert;


public class CommonReturnTest extends TestCase {

	public CommonReturnTest(String testName ) {
		super(testName);
	}
	
	public void testSingleArgumentConstructor() {
		String commonReturnInitializationValue = "Some odd value";
		CommonReturn<String> returnValue = new CommonReturn<String>(commonReturnInitializationValue);
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"",commonReturnInitializationValue, returnValue.getValue()), commonReturnInitializationValue.equals(returnValue.getValue()));
		Assert.assertTrue(String.format("Expected a NULL_THROWABLE"),returnValue.getThrowable().equals(CommonReturn.NULL_THROWABLE));
		Assert.assertTrue(String.format("Expected Status.UNDEFINED"),returnValue.getStatus().equals(Status.UNDEFINED));
		Assert.assertTrue(String.format("Expected a NULL_STRING"),returnValue.getErrorText().equals(CommonReturn.NULL_STRING));
		
	}
	
	public void testTwoArgumentConstructor() {
		String commonReturnInitializationValue = "Another odd value";
		Exception testException = new Exception();
		CommonReturn<String> returnValue = new CommonReturn<String>(commonReturnInitializationValue,testException);
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"",commonReturnInitializationValue, returnValue.getValue()), commonReturnInitializationValue.equals(returnValue.getValue()));
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"", testException.getClass().getName(),returnValue.getThrowable().getClass().getName()),returnValue.getThrowable().equals(testException));
		Assert.assertTrue(String.format("Expected Status.UNDEFINED"),returnValue.getStatus().equals(Status.UNDEFINED));
		Assert.assertTrue(String.format("Expected a NULL_STRING"),returnValue.getErrorText().equals(CommonReturn.NULL_STRING));
	}

	public void testThreeArgumentConstructor() {
		String commonReturnInitializationValue = "Yet another odd value";
		Exception testException = new Exception();
		CommonReturn<String> returnValue = new CommonReturn<String>(commonReturnInitializationValue,testException,Status.FAILURE);
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"",commonReturnInitializationValue, returnValue.getValue()), commonReturnInitializationValue.equals(returnValue.getValue()));
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"", testException.getClass().getName(),returnValue.getThrowable().getClass().getName()),returnValue.getThrowable().equals(testException));
		Assert.assertTrue(String.format("Expected Status.FAILURE"),returnValue.getStatus().equals(Status.FAILURE));
		Assert.assertTrue(String.format("Expected a NULL_STRING"),returnValue.getErrorText().equals(CommonReturn.NULL_STRING));
	}
	
	public void testFourArgumentConstructor() {
		String commonReturnInitializationValue = "Yet another very odd value";
		Exception testException = new Exception();
		String errorString = "An error string"; 
		CommonReturn<String> returnValue = new CommonReturn<String>(commonReturnInitializationValue,testException,Status.SUCCESS,errorString);
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"",commonReturnInitializationValue, returnValue.getValue()), commonReturnInitializationValue.equals(returnValue.getValue()));
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"", testException.getClass().getName(),returnValue.getThrowable().getClass().getName()),returnValue.getThrowable().equals(testException));
		Assert.assertTrue(String.format("Expected Status..SUCCESS"),returnValue.getStatus().equals(Status.SUCCESS));
		Assert.assertTrue(String.format("Expected \"%s\" actual \"%s\"",errorString,returnValue.getErrorText()),returnValue.getErrorText().equals(errorString));
		
	}
	
}


