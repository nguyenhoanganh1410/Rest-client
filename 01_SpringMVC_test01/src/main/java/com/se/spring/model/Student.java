package com.se.spring.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull(message = "is requried")
	private String name;
	
	@NotNull(message = "is requried")
	@Min(value = 18, message = "must be greater than or equal to 18")
	@Max(value = 100, message = "must be less than or equal to 100")
	private int age;
	
	@NotNull(message = "is requried")
	private int sex;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="FavoriteSubject", joinColumns = @JoinColumn(name="id") )
	@Column(name="favoriteSubject", nullable = false)
	private Set<String> favoriteSubject;
	
	@Column(name="favorite_language")
	@NotNull(message = "is requried")
	private String favoriteLanguage;

	public Student() {
		super();
	}

	public Student(String name, int age, int sex, Set<String> favoriteSubject, String favoriteLanguage) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.favoriteSubject = favoriteSubject;
		this.favoriteLanguage = favoriteLanguage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Set<String> getFavoriteSubject() {
		return favoriteSubject;
	}

	public void setFavoriteSubject(Set<String> favoriteSubject) {
		this.favoriteSubject = favoriteSubject;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", favoriteSubject="
				+ favoriteSubject + ", favoriteLanguage=" + favoriteLanguage + "]";
	}
	
	
	
}
