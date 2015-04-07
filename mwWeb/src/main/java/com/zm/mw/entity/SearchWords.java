package com.zm.mw.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "search_words")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SearchWords {
	public static final Short TYPE_WORD = 10;
	public static final Short TYPE_UICATEGORY = 20;
	public static final Short[] TYPES = new Short[] { TYPE_WORD,
			TYPE_UICATEGORY };

	protected Integer searchWordsId;
	protected String word;
	protected Integer times;
	protected Short type;
	protected Date updateTime;
	protected Date createTime;

	protected UiCategory uiCategory;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getSearchWordsId() {
		return searchWordsId;
	}

	public void setSearchWordsId(Integer searchWordsId) {
		this.searchWordsId = searchWordsId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(updatable = false)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uiCategoryId")
	public UiCategory getUiCategory() {
		return uiCategory;
	}

	public void setUiCategory(UiCategory uiCategory) {
		this.uiCategory = uiCategory;
	}

}
