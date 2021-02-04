package cn.side4u;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jayway.jsonpath.JsonPath;

public class JsonPathArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(JsonArg.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String body = this.getRequestBody(webRequest);
		        if (StringUtils.isNotBlank(body)) {
		            Annotation[] p2 = parameter.getParameterAnnotations();
		            Optional<Annotation> a= Stream.of(p2).filter(it -> it instanceof JsonArg).findFirst();
		            if (a.isPresent()) {
		            	return JsonPath.read(body, ((JsonArg) a.get()).path());
		            }
		        }
		        return null;
	}
	
    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) webRequest.getAttribute("params", NativeWebRequest.SCOPE_REQUEST);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getInputStream());
                webRequest.setAttribute("params", jsonBody, NativeWebRequest.SCOPE_REQUEST);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return jsonBody;
    }

}
