package push.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
import push.utils.ObjectMapperUtil;

@RestController
@RequestMapping(value = "/apps")
public class AppReource {

	@Value("${apns.certificate.location}")
	private String path;

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
	public void create(@RequestParam("metadata") String metadata,
			@RequestPart(name = "file", required = false) MultipartFile certificateFile)
			throws IllegalStateException, IOException {

		App app = ObjectMapperUtil.toObject(metadata, App.class);
		dao.save(app);

		if (certificateFile != null) {

			String originalFilename = certificateFile.getOriginalFilename();
			String filename = app.getId() + originalFilename.substring(originalFilename.indexOf("."));

			File cert = new File(path + filename);
			certificateFile.transferTo(cert);
			app.setApnsCertificateFileLocation(cert.getName());

			dao.update(app);
		}

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
	public App get(@PathVariable Long id) {
		return dao.get(id);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = { "multipart/form-data" })
	public void update(@RequestParam(name = "metadata") String metadata,
			@RequestParam(value = "file", required = false) MultipartFile certificateFile) {
	}

	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
	}

}
