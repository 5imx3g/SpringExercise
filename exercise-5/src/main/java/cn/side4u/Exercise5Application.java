package cn.side4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercise5Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise5Application.class, args);
	}
	
	/**
	 * 未使用注解
	 * @param val
	 */
	@PostMapping("submitVal")
	public void submitVal(String val) {
		System.out.println(val);
	}
	
	/**
	 * 使用注解
	 * @param val
	 */
	@PostMapping("submitVal2")
	public void submitVal2(@JsonArg(path="$.val") String val) {
		System.out.println(val);
	}
	
	@PostMapping("submitVal3")
	public void submitVal3(@RequestParam String val) {
		System.out.println(val);
	}
}
