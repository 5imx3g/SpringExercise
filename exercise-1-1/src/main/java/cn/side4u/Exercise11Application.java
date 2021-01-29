package cn.side4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise11Application {

	public static void main(String[] args) {
		Excercise exe = new Excercise();
		exe.sayHi();
		SpringApplication.run(Exercise11Application.class, args);
//		Exerci
	}

}
