package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;

public class MainApp {

	public static void main(String[] args) throws IOException{
		
		FileService fileService = new FileService();
		ReportService modelReport = new ReportService();

		
		List<Sales> model3 = fileService.loadSalesReport("model3.csv");
		modelReport.yearlySalesReport(model3, "Model 3");
		
		
		List<Sales> modelS = fileService.loadSalesReport("modelS.csv");
		modelReport.yearlySalesReport(modelS, "Model S");
		
		List<Sales> modelX = fileService.loadSalesReport("modelX.csv");
		modelReport.yearlySalesReport(modelX, "Model X");
	}

}
