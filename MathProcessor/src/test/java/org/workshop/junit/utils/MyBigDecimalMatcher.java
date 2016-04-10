package org.workshop.junit.utils;

import java.math.BigDecimal;

import org.hamcrest.Description;
import org.junit.matchers.TypeSafeMatcher;

public class MyBigDecimalMatcher extends TypeSafeMatcher<BigDecimal> {

	BigDecimal expected;
	
	private MyBigDecimalMatcher(BigDecimal expected) {
		this.expected = expected;
	}
	
	public void describeTo(Description description) {
		description.appendValue(expected);
	}

	@Override
	public boolean matchesSafely(BigDecimal actual) {
		return expected.compareTo(actual) == 0;
	}
	
	public static MyBigDecimalMatcher myEqualsTo(BigDecimal expected) {
		return new MyBigDecimalMatcher(expected);
	}

}
