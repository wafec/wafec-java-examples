/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package springsecurity.customfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
