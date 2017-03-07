package push.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "app_clients", indexes = { @Index(name = "app_client_getId", columnList = "registrationId") })
public class AppClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_id", nullable = false)
	private App app;

	private String registrant;
	private String registrationId;
	private DevicePlatform platform;
	private Date createdDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public String getRegistrant() {
		return registrant;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public DevicePlatform getPlatform() {
		return platform;
	}

	public void setPlatform(DevicePlatform platform) {
		this.platform = platform;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
}
