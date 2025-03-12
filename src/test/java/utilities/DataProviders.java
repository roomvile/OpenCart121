package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{ 

	   /* @DataProvider(name = "LoginData")
	    public static Object[][] getLoginData() throws IOException {
	        String filePath = "C:\\TestData\\LoginData.xlsx"; // Change this path
	        String sheetName = "Sheet1";

	        ExcelUtility.loadExcel(filePath, sheetName);

	        int rowCount = ExcelUtility.getRowCount();
	        Object[][] data = new Object[rowCount][3]; // 3 columns: email, password, expected result

	        for (int i = 1; i <= rowCount; i++) { // Start from row 1 (skip header)
	            data[i - 1][0] = ExcelUtility.getCellData(i, 0); // Email
	            data[i - 1][1] = ExcelUtility.getCellData(i, 1); // Password
	            data[i - 1][2] = ExcelUtility.getCellData(i, 2); // Expected result
	        }

	        ExcelUtility.closeExcel();
	        return data;
	   */ 

}
