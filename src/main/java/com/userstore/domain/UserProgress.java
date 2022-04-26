package com.userstore.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="userprogress_tbl")
public class UserProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "level")
	private Integer level;
	
	@Column(name = "score")
	private Double score;

	@OneToOne(mappedBy = "userProgress")
	@JsonIgnore
    private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserProgress)) {
			return false;
		}
		UserProgress other = (UserProgress) obj;
		return Objects.equals(id, other.id) && Objects.equals(level, other.level) && Objects.equals(score, other.score);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, level, score);
	}
	
}
