package com.springboot.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnotes")
	private Integer id;
	@Column(name = "note", length = 11, nullable = false)
	private Integer note;
	@Column(name = "avancement", nullable = false)
	private float avancement;
	@Lob
	@Column(name = "avis", columnDefinition="text", nullable = false)
	private String avis;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_saisie", nullable = false)
	private Date datesaisie;

	@ManyToOne
	@JoinColumn(name = "idprof", nullable = false)
	private Professeur prof;
	@ManyToOne
	@JoinColumn(name = "idclasse", nullable = false)
	private Classe classe;
	@ManyToOne
	@JoinColumn(name = "ideleve", nullable = false)
	private Eleve eleve;
	@ManyToOne
	@JoinColumn(name = "idmatiere", nullable = false)
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "idtrimestre", nullable = false)
	private Trimestre trimestre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public float getAvancement() {
		return avancement;
	}
	public void setAvancement(float avancement) {
		this.avancement = avancement;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
	public Date getDatesaisie() {
		return datesaisie;
	}
	public void setDatesaisie(Date datesaisie) {
		this.datesaisie = datesaisie;
	}
	public Professeur getProfesseur() {
		return prof;
	}
	public void setProfesseur(Professeur professeur) {
		this.prof = professeur;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Trimestre getTrimestre() {
		return trimestre;
	}
	public void setTrimestre(Trimestre trimestre) {
		this.trimestre = trimestre;
	}
	
	

}