package EnviarEmailCodigo;

import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnviarEmailCodigo {
	 WebDriver driver;

	@Given("^O usuário esteja logado em sua conta de e-mail no site \"([^\"]*)\"$")
	public void o_usuário_esteja_logado_em_sua_conta_de_e_mail_no_site(String Site) {
		   //Necessário para utilizar o FireFox
		   System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");			
		   driver = new FirefoxDriver();
		   //Acessando o site Bol.com.br
		   driver.get(Site);
		   
		   //Digitando Usuário
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("user")));
		   driver.findElement(By.name("user")).sendKeys("mviniciusfantinato");
		   
		   //Digitando Senha
		   driver.findElement(By.name("pass")).sendKeys("tEsteuol123");
		   //Clicando no Botão Entrar
		   driver.findElement(By.className("mod-header-login-button")).click();
	}
	
	@When("^O usuário clica em \"([^\"]*)\"$")
	public void o_usuário_clica_em(String arg1) {
		   //Aguardando o Botão Aparecer na tela
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/div/section[1]/div/div[1]/div[3]/menu[1]")));
		   //Clicando no Botão "Escrever" utilizando o Xpath do botão
		   driver.findElement(By.xpath("/html/body/div[3]/div/section[1]/div/div[1]/div[3]/menu[1]")).click();
	}

	@When("^Preenche o endereço com : \"([^\"]*)\"$")
	public void preenche_o_endereço_com(String end)  {
		//Digistando o Endereço do e-mail
		driver.findElement(By.id("fake_input__field-to")).sendKeys(end);
	}

	@When("^Preenche o assunto com : \"([^\"]*)\"$")
	public void preenche_o_assunto_com(String assunto){
		//Digitando o Assunto do e-mail + Data
		GregorianCalendar calendar = new GregorianCalendar();
		Date data = calendar.getTime();
		driver.findElement(By.id("field-subject")).sendKeys(assunto + data);
	}

	@When("^Clica em \"([^\"]*)\"$")
	public void clica_em(String arg1){
		//Clicando em Enviar
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/form/div[2]/div[1]/menu[1]")).click();
	}

	@Then("^O e-mail é enviado com sucesso e um Novo E-mail é recebido\\.$")
	public void o_e_mail_é_enviado_com_sucesso_e_um_Novo_E_mail_é_recebido() {
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/div/section[1]/div/div[1]/div[3]/menu[2]/span")));
		   driver.findElement(By.xpath("/html/body/div[3]/div/section[1]/div/div[1]/div[3]/menu[2]/span")).click();
		
		 WebDriverWait wait2 = new WebDriverWait(driver, 40);
		 wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/div/section[2]/div/div[2]/div/div[2]/section[1]/div/div[4]/ul/li/a")));

	     WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/section[2]/div/div[2]/div/div[2]/section[1]/div/div[4]/ul/li/a"));
	    		String texto = element.getText();
	    		System.out.println(texto);	
	}
}
