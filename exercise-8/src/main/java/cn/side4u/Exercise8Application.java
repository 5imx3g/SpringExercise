package cn.side4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@SpringBootApplication
@RestController
public class Exercise8Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise8Application.class, args);
	}
	
	@ApiOperation(value="get 方法", notes="测试 Get 方法的 Swagger 文档")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, paramType = "header", dataType = "String", defaultValue = ""),
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "param", value = "参数", required = true, paramType = "query", dataType = "Long")
    })
	@GetMapping("getApi/{id}")
	public Rep getApi(
			@PathVariable("id") String id, 
			/*@RequestParam(value = "name", defaultValue = "0") 可省略*/ String param) {
		return new Rep();
	}
	
	@ApiOperation(value="Post 方法", notes="测试 Post 方法的 Swagger 文档")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "req", value = "查询对象", required = true, paramType = "body", dataType = "Req")
    })
	@PostMapping("postApi")
	public Rep postApi(@RequestBody Req req) {
		return new Rep();
	}
	
	@GetMapping("normalApi")
	public String normalApi(String param) {
		return null;
	}
}
