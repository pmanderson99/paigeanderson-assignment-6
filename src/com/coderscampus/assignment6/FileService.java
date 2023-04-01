package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileService {

	public List<Sales> loadSalesReport(String fileName) throws IOException {

		List<Sales> salesReportList = new ArrayList<>();
		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
			String line = null;
			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {
				String[] values = line.split(",");
				Sales sales = new Sales(values[0], values[1]);
				salesReportList.add(sales);
			}
			
			fileReader.close();
			return salesReportList;
			
		}

	}
}
