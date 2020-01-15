package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class NoteForm {

	private Integer id;
	
	@NotEmpty
	private Integer note;
	@NotEmpty
	@Pattern(regexp = "x,xx")
	private float avancement;
	@NotEmpty
	private String avis;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String classe;
	@NotEmpty
	private String datesaisie;
	@NotEmpty
	private String prof;
	@NotEmpty
	private String eleve;
	@NotEmpty
	private String matiere;
	@NotEmpty
	private String trimestre;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public String getDatesaisie() {
		return datesaisie;
	}
	public void setDatesaisie(String datesaisie) {
		this.datesaisie = datesaisie;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getEleve() {
		return eleve;
	}
	public void setEleve(String eleve) {
		this.eleve = eleve;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getTrimestre() {
		return trimestre;
	}
	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}
	
	
	
	

}
