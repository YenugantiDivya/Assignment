import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario2 {

	public static void ScenarioExample(String[] args) {
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


		driver.findElement(
				By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div[4]/div/div/div[2]/div/button"))
				.click();
		driver.findElement(By.linkText("New Event")).click();
	}

}
