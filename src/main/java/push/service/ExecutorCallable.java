package push.service;

import java.util.concurrent.Callable;

import push.service.executor.PushExecutor;

public class ExecutorCallable implements Callable<String> {

	private PushExecutor executor;

	public ExecutorCallable(PushExecutor executor) {
		this.executor = executor;
	}

	@Override
	public String call() throws Exception {
		executor.execute(); // TODO need response of result
		return null;
	}

}
