package push.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import push.utils.ExecutorServiceUtils;

@Component
public class ContextClosedHandler implements ApplicationListener<ContextClosedEvent> {

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		
		ExecutorServiceUtils.shutdownAllNow();
		
	}

}
