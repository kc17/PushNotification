package push.resource;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import push.dao.AppClientDao;
import push.model.AppClient;

@RestController
@RequestMapping(value = "/apps/{appId}/clients")
public class AppClientResource {

	@Inject
	private AppClientDao dao;
	
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<AppClient> list(@PathVariable Long appId) {
		return dao.listByAppId(appId);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public AppClient get(@PathVariable Long id) {
		return dao.get(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody AppClient client) {
	}
	
}
