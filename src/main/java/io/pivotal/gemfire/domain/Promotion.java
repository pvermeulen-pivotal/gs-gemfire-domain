package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Date;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Promotion implements PdxSerializable {

	private int promotionId;
	private Date startDate;
	private Date endDate;
	private String message;
	private String url;

	public Promotion() {
	}

	public Promotion(int promotionId, Date startDate, Date endDate, String message, String url) {
		this.promotionId = promotionId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.message = message;
		this.url = url;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
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

	@Transient
	public int getKey() {
		return this.promotionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + promotionId;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		if (promotionId != other.promotionId)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + promotionId + ", startDat=" + startDate + ", endDate=" + endDate + ", message="
				+ message + ", url=" + url + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeInt("promotionId", this.promotionId);
		writer.writeDate("startDat", this.startDate);
		writer.writeDate("endDate;", this.endDate);
		writer.writeString("message", this.message);
		writer.writeString("url", this.url);
	}

	public void fromData(PdxReader reader) {
		reader.readInt("promotionId");
		reader.readDate("startDate");
		reader.readDate("endDate;");
		reader.readString("message");
		reader.readString("url");
	}

}
