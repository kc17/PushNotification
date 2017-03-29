package push.service;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import push.dao.AppClientDao;
import push.model.App;
import push.model.AppClient;
import push.model.Notice;
import push.service.executor.PushExecutor;
import push.service.executor.PushExecutorFactory;
import push.utils.ExecutorServiceUtils;

@Service
public class PushService {
	
	private static final int MAX_THREAD_COUNT = 10;
	
	@Inject
	private AppClientDao clientDao;
	private ExecutorService executorService;

	public PushService() {
		this.executorService = ExecutorServiceUtils.createExecutorService("PushExecutor", MAX_THREAD_COUNT);
	}
	
	public void push(App app, Notice notice) {
		
		List<AppClient> clients = clientDao.list(app.getId(), notice.getTargets());
		
		for(AppClient client : clients) {
			PushExecutor executor = PushExecutorFactory.createPushExecutor(client, notice.getContent()); 
			executorService.submit(new ExecutorCallable(executor));//TODO need handle failure
		}
		
	}

}
