package push.service.executor;

import java.io.IOException;

import com.google.android.gcm.server.Endpoint;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import push.model.AppClient;

public class GCMPushExecutor extends PushExecutor {

	private AppClient client;
	private String content;

	public  GCMPushExecutor(AppClient client, String content) {
		super(client, content);
	}
	
	@Override
	public void execute() {

		Sender sender = new Sender(client.getApp().getGcmApiKey(), Endpoint.GCM);
		Message message = new Message.Builder().addData("message", content).build();
		try {
			Result result = sender.send(message, client.getRegistrationId(), 2);
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}

}
