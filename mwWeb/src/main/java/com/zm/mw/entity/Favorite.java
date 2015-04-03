package com.zm.mw.entity;

import java.util.Date;

import javax.persistence.Cacheable;
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
@Table(name = "favorite")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Favorite {
	protected Integer favoriteId;
	protected Date createTime;
	protected User user;
	protected Ui ui;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uiId")
	public Ui getUi() {
		return ui;
	}
	public void setUi(Ui ui) {
		this.ui = ui;
	}
	
	
}
