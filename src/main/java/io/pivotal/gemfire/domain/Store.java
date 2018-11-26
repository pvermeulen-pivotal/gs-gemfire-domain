package io.pivotal.gemfire.domain;

import java.beans.Transient;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Store implements PdxSerializable {

	private int storeId;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private double longitude;
	private double latitude;

	public Store() {
	}

	public Store(int storeId, String name, String street, String city, String state, String zipCode, double longitude,
			double latitude) {
		this.storeId = storeId;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Transient
	public int getKey() {
		return this.storeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + storeId;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Store other = (Store) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (storeId != other.storeId)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", name=" + name + ", street=" + street + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeInt("storeId", this.storeId);
		writer.writeString("name", this.name);
		writer.writeString("street", this.street);
		writer.writeString("city", this.city);
		writer.writeString("state", this.state);
		writer.writeString("zipCode", this.zipCode);
		writer.writeDouble("longitude", this.longitude);
		writer.writeDouble("latitude", this.latitude);
	}

	public void fromData(PdxReader reader) {
		reader.readInt("storeId");
		reader.readString("name");
		reader.readString("street");
		reader.readString("city");
		reader.readString("state");
		reader.readString("zipCode");
		reader.readDouble("longitude");
		reader.readDouble("latitude");
	}

}
