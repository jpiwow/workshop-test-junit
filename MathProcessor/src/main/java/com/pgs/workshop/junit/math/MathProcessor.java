package com.pgs.workshop.junit.math;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class MathProcessor 
{
	public BigDecimal add(BigDecimal augend, BigDecimal addend) {
		return augend.add(addend);
	}
	
	public BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
		return minuend.subtract(subtrahend);
	}
	
	public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
		if(ZERO.compareTo(divisor) == 0) {
			throw new IllegalArgumentException("You can not divide by zero!");
		}
		return dividend.divide(divisor);
	}
	
	public BigDecimal multiply(BigDecimal multiplicand, BigDecimal multiplier) {
		return multiplicand.multiply(multiplier);
	}
}
