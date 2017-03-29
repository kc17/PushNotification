package push.model;

import java.util.List;

public class Notice {

	private String content;
	private List<Long> targets;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Long> getTargets() {
		return targets;
	}

	public void setTargets(List<Long> targets) {
		this.targets = targets;
	}

}
