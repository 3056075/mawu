package com.zm.mw.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.zm.user.entity.User;

@Entity
@Table(name = "ui")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ui {
	public static final Short SYSTEM_IOS = 10;
	public static final Short SYSTEM_ANDROID = 20;
	public static final Short SYSTEM_H5 = 30;
	public static final Short[] SYSTEMS = new Short[] { SYSTEM_IOS, SYSTEM_ANDROID,SYSTEM_H5};
	
	public static final Short STATUS_SHOW = 20;
	public static final Short STATUS_HIDDEN = 10;
	public static final Short[] STATUSS = new Short[]{STATUS_SHOW,STATUS_HIDDEN};
	
	public static final Short SOURCE_ADMIN = 10;
	public static final Short SOURCE_USER = 20;
	public static final Short[] SOURCES = new Short[]{SOURCE_ADMIN,SOURCE_USER};
	
	protected Integer uiId;

	protected String productName;
	protected String pageName;
	protected String keywords;
	protected Short system;
	protected Short status;
	protected Short source;
	protected String imgUrl;
	protected Date createTime;
	
	protected UiCategory uiCategory;
	protected User user;
	
	protected Set<Favorite> favorites;
	//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUiId() {
		return uiId;
	}
	public void setUiId(Integer uiId) {
		this.uiId = uiId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Short getSystem() {
		return system;
	}
	public void setSystem(Short system) {
		this.system = system;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Short getSource() {
		return source;
	}
	public void setSource(Short source) {
		this.source = source;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "ui",fetch = FetchType.LAZY)
	public Set<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	
}
