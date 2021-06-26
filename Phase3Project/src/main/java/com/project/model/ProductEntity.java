package com.project.model;
 
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Entity
@Table(name="product")
@EnableTransactionManagement
public class ProductEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", updatable = false, nullable = false)
    private int productId;
    
    @Column
    private String season;
    
    @Column
    private String brand;
    
    @Column
    private String category;
    
    @Column
    private double price;
    
    @Column
    private String color;
    
    @Column
    private Date createdDate;
    
    @Column
    private int discount;
    
	public ProductEntity() {
		super();
	}

	public ProductEntity(int productId, String season, String brand, String category, double price, String color,
			Date createdDate, int discount) {
		super();
		this.productId = productId;
		this.season = season;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.color = color;
		this.createdDate = createdDate;
		this.discount = discount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
