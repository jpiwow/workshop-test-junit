package org.workshop.junit.math;

import java.math.BigDecimal;

public class NumbersMapper {
	
	public static final String DECORATION = "Provided number is: ";
	public static final String FIRST_DECADE = "FirstDecade";
	public static final String SECOND_DECADE = "SecondDecade";
	public static final String THIRD_DECADE = "ThirdDecade";
	public static final String OUT_OF_SCOPE = "OutOfScope";
	
	private static final BigDecimal TWENTY = new BigDecimal("20.0");
	private static final BigDecimal THIRTY = new BigDecimal("30.0");
	
	public String decorateNumber(BigDecimal number) {
		StringBuilder sb = new StringBuilder();
		return sb.append(DECORATION).append(number.toString()).toString();
	}
	
	public String mapNumber(BigDecimal number) {
		String mappedNumber = OUT_OF_SCOPE;
		
		if(number.compareTo(BigDecimal.ZERO) >= 0 &&
				number.compareTo(BigDecimal.TEN) <= 0) {
			mappedNumber = FIRST_DECADE;
		} else if(number.compareTo(BigDecimal.TEN) > 0 &&
				number.compareTo(TWENTY) <= 0) {
			mappedNumber = SECOND_DECADE;
		} else if (number.compareTo(TWENTY) > 0 &&
				number.compareTo(THIRTY) <= 0) {
			mappedNumber = THIRD_DECADE;
		}
		
		return mappedNumber;
	}
	
}
