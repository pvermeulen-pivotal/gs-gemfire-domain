package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Random;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class BeaconRequest implements PdxSerializable {
	private long id;
	private long customerId;
	private String deviceId;
	private String uuid;
	private int major;
	private int minor;
	private int signalPower;

	public BeaconRequest() {
		setId();
	}

	public BeaconRequest(long customerId, String deviceId, String uuid, int major, int minor,
			int signalPower) {
		this.customerId = customerId;
		this.deviceId = deviceId;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.signalPower = signalPower;
		setId();
	}

	public long getId() {
		return this.id;
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

	public int getSignalPower() {
		return signalPower;
	}

	public void setSignalPower(int signalPower) {
		this.signalPower = signalPower;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String userDeviceId) {
		this.deviceId = userDeviceId;
	}

	@Transient
	public long getKey() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + major;
		result = prime * result + minor;
		result = prime * result + signalPower;
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
		BeaconRequest other = (BeaconRequest) obj;
		if (id != other.id)
			return false;
		if (customerId != other.customerId)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (major != other.major)
			return false;
		if (minor != other.minor)
			return false;
		if (signalPower != other.signalPower)
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
		return "BeaconRequest [id=" + id + ", customerId=" + customerId + ", deviceId=" + deviceId
				+ ", uuid=" + uuid + ", major=" + major + ", minor=" + minor + ", signalPower=" + signalPower + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("id", this.id);
		writer.writeLong("customerId", this.customerId);
		writer.writeString("deviceId", this.deviceId);
		writer.writeString("uuid", this.uuid);
		writer.writeInt("major", this.major);
		writer.writeInt("minor", this.minor);
		writer.writeInt("signalPower", this.signalPower);
	}

	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.customerId = reader.readLong("customerId");
		this.deviceId = reader.readString("deviceId");
		this.uuid = reader.readString("uuid");
		this.major = reader.readInt("major");
		this.minor = reader.readInt("minor");
		this.signalPower = reader.readInt("signalPower");
	}

}