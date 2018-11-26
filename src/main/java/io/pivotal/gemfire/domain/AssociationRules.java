package io.pivotal.gemfire.domain;

import java.beans.Transient;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class AssociationRules implements PdxSerializable {

	private int ruleId;
	private long preProductId;
	private long postProductId;
	private int count;
	private double support;
	private double confidence;
	private double lift;
	private double conviction;

	public AssociationRules() {
	}

	public AssociationRules(int ruleId, long preProductId, long postProductId, int count, double support,
			double confidence, double lift, double conviction) {
		this.ruleId = ruleId;
		this.preProductId = preProductId;
		this.postProductId = postProductId;
		this.count = count;
		this.support = support;
		this.confidence = confidence;
		this.lift = lift;
		this.conviction = conviction;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public long getPreProductId() {
		return preProductId;
	}

	public void setPreProductId(long preProductId) {
		this.preProductId = preProductId;
	}

	public long getPostProductId() {
		return postProductId;
	}

	public void setPostProductId(long postProductId) {
		this.postProductId = postProductId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSupport() {
		return support;
	}

	public void setSupport(double support) {
		this.support = support;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public double getLift() {
		return lift;
	}

	public void setLift(double lift) {
		this.lift = lift;
	}

	public double getConviction() {
		return conviction;
	}

	public void setConviction(double conviction) {
		this.conviction = conviction;
	}

	@Transient
	public int getKey() {
		return this.ruleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(confidence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(conviction);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + count;
		temp = Double.doubleToLongBits(lift);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (postProductId ^ (postProductId >>> 32));
		result = prime * result + (int) (preProductId ^ (preProductId >>> 32));
		result = prime * result + ruleId;
		temp = Double.doubleToLongBits(support);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		AssociationRules other = (AssociationRules) obj;
		if (Double.doubleToLongBits(confidence) != Double.doubleToLongBits(other.confidence))
			return false;
		if (Double.doubleToLongBits(conviction) != Double.doubleToLongBits(other.conviction))
			return false;
		if (count != other.count)
			return false;
		if (Double.doubleToLongBits(lift) != Double.doubleToLongBits(other.lift))
			return false;
		if (postProductId != other.postProductId)
			return false;
		if (preProductId != other.preProductId)
			return false;
		if (ruleId != other.ruleId)
			return false;
		if (Double.doubleToLongBits(support) != Double.doubleToLongBits(other.support))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssociationRules [ruleId=" + ruleId + ", preProductId=" + preProductId + ", postProductId="
				+ postProductId + ", count=" + count + ", support=" + support + ", confidence=" + confidence + ", lift="
				+ lift + ", conviction=" + conviction + "]";
	}

	public void toData(PdxWriter writer) {
		writer.writeInt("ruleId", this.ruleId);
		writer.writeLong("preProductId", this.preProductId);
		writer.writeLong("postProductId", this.postProductId);
		writer.writeInt("count", this.count);
		writer.writeDouble("support", this.support);
		writer.writeDouble("confidence", this.confidence);
		writer.writeDouble("lift", this.lift);
		writer.writeDouble("conviction", this.conviction);
	}

	public void fromData(PdxReader reader) {
		reader.readInt("ruleId");
		reader.readLong("preProductId");
		reader.readLong("postProductId");
		reader.readInt("count");
		reader.readDouble("support");
		reader.readDouble("confidence");
		reader.readDouble("lift");
		reader.readDouble("conviction");
	}

}
