package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Random;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class BeaconResponse implements PdxSerializable {

	private long id;
	private long customerId;
	private String deviceId;
	private String uuid;
	private int major;
	private int minor;
	private int promotionId;
	private String message;
	private String url;
	private String error;

	public BeaconResponse() {
		setId();
	}

	public BeaconResponse(long customerId, String deviceId, String uuid, int major, int minor, 
			int promotionId, String message, String url) {
		this.customerId = customerId;
		this.deviceId = deviceId;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.promotionId = promotionId;
		this.message = message;
		this.url = url;
		setId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private void setId() {
		Random rand = new Random();
		this.id = rand.nextLong() & Long.MAX_VALUE;
	}
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Transient
	public long getKey() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + major;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + minor;
		result = prime * result + promotionId;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeaconResponse other = (BeaconResponse) obj;
		if (customerId != other.customerId)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (id != other.id)
			return false;
		if (major != other.major)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (minor != other.minor)
			return false;
		if (promotionId != other.promotionId)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconResponse [id=" + id + ", customerId=" + customerId + ", deviceId=" + deviceId
				+ ", uuid=" + uuid + ", major=" + major + ", minor=" + minor + ", promotionId=" + promotionId
				+ ", message=" + message + ", url=" + url + ", error=" + error + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("id", this.id);
		writer.writeLong("customerId", this.customerId);
		writer.writeString("deviceId", this.deviceId);
		writer.writeString("uuid", this.uuid);
		writer.writeInt("major", this.major);
		writer.writeInt("minor", this.minor);
		writer.writeInt("promotionId", this.promotionId);
		writer.writeString("message", this.message);
		writer.writeString("url", this.url);
		writer.writeString("error", this.error);
	}

	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.customerId = reader.readLong("customerId");
		this.deviceId = reader.readString("deviceId");
		this.uuid = reader.readString("uuid");
		this.major = reader.readInt("major");
		this.minor = reader.readInt("minor");
		this.promotionId = reader.readInt("promotionId");
		this.message = reader.readString("message");
		this.url = reader.readString("url");
		this.error = reader.readString("error");
	}

}
