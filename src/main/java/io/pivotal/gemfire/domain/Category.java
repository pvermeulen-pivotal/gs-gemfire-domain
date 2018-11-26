package io.pivotal.gemfire.domain;

import java.beans.Transient;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Category implements PdxSerializable {

	private int categoryId;
	private String categoryName;
	private int subCategoryId;
	private String subCategoryName;

	public Category() {
	}

	public Category(int categoryId, String categoryName, int subCategoryId, String subCategoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	@Transient
	public int getKey() {
		return this.categoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + subCategoryId;
		result = prime * result + ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		if (subCategoryName == null) {
			if (other.subCategoryName != null)
				return false;
		} else if (!subCategoryName.equals(other.subCategoryName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategoryId="
				+ subCategoryId + ", subCategoryName=" + subCategoryName + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeInt("categoryId", this.categoryId);
		writer.writeString("categoryName", this.categoryName);
		writer.writeInt("subCategoryId", this.subCategoryId);
		writer.writeString("subCategoryName", this.subCategoryName);
	}

	public void fromData(PdxReader reader) {
		reader.readInt("categoryId");
		reader.readString("categoryName");
		reader.readInt("subCategoryId");
		reader.readString("subCategoryName");
	}

}
