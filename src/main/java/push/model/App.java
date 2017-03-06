package push.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

enum AppStatus {
	Development, Production
}

@Entity
@Table(name = "apps")
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String gcmProjectNumber;
	private String gcmApiKey;
	private String apnsCertificateFileLocation;
	private String apnsCertificatePassword;
	private AppStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGcmProjectNumber() {
		return gcmProjectNumber;
	}

	public void setGcmProjectNumber(String gcmProjectNumber) {
		this.gcmProjectNumber = gcmProjectNumber;
	}

	public String getGcmApiKey() {
		return gcmApiKey;
	}

	public void setGcmApiKey(String gcmApiKey) {
		this.gcmApiKey = gcmApiKey;
	}

	public String getApnsCertificateFileLocation() {
		return apnsCertificateFileLocation;
	}

	public void setApnsCertificateFileLocation(String apnsCertificateFileLocation) {
		this.apnsCertificateFileLocation = apnsCertificateFileLocation;
	}

	public String getApnsCertificatePassword() {
		return apnsCertificatePassword;
	}

	public void setApnsCertificatePassword(String apnsCertificatePassword) {
		this.apnsCertificatePassword = apnsCertificatePassword;
	}

	public AppStatus getStatus() {
		return status;
	}

	public void setStatus(AppStatus status) {
		this.status = status;
	}

}
