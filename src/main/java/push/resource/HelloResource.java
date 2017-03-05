package push.resource;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "Hello";
	}

}
