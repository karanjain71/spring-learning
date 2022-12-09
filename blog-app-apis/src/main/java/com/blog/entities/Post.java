package com.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="post_title", length=100, nullable=false)
	private String title;
	
	@Column(name="post_content", length=10000, nullable=false)
	private String content;
	private String imageName;
	private Date addedDate;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
}
