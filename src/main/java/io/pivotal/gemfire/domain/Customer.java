package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Date;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Customer implements PdxSerializable {

	private long customerId;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String primaryNumber;
	private String mobileNumber;
	private Date openDate;
	private Date lastUpdate;

	public Customer() {
	}

	public Customer(long customerId, String firstName, String lastName, String street, String city, String state,
			String zipCode, String primaryNumber, String mobileNumber, Date openDate, Date lastUpdate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.primaryNumber = primaryNumber;
		this.mobileNumber = mobileNumber;
		this.openDate = openDate;
		this.lastUpdate = lastUpdate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((primaryNumber == null) ? 0 : primaryNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Customer other = (Customer) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customerId != other.customerId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		if (primaryNumber == null) {
			if (other.primaryNumber != null)
				return false;
		} else if (!primaryNumber.equals(other.primaryNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
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
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", primaryNumber=" + primaryNumber + ", mobileNumber=" + mobileNumber + ", openDate=" + openDate
				+ ", lastUpdate=" + lastUpdate + "]";
	}

	@Transient
	public long getKey() {
		return this.customerId;
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("customerId", this.customerId);
		writer.writeString("firstName", this.firstName);
		writer.writeString("lastName", this.lastName);
		writer.writeString("street", this.street);
		writer.writeString("city", this.city);
		writer.writeString("state", this.state);
		writer.writeString("zipCode", this.zipCode);
		writer.writeString("primaryNumber", this.primaryNumber);
		writer.writeString("mobileNumber", this.mobileNumber);
		writer.writeDate("openDate", this.openDate);
		writer.writeDate("lastUpdate", this.lastUpdate);
	}

	public void fromData(PdxReader reader) {
		reader.readLong("customerId");
		reader.readString("firstName");
		reader.readString("lastName");
		reader.readString("street");
		reader.readString("city");
		reader.readString("state");
		reader.readString("zipCode");
		reader.readString("primaryNumber");
		reader.readString("mobileNumber");
		reader.readDate("openDate");
		reader.readDate("lastUpdate");
	}

}
