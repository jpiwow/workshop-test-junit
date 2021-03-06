package com.pgs.workshop.junit.math;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;
import static com.pgs.workshop.junit.utils.MyBigDecimalMatcher.myEqualsTo;
import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pgs.workshop.junit.math.MathProcessor;

/**
 * Unit test for MathProcessor.
 */
public class MathProcessorTest 
{
	MathProcessor mathProcessor;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		mathProcessor = new MathProcessor();
	}
	
	@Test
    public void shouldAdd() {
    	//given
    	BigDecimal augend = new BigDecimal("5.30");
    	BigDecimal addend = new BigDecimal("1.2");
    	BigDecimal expectedResult = new BigDecimal("6.5");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.add(augend, addend);
    	
    	//then
    	assertThat(actualResult, myEqualsTo(expectedResult));
    	
    }
	
    @Test
    public void shouldSubtract() {
    	//given
    	BigDecimal minuend = new BigDecimal("5.30");
    	BigDecimal subtrahend = new BigDecimal("1.2");
    	BigDecimal expectedResult = new BigDecimal("4.1");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.subtract(minuend, subtrahend);
    	
    	//then
    	assertThat(actualResult, myEqualsTo(expectedResult));
    	
    }
    
    @Test
    public void shouldMultiply() {
    	//given
    	BigDecimal multiplicand = new BigDecimal("2.1");
    	BigDecimal multiplier = new BigDecimal("3.0");
    	BigDecimal expectedResult = new BigDecimal("6.3");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.multiply(multiplicand, multiplier);
    	
    	//then
    	assertThat(actualResult, myEqualsTo(expectedResult));
    	
    }
    
    @Test
    public void shouldDivide() {
    	//given
    	BigDecimal dividend = new BigDecimal("8.0");
    	BigDecimal divisor = new BigDecimal("2.0");
    	BigDecimal expectedResult = new BigDecimal("4.0");
    	
    	//when
    	BigDecimal actualResult = mathProcessor.divide(dividend, divisor);
    	
    	//then
    	assertThat(actualResult, myEqualsTo(expectedResult));
    	
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDividingByZero() {
    	//given
    	BigDecimal dividend = new BigDecimal("8.0");
    	BigDecimal divisor = new BigDecimal("0.0");
    	
    	//when
    	mathProcessor.divide(dividend, divisor);
    	
    	//then
    	fail("Exception should have been thrown");
    }
    
    @Test
    public void shouldThrowExceptionWhenDividingByZeroWithRule() {
    	//given
    	BigDecimal dividend = new BigDecimal("8.0");
    	BigDecimal divisor = new BigDecimal("0.0");
    	
    	//when
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("You can not divide by zero!");
    	mathProcessor.divide(dividend, divisor);
    	
    	//then
    	fail("Exception should have been thrown");
    }
    
    @Test
    public void shouldThrowExceptionWhenDividingByZeroWithTryCatchIdiom() {
    	//given
    	BigDecimal dividend = new BigDecimal("8.0");
    	BigDecimal divisor = new BigDecimal("0.0");
    	
    	//when
    	try {
    		mathProcessor.divide(dividend, divisor);
    		fail("Exception should have been thrown");
    	} catch (Exception e) {
    		assertThat(e)
    			.isInstanceOf(IllegalArgumentException.class)
    			.hasMessage("You can not divide by zero!");
    	}

    }
}
