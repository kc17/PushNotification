package push.executor;

import push.model.AppClient;

public interface PushExecutor {
	
	void init(AppClient client, String content);
	
	void execute();

}
