package com.cinema.app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String originalName;
	private String translatedName;
	private Date releaseDate;
	private Date endDate;
	private String gender;
	private String synopsis;
	private String formatMovie;
	private String duration;
	@ManyToMany(mappedBy = "cinemasMovies")
	@JsonIgnore
	private Set<Cinema> cinema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getTranslatedName() {
		return translatedName;
	}

	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFormatMovie() {
		return formatMovie;
	}

	public void setFormatMovie(String formatMovie) {
		this.formatMovie = formatMovie;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Set<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(Set<Cinema> cinema) {
		this.cinema = cinema;
	}

}
