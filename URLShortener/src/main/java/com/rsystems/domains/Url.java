package com.rsystems.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rsystems.utils.Constants;

@Entity
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = Constants.URL_CODE_SIZE)
	private String code;

	@Column(length = Constants.MAX_LONG_URL_SIZE)
	private String longUrl;

	@Column(length = Constants.MAX_LONG_URL_SIZE)
	private String customerId;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "url")
	private List<Statistic> statistics = new ArrayList<>();

	public Url() {

	}

	public Url(String code, String longUrl, String customerId) {
		super();
		this.code = code;
		this.longUrl = longUrl;
		this.customerId = customerId;
	}

	@PrePersist
	protected void prePersist() {
		if (this.createdAt == null)
			createdAt = new Date();
		if (this.updatedAt == null)
			updatedAt = new Date();
	}

	@PreUpdate
	protected void preUpdate() {
		this.updatedAt = new Date();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Statistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((longUrl == null) ? 0 : longUrl.hashCode());
		result = prime * result + ((statistics == null) ? 0 : statistics.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Url other = (Url) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (longUrl == null) {
			if (other.longUrl != null)
				return false;
		} else if (!longUrl.equals(other.longUrl))
			return false;
		if (statistics == null) {
			if (other.statistics != null)
				return false;
		} else if (!statistics.equals(other.statistics))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

}
