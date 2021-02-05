package cn.side4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(maxAge = 3600)
//@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class Exercise7Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise7Application.class, args);
	}
	
	@GetMapping("test1")
	public String test1() {
		return "test1";
	}
	
	@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
	@GetMapping("test2")
	public String test2() {
		return "test2";
	}

}
