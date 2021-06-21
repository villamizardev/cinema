package com.cinema.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cinemas")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idBranchOffice", referencedColumnName = "id")
	private BranchOffice idBranchOffice;
	private String typeOfCinema;
	private String numberOfRows;
	private String numberOfChair;
	@ManyToMany
	@JoinTable(name = "cinemasMovies", joinColumns = @JoinColumn(name = "idCinema"), inverseJoinColumns = @JoinColumn(name = "idMovie"))
	private Set<Movie> cinemasMovies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BranchOffice getIdBranchOffice() {
		return idBranchOffice;
	}

	public void setIdBranchOffice(BranchOffice idBranchOffice) {
		this.idBranchOffice = idBranchOffice;
	}

	public String getTypeOfCinema() {
		return typeOfCinema;
	}

	public void setTypeOfCinema(String typeOfCinema) {
		this.typeOfCinema = typeOfCinema;
	}

	public String getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(String numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public String getNumberOfChair() {
		return numberOfChair;
	}

	public void setNumberOfChair(String numberOfChair) {
		this.numberOfChair = numberOfChair;
	}

	public Set<Movie> getCinemasMovies() {
		return cinemasMovies;
	}

	public void setCinemasMovies(Set<Movie> cinemasMovies) {
		this.cinemasMovies = cinemasMovies;
	}

}
