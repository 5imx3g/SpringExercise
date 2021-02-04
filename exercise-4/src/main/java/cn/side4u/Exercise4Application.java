package cn.side4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercise4Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise4Application.class, args);
	}
	
	@GetMapping("test")
	@MethodLogger(level = "INFO", msg = "测试1")
	public String test(String val) {
		return "hello " + val;
	}
	
	@GetMapping("testEx")
	@MethodLogger(msg="异常日志测试")
	public void testEx() throws Exception {
		throw new Exception("异常");
	}
}
