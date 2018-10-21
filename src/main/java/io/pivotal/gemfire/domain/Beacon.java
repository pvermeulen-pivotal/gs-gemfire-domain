package io.pivotal.gemfire.domain;

import java.beans.Transient;

import org.apache.commons.lang.StringUtils;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Beacon implements PdxSerializable {

	private String uuid;
	private String major;
	private String minor;
	private String category;
	private boolean entrance;
	private boolean checkout;

	public Beacon() {
	}

	public Beacon(String uuid, int major, int minor, String category, boolean entrance, boolean checkout) {
		super();
		this.uuid = uuid;
		this.major = StringUtils.leftPad(Integer.toString(major), 5, "0");
		this.minor = StringUtils.leftPad(Integer.toString(minor), 5, "0");
		this.category = category;
		this.entrance = entrance;
		this.checkout = checkout;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isEntrance() {
		return entrance;
	}

	public void setEntrance(boolean entrance) {
		this.entrance = entrance;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	@Transient
	public String getKey() {
		return this.uuid + "|" + this.major + "|" + this.minor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (checkout ? 1231 : 1237);
		result = prime * result + (entrance ? 1231 : 1237);
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((minor == null) ? 0 : minor.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (checkout != other.checkout)
			return false;
		if (entrance != other.entrance)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (minor == null) {
			if (other.minor != null)
				return false;
		} else if (!minor.equals(other.minor))
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
		return "Beacon [uuid=" + uuid + ", major=" + major + ", minor=" + minor + ", category=" + category
				+ ", entrance=" + entrance + ", checkout=" + checkout + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeString("uuid", this.uuid);
		writer.writeString("major", this.major);
		writer.writeString("minor", this.minor);
		writer.writeString("category", this.category);
		writer.writeBoolean("entrance", this.entrance);
		writer.writeBoolean("checkout", this.checkout);
	}

	public void fromData(PdxReader reader) {
		this.uuid = reader.readString("uuid");
		this.major = reader.readString("major");
		this.minor = reader.readString("minor");
		this.category = reader.readString("category");
		this.entrance = reader.readBoolean("entrance");
		this.checkout = reader.readBoolean("checkout ");		
	}

}
