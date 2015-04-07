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

import com.zm.user.entity.User;

@Entity
@Table(name = "suggestion")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Suggestion {
	public static final Short READED_NO = 10;
	public static final Short READED_YES = 20;
	public static final Short[] READEDS = new Short[] { READED_NO, READED_YES};

	protected Integer suggestionId;
	protected String contents;
	protected String imgUrls;
	protected Short readed;
	protected Date updateTime;
	protected Date createTime;

	protected User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(Integer suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}

	public Short getReaded() {
		return readed;
	}

	public void setReaded(Short readed) {
		this.readed = readed;
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
    @JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
