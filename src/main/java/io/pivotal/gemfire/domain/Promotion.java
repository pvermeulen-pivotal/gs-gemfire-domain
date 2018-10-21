package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Date;

public class Promotion  {

	private String id;
	private Date startDate;
	private Date endDate;
	private String marketingMessage;
	private Object marketingBitmap;

	public Promotion() {
	}

	public Promotion(String id, Date startDate, Date endDate, String marketingMessage, Object marketingBitmap) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.marketingMessage = marketingMessage;
		this.marketingBitmap = marketingBitmap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMarketingMessage() {
		return marketingMessage;
	}

	public void setMarketingMessage(String marketingMessage) {
		this.marketingMessage = marketingMessage;
	}

	public Object getMarketingBitmap() {
		return marketingBitmap;
	}

	public void setMarketingBitmap(Object marketingBitmap) {
		this.marketingBitmap = marketingBitmap;
	}

	@Transient
	public String getKey() {
		return this.id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marketingBitmap == null) ? 0 : marketingBitmap.hashCode());
		result = prime * result + ((marketingMessage == null) ? 0 : marketingMessage.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Promotion other = (Promotion) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marketingBitmap == null) {
			if (other.marketingBitmap != null)
				return false;
		} else if (!marketingBitmap.equals(other.marketingBitmap))
			return false;
		if (marketingMessage == null) {
			if (other.marketingMessage != null)
				return false;
		} else if (!marketingMessage.equals(other.marketingMessage))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", marketingMessage="
				+ marketingMessage + ", marketingBitmap=" + marketingBitmap + "]";
	}
	
}
