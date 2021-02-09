package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.model.Etudiant;

public interface IEtudiantService {
	
	public List<Etudiant> listEtudiant();
	
	public String ajouterEtudiant(Etudiant e);
	
	public Etudiant modifierEtudiant(Etudiant e);
	
	public void supprimeUnEtudiant(long idEtudiant);
	
	public Etudiant chercherUnetudiantParSonNom(String nom);
	

}
