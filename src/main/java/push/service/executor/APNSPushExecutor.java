package push.service.executor;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;

import push.model.AppClient;

public class APNSPushExecutor extends PushExecutor {

	public APNSPushExecutor(AppClient client, String content) {
		super(client, content);
	}

	@Override
	public void execute() {
		try {
			ApnsService service = createService();
			String payload = APNS.newPayload().alertBody(content).customField("message", content).sound("alert.wav")
					.build();
			ApnsNotification result = service.push(client.getRegistrationId(), payload);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
	}

	private ApnsService createService() {
		ApnsServiceBuilder builder = APNS.newService().withCert(client.getApp().getApnsCertificateFileLocation(),
				client.getApp().getApnsCertificatePassword());
		if(client.getApp().isProductionVersion()) {
			return builder.withProductionDestination().build();
		} else {
			return builder.withSandboxDestination().build();
		}
		
	}

}
