package com.bdd.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.bdd.pages.CompaniesPage;
import com.bdd.pages.DealsPage;
import com.bdd.pages.LoginPage;
import com.bdd.pages.TasksPage;
import com.google.common.base.Splitter;



public class BaseClass extends OR{

	public static WebDriver driver;
	public static Actions act;
	public static FileInputStream fs;
	public static FileOutputStream os;
	public static Row row;
	public static Workbook wb;
	public static Sheet sh;
	public static Cell cell;

	public static Map<String, String> testDataMap = new HashMap<String, String>();

	public static boolean testExecutionStatus = false;

	public static Properties prop;
	public static String DataFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\FreeCrmBdd.xlsx";
	public static List<String> masterSheetList = new ArrayList<String>();
	
	public static void initialize(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ui.freecrm.com/");
	}
	
	public BaseClass() {
		try {
			fs=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/FreeCrm.property");
			prop=new Properties();
			prop.load(fs);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*public static void screenShot(String fileName) throws MyOwnException, InterruptedException {
		Thread.sleep(1000);
		if (prop.getProperty("PositiveScreenshot").equalsIgnoreCase("True")) {
			File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(fileName));
			} catch (IOException exp) {

				throwException("UNABLE TO TAKE THE SCREEN SHOT OF THE SCREEN FROM THE METHOD screenShot.\n"
						+ exp.getMessage() + "\n");
			}
		}

	}*/


	public void readTestDataFromExcel(String testCaseName) {

		try {
			
			readSpecificTestData("Sheet1",testCaseName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void readSpecificTestData(String sheetName, String testCaseName)
			throws IOException {
		try {
			fs = new FileInputStream(DataFilePath);
			wb = new XSSFWorkbook(fs);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		sh=wb.getSheet(sheetName);
		
		StringBuffer testDataBeforeSplit = new StringBuffer();

		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();

		main: for (int i = 1; i <= rowCount; i++) {

			row = sh.getRow(i);
			System.out.println(row.getCell(1).toString());
			if (row.getCell(0).toString().equalsIgnoreCase(testCaseName) && row.getCell(1).toString().equalsIgnoreCase("Yes")) {

				testExecutionStatus = true;
				//System.out.println(row.getPhysicalNumberOfCells());
				for (int j = 2; j < row.getPhysicalNumberOfCells(); j++) {
					if (j + 1 == row.getPhysicalNumberOfCells()) {
						System.out.println(row.getCell(j).toString());
						testDataBeforeSplit.append(row.getCell(j).toString());

					} else {
						System.out.println(row.getCell(j).toString());
						testDataBeforeSplit.append(row.getCell(j).toString() + "\n");
					}

				}

				testDataMap = splitToMap(testDataBeforeSplit.toString());

				break main;
			}
		}
		
	}
	
	public void writeTestDataFromExcel(String testDataType) {

		try {
			
			writeSpecificTestData("TestData1", testDataType,"Test1","Hello");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void writeSpecificTestData(String sheetName, String testCaseName,String writeColName,String value)
			throws IOException{
//		StringBuffer testDataBeforeSplit = new StringBuffer();
		try {
			fs = new FileInputStream(DataFilePath);
			wb = new XSSFWorkbook(fs);
			sh=wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		int count=0;
		 for (int i = 1; i <= rowCount; i++) {

			Row row = sh.getRow(i);
			
			if (row.getCell(0).toString().equalsIgnoreCase(testCaseName)) {
			    count=i;
				break ;
			}

			System.out.println("Your excel file has been generated!");
		}
		 System.out.println(count);
		 row=sh.getRow(count);
		 int col_num=row.getPhysicalNumberOfCells();
			System.out.println(col_num);
			//col_num=col_num;
			//System.out.println(col_num);
		
		os = new FileOutputStream(DataFilePath);
		cell=row.getCell(col_num);
		if (cell == null) {
			cell = (XSSFCell) row.createCell(col_num);
			cell.setCellValue(writeColName+"~"+value);
		}
	   wb.write(os);
	   os.close();

	}
	
	public static Map<String, String> splitToMap(String data)  {

		try {
			testDataMap = Splitter.on("\n").withKeyValueSeparator("~").split(data);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return testDataMap;
	}
	
	@SuppressWarnings("resource")
	public static void AppendApproveTagToFeature(String filename) {

		try {

			File folder = new File(filename);
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
				boolean fileFound = false;
				if (file.isFile()) {
					FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
					String result = "";
					String line = "";

					main: for (int i = 0; i < masterSheetList.size(); i++) {
						if (file.getName().equals(masterSheetList.get(i))) {
							fileFound = true;

							// start of 11262018
							line = br.readLine();

							if (line.contains("Ignore")) {
								line = br.readLine();

								result = result + "\n" + line;
								while ((line = br.readLine()) != null) {
									result = result + "\n" + line;
								}
								result = "@Approved" + result;
								FileOutputStream fos = new FileOutputStream(file);
								fos.write(result.getBytes());
								fos.flush();

							} else if (!(line).contains("Approved")) {
								result = result + "\n" + line;
								while ((line = br.readLine()) != null) {
									result = result + "\n" + line;
								}
								result = "@Approved" + result;
								FileOutputStream fos = new FileOutputStream(file);
								fos.write(result.getBytes());
								fos.flush();

							}

							break main;
						}

					}
					if (!fileFound) {
						line = br.readLine();
						if (line.contains("Approved")) {
							line = br.readLine();
							result = result + "\n" + line;
							while ((line = br.readLine()) != null) {
								result = result + "\n" + line;
							}
							result = "@Ignore" + result;
							FileOutputStream fos = new FileOutputStream(file);
							fos.write(result.getBytes());
							fos.flush();

						} else if (!(line).contains("Ignore")) {
							result = result + "\n" + line;
							while ((line = br.readLine()) != null) {
								result = result + "\n" + line;
							}
							result = "@Ignore" + result;
							FileOutputStream fos = new FileOutputStream(file);
							fos.write(result.getBytes());
							fos.flush();
						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readMasterData() {
			try {
				fs = new FileInputStream(DataFilePath);
				wb = new XSSFWorkbook(fs);
			sh = wb.getSheet("MasterSheet"); //ExcelReading(fileName,"MasterSheet");
			int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			for (int i = 1; i <= rowCount; i++) {
				Row row = sh.getRow(i);

				if (row.getCell(1).toString().equalsIgnoreCase("Yes")) {
					masterSheetList.add(row.getCell(0).toString() + ".feature");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDropDownLooklike(WebElement ele,String value) {
		try {
			WebElement box=ele;
			List<WebElement> ListItems=box.findElements(By.tagName("div"));
			for(WebElement x:ListItems) {
				if(x.getText().equals(value)) {
					x.click();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
