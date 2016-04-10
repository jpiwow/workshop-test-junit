package org.workshop.junit.math;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import static org.workshop.junit.utils.MyBigDecimalMatcher.myEqualsTo;

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
    	BigDecimal minuend = new BigDecimal("5.30");
    	BigDecimal subtrahend = new BigDecimal("1.2");
    	BigDecimal expectedResult = new BigDecimal("4.1");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.subtract(minuend, subtrahend);
    	
    	//then
    	assertThat(actualResult, myEqualsTo(expectedResult));
    	
    }
}
