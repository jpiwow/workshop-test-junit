package org.workshop.junit.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
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
	
	@Parameters
	@Test
	public void shouldMapToDecades(BigDecimal numberToMap, String expectedDecade) {
	    //given
	    
	    
	    //when
	    String result = numbersMapper.mapNumber(numberToMap);
	    
	    //then
	    assertEquals(expectedDecade, result);
	    
	}
	
	public Object[] parametersForShouldMapToDecades() {
	    return new Object[] {
	      new Object[] {new BigDecimal("5.0"), NumbersMapper.FIRST_DECADE},
	      new Object[] {new BigDecimal("15.0"), NumbersMapper.SECOND_DECADE},
	      new Object[] {new BigDecimal("25.0"), NumbersMapper.THIRD_DECADE},
	      new Object[] {new BigDecimal("35.0"), NumbersMapper.OUT_OF_SCOPE}
	    };
	}
	
	
}
