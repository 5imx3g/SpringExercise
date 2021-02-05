package cn.side4u;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercise6Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise6Application.class, args);
	}
	
	@GetMapping("getDateObj")
	public DateObj getDateObj() {
		return new DateObj();
	}
	
	@PostMapping("/local-date-time")
    public void dateTime(@RequestParam("localDateTime") 
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        // ...
    }

}
