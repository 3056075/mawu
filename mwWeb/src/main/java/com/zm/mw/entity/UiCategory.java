package com.zm.mw.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ui_category")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UiCategory {
	protected Integer uiCategoryId;
	protected String name;
	protected Integer rank;
	protected Date updateTime;
	protected Date createTime;
	
	protected Set<Ui> uis;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUiCategoryId() {
		return uiCategoryId;
	}

	public void setUiCategoryId(Integer uiCategoryId) {
		this.uiCategoryId = uiCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@OneToMany(mappedBy = "uiCategory",fetch = FetchType.LAZY)
	@OrderBy("uiId")
	public Set<Ui> getUis() {
		return uis;
	}

	public void setUis(Set<Ui> uis) {
		this.uis = uis;
	}
	
	
}
