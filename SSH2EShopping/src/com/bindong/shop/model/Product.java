package com.bindong.shop.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String name;
	private Double price;
	private String pic;
	private String remark;
	private String details;
	private Date date;
	private Boolean commend;
	private Boolean open;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name="
				+ name + ", price=" + price + ", pic=" + pic + ", remark="
				+ remark + ", details=" + details + ", commend=" + commend + ", open=" + open + "]";
	}
	
	
	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
/*	public Product(Timestamp date) {
		this.date = date;
	}
*/
	/** full constructor */
	public Product(Category category, String name, Double price, String pic,
			String remark, String details, Date date, Boolean commend,
			Boolean open) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.details = details;
		this.date = date;
		this.commend = commend;
		this.open = open;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "price", precision = 8)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name = "pic", length = 200)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "details")
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	@Column(name = "date", nullable = true, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Column(name = "commend")
	public Boolean getCommend() {
		return this.commend;
	}

	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	
	@Column(name = "open")
	public Boolean getOpen() {
		return this.open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}