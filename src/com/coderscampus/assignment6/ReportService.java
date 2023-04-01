package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReportService {
	
	
	public void yearlySalesReport(List<Sales> carSales, String carModel) {
		System.out.println(carModel + " Yearly Sales Report\n----------------------");
		Map<Integer, List<Sales>> modelByYear = carSales.stream()
														.collect(Collectors.groupingBy
																(date -> date.getDate().getYear()));
		
		String yearlySalesTotal = modelByYear.entrySet().stream()
														.map(x -> x.getKey() + " -> " + x.getValue()
														.stream()
														.collect(Collectors.summingInt(Sales::getSales)))														
														.collect(Collectors.joining("\n")); 
		
		System.out.println(yearlySalesTotal + "\n");
	
	
	
		Optional<YearMonth> maxDate = carSales.stream().max(Comparator
											  .comparingInt(Sales::getSales))
											  .map(Sales::getDate);
		if (maxDate.isPresent()) {
			System.out.println("The best month for " + carModel + " was: " + maxDate.get() + "\n");

		}
		
	

		Optional<YearMonth> minDate = carSales.stream().min(Comparator
											  .comparingInt(Sales::getSales))
						 					  .map(Sales::getDate);
		if (minDate.isPresent()) {
			System.out.println("The worst month for " + carModel +" was: " + minDate.get() + "\n");
		}
		
	}
}
