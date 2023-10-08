# simple-rest-assured-with-serenity-bdd
This is simple basecode for Java rest assured combine with Serenity BDD

## Get the code
```bash
git clone https://github.com/FirmanAdiL0707/simple-rest-assured-with-serenity-bdd.git
```

## Command Line - Maven

```bash
mvn clean test
```

## Getting started

### Step by step guide for the setup of Rest Assured.io
Step 1) Install Java

Step 2) Download an IDE to begin: eclipse or Visual Studio Code

Step 3) InstallMaven and set up your IDE.

Step 4) Open your POM.xml

Please make sure you added the following artifact dependencies in pom.xml


```
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-rest-assured</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>${serenity.cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${rest.assured.version}</version>
            <scope>compile</scope>
        </dependency>
```

## Serenity HTML Report
When you use a CucumberWithSerenity runner - after the execution of each feature, an HTML report is output to the target/site/serenity folder and the full path will be printed to the console.
```
html report: (paste into browser to view)
-----------------------------------------
file:///projects/myproject/target/site/serenity/serenity-summary.html
file:///projects/myproject/target/site/serenity/index.html
```

## Usage

To use Rest-assured, Serenity provides class SerenityRest:

```bash
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
```
and assertion capabilities by hamcrest matchers.
```bash
import static org.hamcrest.Matchers.*;
```
### First simple Rest Assured script

The syntax of Rest Assured.io is the most beautiful part, as it is very BDD like and understandable.

```bash
Given(). 
        param("x", "y"). 
        header("z", "w").
when().
Method().
Then(). 
        statusCode(XXX).
        body("x, ”y", equalTo("z"));
```
### A simple GET scenario
```bash
  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API should return "Serenity REST Starter project up and running"
```

The glue code for this scenario illustrates the layered approach we find works well for both web and non-web acceptance tests. The glue code is responsible for orchestrating calls to a layer of more business-focused classes, which perform the actual REST calls.

```bash
    @Steps
    ApplicationStatus theApplication;

    @Given("the application is running")
    public void the_application_is_running() {
        assertThat(theApplication.currentStatus()).isEqualTo(RUNNING);
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        theApplication.readStatusMessage();
    }
```

In steps that perform assertions, we can also use the SerenityRest.restAssuredThat() helper method, which lets us make a RestAssured assertion on the last response the server sent us:

```bash
    @Then("the API should return {string}")
    public void the_API_should_return(String expectedMessage) {
        restAssuredThat(lastResponse -> lastResponse.body(equalTo(expectedMessage)));
    }
```

Please read more here [Serenity and Cucumber!](https://johnfergusonsmart.com/getting-started-with-rest-api-testing-with-serenity-and-cucumber/)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
