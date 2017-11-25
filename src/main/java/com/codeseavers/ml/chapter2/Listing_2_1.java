package com.codeseavers.ml.chapter2;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class Listing_2_1 {

	public static Double getRevenue(List<Double> prices, List<Integer> amounts) {
		
		Double revenue = 0.0;
		
		if (prices.size() != amounts.size()) {
			throw new IllegalArgumentException("Both vectors must be of equal size!");
		}
		
		for (int i=0; i<prices.size(); i++) {
			revenue += prices.get(i) * amounts.get(i);
		}
		
		return revenue;
	}
	
	public static Double getRevenueLib(List<Double> prices, List<Integer> amounts) {
		
		List<Double> doubleAmounts = amounts.stream().map(Integer::doubleValue).collect(Collectors.toList());
		
		RealVector priceVector = new ArrayRealVector(prices.toArray(new Double[prices.size()]));
		RealVector amountVector = new ArrayRealVector(doubleAmounts.toArray(new Double[doubleAmounts.size()]));
		
		return priceVector.dotProduct(amountVector);
	}

}
