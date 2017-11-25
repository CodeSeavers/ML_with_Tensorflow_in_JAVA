package com.codeseavers.ml.chapter2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class Listing_2_1_Test {

	@Test
	void vectors_of_different_size_are_not_allowed() {
		List<Double> prices = List.of(13.04, 3.50, 14.99);
		List<Integer> amounts = List.of(1, 3, 5, 3);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Listing_2_1.getRevenue(prices, amounts);
		});
		assertEquals("Both vectors must be of equal size!", exception.getMessage());
	}

	@Test
	void calculate_revenue() {
		List<Double> prices = List.of(13.04, 3.50, 14.99, 0.99);
		List<Integer> amounts = List.of(1, 3, 5, 3);
		
		assertEquals(Double.valueOf(101.46), Listing_2_1.getRevenue(prices, amounts), 0.0001);
	}
	
	@Test
	void commons_math_calculate_revenue() {
		List<Double> prices = List.of(13.04, 3.50, 14.99, 0.99);
		List<Integer> amounts = List.of(1, 3, 5, 3);
		
		assertEquals(Double.valueOf(101.46), Listing_2_1.getRevenueLib(prices, amounts), 0.0001);
	}
}
