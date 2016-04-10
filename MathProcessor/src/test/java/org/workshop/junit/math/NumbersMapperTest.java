package org.workshop.junit.math;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Test;

public class NumbersMapperTest {
	
	private NumbersMapper numbersMapper = new NumbersMapper();
	
	@Test
	public void shouldDecorateNumber() {
		//given
		BigDecimal numberToDecorate = new BigDecimal("4.23");
		
		//when
		String result = numbersMapper.decorateNumber(numberToDecorate);
		
		//then
		assertNotNull(result);
		assertThat(result, containsString(NumbersMapper.DECORATION));
	}
	
	@Test
	public void shouldMapToOneOfThreeFirstDecades() {
		//given
		BigDecimal numberToMap = new BigDecimal("15.1");
		
		//when
		String result = numbersMapper.mapNumber(numberToMap);
		
		//then
		assertThat(result, anyOf(is(NumbersMapper.FIRST_DECADE),
				is(NumbersMapper.SECOND_DECADE),
				is(NumbersMapper.THIRD_DECADE)));
		
	}
	
}
