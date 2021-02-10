package controllers;

import java.util.List;

import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.service.EtudiantService;
import fr.formation.afpa.service.IEtudiantService;

public class ControllerGeneral {

	IEtudiantService iEtudiantService = new EtudiantService();

	public void addEtudiant(Etudiant etudiant) {

		iEtudiantService.ajouterEtudiant(etudiant);

	}
	
	public void modifieUnEtudiant(Etudiant etudiant) {
		
		iEtudiantService.modifierEtudiant(etudiant);
	}

	public List<Etudiant> getAllEtudiants() {

		return iEtudiantService.listEtudiant();

	}

	public void supprimerUnEtudian(long idEtudiant) {

		iEtudiantService.supprimeUnEtudiant(idEtudiant);

	}

	public Etudiant searchEtudiant(String nomEtudiant) {
		return iEtudiantService.chercherUnetudiantParSonNom(nomEtudiant);
	}
	
	public Etudiant searchEtudiantById(long idEtudiant) {
		return iEtudiantService.chercherUnEtudiantParSonId(idEtudiant);
	}

}
