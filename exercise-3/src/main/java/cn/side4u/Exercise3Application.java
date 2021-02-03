package cn.side4u;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercise3Application {
	@Autowired
	TestConf testConf;

	public static void main(String[] args) {
		// 程序中传递解密秘钥
		ArrayList<String> al = new ArrayList<String>();
		for (String string : args) {
			al.add(string);
		}
		al.add("--jasypt.encryptor.password=1qaz");
		String[] a = al.toArray(new String[al.size()]);
		SpringApplication.run(Exercise3Application.class, a);
//		SpringApplication.run(Exercise3Application.class, args);
	}
	@GetMapping("doTest")
	public TestConf doTest() {
		return testConf;
	}

}
