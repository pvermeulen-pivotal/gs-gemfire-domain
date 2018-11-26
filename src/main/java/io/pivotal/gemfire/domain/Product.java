package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Date;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Product implements PdxSerializable {

	private long productId;
	private String productName;
	private int categoryId;
	private int subCategoryId;
	private double unit;
	private double cost;
	private double price;
	private String url;
	private Date startDate;
	private Date endDate;
	private Date createdDate;
	private Date lastUpdatedDate;

	public Product() {
	}

	public Product(long productId, String productName, int categoryId, int subCategoryId, double unit, double cost,
			double price, String url, Date startDate, Date endDate, Date createdDate, Date lastUpdatedDate) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.unit = unit;
		this.cost = cost;
		this.price = price;
		this.url = url;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Transient
	public long getKey() {
		return this.productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((lastUpdatedDate == null) ? 0 : lastUpdatedDate.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + subCategoryId;
		temp = Double.doubleToLongBits(unit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (categoryId != other.categoryId)
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (lastUpdatedDate == null) {
			if (other.lastUpdatedDate != null)
				return false;
		} else if (!lastUpdatedDate.equals(other.lastUpdatedDate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		if (Double.doubleToLongBits(unit) != Double.doubleToLongBits(other.unit))
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
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", subCategoryId=" + subCategoryId + ", unit=" + unit + ", cost=" + cost + ", price=" + price
				+ ", url=" + url + ", startDate=" + startDate + ", endDate=" + endDate + ", createdDate=" + createdDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("productId", this.productId);
		writer.writeString("productName", this.productName);
		writer.writeInt("categoryId", this.categoryId);
		writer.writeInt("subCategoryId", this.subCategoryId);
		writer.writeObject("unit", this.unit);
		writer.writeObject("cost", this.cost);
		writer.writeObject("price", this.price);
		writer.writeString("url", this.url);
		writer.writeDate("startDate", this.startDate);
		writer.writeDate("endDate", this.endDate);
		writer.writeDate("createdDate", this.createdDate);
		writer.writeDate("lastUpdatedDate", this.lastUpdatedDate);
	}

	public void fromData(PdxReader reader) {
		reader.readLong("productId");
		reader.readString("productName");
		reader.readInt("categoryId");
		reader.readInt("subCategoryId");
		reader.readObject("unit");
		reader.readObject("cost");
		reader.readObject("price");
		reader.readString("url");
		reader.readDate("startDate");
		reader.readDate("endDate");
		reader.readDate("createdDate");
		reader.readDate("lastUpdatedDate");
	}

}
