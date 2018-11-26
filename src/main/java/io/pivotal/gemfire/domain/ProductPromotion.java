package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Date;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class ProductPromotion implements PdxSerializable {

	private long productId;
	private int categoryId;
	private int subCategoryId;
	private int promotionId;
	private Date startDate;
	private Date endDate;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	@Transient
	public long getKey() {
		return this.productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + promotionId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + subCategoryId;
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
		ProductPromotion other = (ProductPromotion) obj;
		if (categoryId != other.categoryId)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (productId != other.productId)
			return false;
		if (promotionId != other.promotionId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPromotion [productId=" + productId + ", categoryId=" + categoryId + ", subCategoryId="
				+ subCategoryId + ", promotionId=" + promotionId + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("productId", this.productId);
		writer.writeInt("cateogyId", this.categoryId);
		writer.writeInt("subCategoryId", this.subCategoryId);
		writer.writeInt("promotionId", this.promotionId);
		writer.writeDate("startDate", this.startDate);
		writer.writeDate("endDate", this.endDate);
	}

	public void fromData(PdxReader reader) {
		reader.readLong("productId");
		reader.readInt("cateogyId");
		reader.readInt("subCategoryId");
		reader.readInt("promotionId");
		reader.readDate("startDate");
		reader.readDate("endDate");
	}

}
