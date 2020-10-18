package StepDefinitions;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.employee.demo.EmployeeSillsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EmployeeSillsApplication.class,
				webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class SpringIntegrationTest {

	protected RestTemplate restTemplate=new RestTemplate();
	
	protected final String PORT_URL="http://localhost:8090/";
}
