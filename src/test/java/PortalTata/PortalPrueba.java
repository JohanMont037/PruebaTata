package PortalTata;

import org.junit.Test;

//import static org.junit.Assert.assertEquals;

//import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PortalPrueba {
	private WebDriver driver;
	
	By formularioLocator = By.id("alerta");
	By Namelocator = By.name("name");
	By Phonelocator = By.name("phone");
	By Citylocator = By.name("city");
	By Maillocator = By.name("email");
	By Userlocator = By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input");
	By Passlocator = By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input");
	By Submitlocator = By.cssSelector("#load_form > div:nth-child(12) > div.span_1_of_4 > input");
	By Nombrefinal = By.xpath("//*[@id=\"alert\"]");
	
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/way2auto_jquery/index.php");	
	}
	
	@Test
	
	public void llenarFormulario(String dato) {
			String[] datos = dato.split("-");
			String name = datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3];
			String[] nameList = name.split(" ");
			String celular = datos[4];
			String email = datos[0] + "@" + datos[2] + ".com";
			String username = "";
			
			for (String string : nameList) {
				username += string.substring(0, 2);
			}
		
			driver.findElement(Namelocator).sendKeys(name);
			driver.findElement(Phonelocator).sendKeys(celular);
			driver.findElement(Maillocator).sendKeys(email);
			Select pais = new Select(driver.findElement(By.name("country")));
			pais.selectByValue("Colombia");
			driver.findElement(Citylocator).sendKeys("Bogota");
			driver.findElement(Userlocator).sendKeys(username);
			driver.findElement(Passlocator).sendKeys("Pruebas12");
			driver.findElement(Submitlocator).click();
			
		
	}
	
	@After
	
	public void cerrar() throws InterruptedException {
		
		if(driver.findElement(Nombrefinal).isEnabled()) {
			Thread.sleep(10000);
			driver.quit();
			
		}
		
		
	}
	

}
