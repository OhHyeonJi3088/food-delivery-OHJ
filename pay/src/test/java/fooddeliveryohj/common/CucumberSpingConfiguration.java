package fooddeliveryohj.common;


import fooddeliveryohj.PayApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PayApplication.class })
public class CucumberSpingConfiguration {
    
}
