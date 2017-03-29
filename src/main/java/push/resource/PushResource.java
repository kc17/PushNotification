package push.resource;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import push.infra.AppParam;
import push.model.App;
import push.model.Notice;
import push.service.PushService;

@RestController
@RequestMapping(value = "/apps/{appId}/push")
public class PushResource {

	@Inject
	private PushService service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public void push(@AppParam(name = "appId") App app, @RequestBody Notice notice) {
		service.push(app, notice);
	}
	
}
