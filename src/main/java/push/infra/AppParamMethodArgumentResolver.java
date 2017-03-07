package push.infra;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

import push.dao.AppDao;
import push.model.App;

public class AppParamMethodArgumentResolver extends PathVariableMapMethodArgumentResolver {

	@Inject
	private AppDao dao;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(AppParam.class) != null
				&& parameter.getParameterType().equals(App.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		if (this.supportsParameter(parameter)) {
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) super.resolveArgument(parameter, mavContainer, webRequest,
					binderFactory);

			AppParam paaParam = parameter.getParameterAnnotation(AppParam.class);
			String key = paaParam.name();

			Long id = Long.parseLong(map.get(key));
			return dao.get(id);
		}
		return WebArgumentResolver.UNRESOLVED;
	}

}
