package push.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtils {

	private static final Map<String, ExecutorService> EXECUTOR_SERVICE_MAP = new HashMap<>();

	public synchronized static ExecutorService createExecutorService(final String namePattern, final int maxThreadCount) {
		if (EXECUTOR_SERVICE_MAP.containsKey(namePattern))
			throw new IllegalStateException("The name pattern already exists.");

		ExecutorService es = Executors.newFixedThreadPool(maxThreadCount);
		EXECUTOR_SERVICE_MAP.put(namePattern, es);
		return es;
	}

	public synchronized static void shutdownAllNow() {
		Collection<ExecutorService> ess = EXECUTOR_SERVICE_MAP.values();
		for (ExecutorService es : ess) {
			es.shutdownNow();
		}
	}
}
