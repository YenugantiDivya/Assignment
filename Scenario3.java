import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Scenario3 {
	static Properties properties;

	public static void main(String[] args) {

		final String propertyFilePath = "configs//Configuration.properties";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	LoginDetails loginInfo =new LoginDetails();
	loginInfo.Login();
	driver.findElement(
			By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[1]"))
			.click();
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div/button[1]/span")).click();
}
