package org.workshop.junit.math;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.workshop.junit.math.MathProcessor;

/**
 * Unit test for MathProcessor.
 */
public class MathProcessorTest 
{
    @Test
    public void shouldSubtract() {
    	//given
    	MathProcessor mathProcessor = new MathProcessor();
    	BigDecimal minuend = new BigDecimal("5.3");
    	BigDecimal subtrahend = new BigDecimal("1.2");
    	BigDecimal expectedResult = new BigDecimal("4.1");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.subtract(minuend, subtrahend);
    	
    	//then
    	assertEquals(expectedResult, actualResult);
    	
    }
}
