package push.service.executor;

import push.model.AppClient;

public abstract class PushExecutor {

	protected String content;
	protected AppClient client;

	public PushExecutor(AppClient client, String content) {
		this.client = client;
		this.content = content;

	}

	public abstract void execute();

}
