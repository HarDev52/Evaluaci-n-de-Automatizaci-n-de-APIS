package com.nttdata.glue;

import com.nttdata.steps.SwaggerOrderStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SwaggerOrderStepDef {
    @Steps
    SwaggerOrderStep orders;


    @Given("la url es {string}")
    public void laUrlEs(String url) {
        orders.definirURL(url);
    }


    @Then("valido que la respuesta sea {int}")
    public void validoQueLaRespuestaSea(int statusCode) {
        orders.Status(statusCode);
    }


    @When("cuando creo la orden {string} de la mascota {string}")
    public void cuandoCreoLaOrdenDeLaMascota(String idOrden, String idMascota) {
        orders.CrearOrder(idOrden,idMascota);
    }

    @When("cuando consulta la orden {string}")
    public void cuandoConsultaLaOrden(String idOrden) {
        orders.ConsultarOrder(idOrden);
    }
}
