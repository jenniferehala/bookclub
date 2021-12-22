package com.codingdojo.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max=50, message="This needs a title between 5 and 50")
	private String title;
	
	@NotNull
	@Size(min=5, max=50, message="This needs an author name between 5 and 50")
	private String author;
	
	@NotNull
	@Size(min=5, max=300, message="This needs a description between 5 and 50")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date createdAt;
		
	@Column(updatable=false)
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    
    private User user;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Book() {
		super();
	}
	public Book(Long id, String title, String author, Date createdAt, Date updatedAt, User user, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		
	}
	
	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    
    
    
}
