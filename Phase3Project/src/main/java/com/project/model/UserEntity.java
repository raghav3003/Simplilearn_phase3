package com.project.model;
 
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Entity
@Table(name="user")
@EnableTransactionManagement
public class UserEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", updatable = false, nullable = false)
    private int userId;
    
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private String email;
    
    @Column
    private BigDecimal phone_number;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int userId, String username, String password, String email, BigDecimal phone_number) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(BigDecimal phone_number) {
		this.phone_number = phone_number;
	}
    
    
    
}