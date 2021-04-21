import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {

    private Calculator c;

    @Given("^a calculator I just turned on$")
    public void setup(){
        c = new Calculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void add(int arg1, int arg2){
        c.push(arg1);
        c.push(arg2);
        c.push("+");
    }

    @When("^I subtract (\\d+) to (\\d+)$")
    public void subtract(int arg1, int arg2) {
        c.push(arg1);
        c.push(arg2);
        c.push("-");
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected){
        assertEquals(expected, c.value());
    }
}
