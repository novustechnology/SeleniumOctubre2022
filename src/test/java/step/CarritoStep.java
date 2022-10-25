package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DatosPagoPage;
import page.DatosTarjetaPage;
import page.HomePage;
import page.MenuPage;

public class CarritoStep {

    MenuPage menuPage;

    DatosTarjetaPage datosTarjetaPage;

    HomePage homePage;

    DatosPagoPage datosPagoPage;

    public CarritoStep() {
        menuPage = new MenuPage(Hooks.driver);
        datosTarjetaPage = new DatosTarjetaPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        datosPagoPage= new DatosPagoPage(Hooks.driver);
    }


    @Given("la pagina de comprar esta disponible")
    public void laPaginaDeComprarEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
        menuPage.clickGenerarTarjeta();
    }

    @And("capturo los datos de la tarjeta")
    public void capturoLosDatosDeLaTarjeta() {
        datosTarjetaPage.cambiarVentana();
        datosTarjetaPage.capturarTarjeta();
        datosTarjetaPage.capturarCvv();
        datosTarjetaPage.capturarFechaExp();
        datosTarjetaPage.cerrarVentana();
    }

    @And("selecciono una cantidad de productos al carrito y le doy comprar")
    public void seleccionoUnaCantidadDeProductosAlCarritoYLeDoyComprar() {
        homePage.seleccionarCant();
        homePage.clickComprar();
    }

    @Then("ingreso los datos de la tarjeta")
    public void ingresoLosDatosDeLaTarjeta() {
        datosPagoPage.ingresarDatos();
    }
}
