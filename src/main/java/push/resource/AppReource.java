package push.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import push.dao.AppDao;
import push.model.App;

@RestController
@RequestMapping(value = "/apps")
public class AppReource {

	@Inject
	private AppDao dao;

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<App> list() {
		return dao.list();
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void create(@RequestParam String metadata, @RequestPart("file") MultipartFile certificateFile)
			throws IllegalStateException, IOException {

		File cert = new File("/Users/kenwang/tmp/" + certificateFile.getOriginalFilename());
		certificateFile.transferTo(cert);

	}

//	@ResponseStatus(value = HttpStatus.OK)
//	@ResponseBody
//	@RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
//	public void create(@RequestParam("metadata") App app, @RequestPart("file") MultipartFile certificateFile)
//			throws IllegalStateException, IOException {
//
//		File cert = new File("/Users/kenwang/tmp/" + certificateFile.getOriginalFilename());
//		certificateFile.transferTo(cert);
//
//	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public App get(@PathVariable Integer id) {
		return dao.get(id);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@RequestBody App app,
			@RequestParam(value = "file", required = false) MultipartFile certificateFile) {
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
	}

}
