package push.service.executor;

import push.model.AppClient;

public class PushExecutorFactory {

	public static PushExecutor createPushExecutor(AppClient client, String content) {

		switch (client.getPlatform()) {
		case iOS:
			return createAPNSPushExecutor(client, content);
		case Android:
			return createGCMPushExecutor(client, content);
		default:
			throw new IllegalStateException(String.format("Error platform %s", client.getPlatform().toString()));
		}

	}

	private static PushExecutor createAPNSPushExecutor(AppClient client, String content) {
		APNSPushExecutor executor = new APNSPushExecutor(client, content);
		return executor;
	}

	private static PushExecutor createGCMPushExecutor(AppClient client, String content) {
		GCMPushExecutor executor = new GCMPushExecutor(client, content);
		return executor;
	}

}
