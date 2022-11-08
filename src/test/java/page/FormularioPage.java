package page;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class FormularioPage extends BasePage {
    public FormularioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "banner-accept")
    private WebElement btnBanner;

    @FindBy(name = "firstname")
    private WebElement txtFirstName;

    @FindBy(name = "lastname")
    private WebElement txtLastname;

    @FindBy(name = "photo")
    private WebElement btnImagen;


    public void ingresarDatosFormulario(DataTable dataTable) {
        wait.until(ExpectedConditions.elementToBeClickable(btnBanner));
        btnBanner.click();
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            txtFirstName.sendKeys(lista.get(i).get("firstName"));
            txtLastname.sendKeys(lista.get(i).get("lastName"));
            driver.findElement(By.xpath("//input[@value='" + lista.get(i).get("sex") + "']")).click();
            driver.findElement(By.xpath("//span[text()='" + lista.get(i).get("yearsExperience") + "']")).click();
            driver.findElement(By.xpath("//input[@value='" + lista.get(i).get("profession") + "']")).click();
        }
    }

    public void cargarImagen() throws InterruptedException {
        btnImagen.sendKeys("C:\\Users\\York\\Desktop\\SeleniumOctubre\\Selenium\\src\\test\\resources\\data\\cucumber.png");
        Thread.sleep(5000);
    }

    public void seleccionarTipoSelenium(String tipoSelenium){

    }
}
