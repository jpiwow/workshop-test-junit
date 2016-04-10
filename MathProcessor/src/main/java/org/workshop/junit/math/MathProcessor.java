package org.workshop.junit.math;

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
		return dividend.divide(divisor);
	}
	
	public BigDecimal multiply(BigDecimal multiplicand, BigDecimal multiplier) {
		return multiplicand.multiply(multiplier);
	}
}
