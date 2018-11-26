package io.pivotal.gemfire.domain;

import java.beans.Transient;
import java.util.Random;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class CustomerFavorites implements PdxSerializable {
	private long id;
	private long customerId;
	private long productId;
	private int count;

	public CustomerFavorites() {
		setId();
	}

	public CustomerFavorites(long customerId, long productId, int count) {
		this.customerId = customerId;
		this.productId = productId;
		this.count = count;
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
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
		result = prime * result + count;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
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
		CustomerFavorites other = (CustomerFavorites) obj;
		if (id != other.id)
			return false;
		if (count != other.count)
			return false;
		if (customerId != other.customerId)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerFavorites [id=" + id + ", customerId=" + customerId + ", productId=" + productId
				+ ", count=" + count + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeLong("id", this.id);
		writer.writeLong("customerId", this.customerId);
		writer.writeLong("productId", this.productId);
		writer.writeInt("count", this.count);
	}

	public void fromData(PdxReader reader) {
		reader.readLong("id");
		reader.readLong("customerId");
		reader.readLong("productId");
		reader.readInt("count");
	}

}
