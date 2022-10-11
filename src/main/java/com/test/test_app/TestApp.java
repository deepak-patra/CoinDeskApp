package com.test.test_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.test.test_app.constants.TestAppConstant;
import com.test.test_app.service.UserRequestProcesser;
/**
 * The Class MachineLearningOps.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan("com.test.test_app")
public class TestApp implements CommandLineRunner{
	@Autowired
	private UserRequestProcesser userRequestProcesser;
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 */
	public static void main(final String[] args) {
		SpringApplication.run(TestApp.class, args);
		
	}
	
	@Override
    public void run(String... args) throws IOException {
		while (true) {
			System.out.print("Welcome to coindesk console: ");
			System.out.print("Please type exit to exit the application. ");
			System.out.print("Input a currency code: ");
			BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 
		        // Reading data using readLine
		        String currencyInput = reader.readLine();
			//String currencyInput = System.console().readLine();
			System.out.print("You entered: " + currencyInput);
			if (null == currencyInput || TestAppConstant.EXIT.equals(currencyInput)) {
				return;
			}
			userRequestProcesser.processRequest(currencyInput);
		}
    }

}
