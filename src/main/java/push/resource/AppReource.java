package push.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import push.dao.AppDao;
import push.model.App;

@RestController
@RequestMapping(value = "/apps")
public class AppReource {

	@Autowired
	private AppDao dao;

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<App> list() {
		return dao.list();
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public void create(App app, @RequestParam(value = "file") MultipartFile certificateFile) {
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public App get(Integer id) {
		return dao.get(id);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(App app, @RequestParam(value = "file") MultipartFile certificateFile) {
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(Integer id) {
	}

}
