package cn.side4u;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("请求对象")
public class Req {
	@ApiModelProperty("主键")
	String id;
	@ApiModelProperty("查询参数")
	String param;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}
