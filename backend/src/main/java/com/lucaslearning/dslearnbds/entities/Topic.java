package com.lucaslearning.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;

	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;

	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@ManyToMany
	@JoinTable(name = "tb_topic_likes", 
		joinColumns = @JoinColumn(name = "topic_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> likes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "reply_id")
	private Reply answer;
	
	@OneToMany(mappedBy = "topic")
	private Set<Reply> replies = new HashSet<>();
	
	public Topic() {

	}

	public Topic(Long id, String title, String body, Instant moment, Offer offer, Lesson lesson, User author,
			Reply answer) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
		this.offer = offer;
		this.lesson = lesson;
		this.author = author;
		this.answer = answer;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Set<User> getLikes() {
		return likes;
	}
	
	public Reply getAnswer() {
		return answer;
	}

	public void setAnswer(Reply answer) {
		this.answer = answer;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id);
	}

}
