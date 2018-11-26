package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Random;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Beacon implements PdxSerializable {

	private long id;
	private String uuid;
	private int major;
	private int minor;
	private int categoryId;

	public Beacon() {
		setId();
	}

	public Beacon(String uuid, int major, int minor, int categoryId) {
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategory(int categoryId) {
		this.categoryId = categoryId;
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
		result = prime * result + categoryId;
		result = prime * result + major;
		result = prime * result + minor;
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
		Beacon other = (Beacon) obj;
		if (id != other.id)
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (major != other.major)
			return false;
		if (minor != other.minor)
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
		return "Beacon [id=" + id + ", uuid=" + uuid + ", major=" + major + ", minor=" + minor
				+ ", categoryId=" + categoryId + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("id", this.id);
		writer.writeString("uuid", this.uuid);
		writer.writeInt("major", this.major);
		writer.writeInt("minor", this.minor);
		writer.writeInt("categoryId", this.categoryId);
	}

	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.uuid = reader.readString("uuid");
		this.major = reader.readInt("major");
		this.minor = reader.readInt("minor");
		this.categoryId = reader.readInt("categoryId");
	}

}
