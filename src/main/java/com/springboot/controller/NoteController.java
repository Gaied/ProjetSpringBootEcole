package com.springboot.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Classe;
import com.springboot.bean.Eleve;
import com.springboot.bean.Matiere;
import com.springboot.bean.Note;
import com.springboot.bean.Professeur;
import com.springboot.controller.form.NoteForm;

import com.springboot.service.IServiceMatiere;
import com.springboot.service.IServiceNote;

import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;
import com.springboot.service.iServiceProfesseur;

@Controller
public class NoteController {
	
	@Autowired
	private IServiceNote servicenote;
	@Autowired
	private iServiceProfesseur serviceprof;
	@Autowired
	private IServiceMatiere servicematiere;
	@Autowired
	private iServiceEleve serviceeleve;
	@Autowired
	private iServiceClasse serviceclasse;
	
	private Note convertForm(NoteForm noteform) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(noteform.getDatesaisie());
		Note pnote = new Note();
		Classe pclasse = serviceclasse.rechercheClasseId(Integer.valueOf(noteform.getClasse()));
		Eleve peleve = serviceeleve.rechercheEleveId(Integer.valueOf(noteform.getEleve()));
		Matiere pmartiere = servicematiere.rechercheMatiereId(Integer.valueOf(noteform.getMatiere()));
		Professeur pprof = serviceprof.rechercheProfId(Integer.valueOf(noteform.getProf()));
		pnote.setId(noteform.getId());
		pnote.setAvis(noteform.getAvis());
		pnote.setNote(noteform.getNote());
		pnote.setAvancement(noteform.getAvancement());
		pnote.setDatesaisie(madate);
		pnote.setClasse(pclasse);
		pnote.setEleve(peleve);
		pnote.setMatiere(pmartiere);
		pnote.setProfesseur(pprof);
		
		return pnote;
	}
	
	@GetMapping("/afficherCreerNote")
	public String getAffiche(Model pmodel) {
		List<Note> lnote = servicenote.rechercheNote();
		List<Professeur> lprof = serviceprof.rechercheProf();
		List<Eleve> leleve =serviceeleve.rechercheEleve();
		List<Matiere> lmatiere =servicematiere.rechercheMatiere();
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("listeeleve", leleve);
		pmodel.addAttribute("listematiere", lmatiere);
		pmodel.addAttribute("listenote", lnote);
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("action", "CreerNote");
		if(pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(0);
			pmodel.addAttribute("noteform",noteform);
		}
		return "notes";
	}
	
	@PostMapping("/CreerNote") public String ajoutNote( 
			@Valid @ModelAttribute(name = "noteform") NoteForm noteform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Note pnote = convertForm(noteform);
				servicenote.creerNote(pnote);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/SupprimerNote/{id}")
	public String getSupprimer(@PathVariable final Integer id, Model pmodel) {
		Note pnote = servicenote.rechercheNoteId(id);
		if (pnote != null) {
			servicenote.supprimerNote(pnote);
			;
		}
		return this.getAffiche(pmodel);
	}

}
