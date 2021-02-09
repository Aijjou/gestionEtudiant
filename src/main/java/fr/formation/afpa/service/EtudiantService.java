package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.dao.EtudiantDaoFile;
import fr.formation.afpa.dao.IEtudiantDao;
import fr.formation.afpa.model.Etudiant;

public class EtudiantService implements IEtudiantService {
	
	private IEtudiantDao dao = new EtudiantDaoFile();

	public List<Etudiant> listEtudiant() {
		return dao.getAll();
	}

	public String ajouterEtudiant(Etudiant e) {
		return dao.add(e);
	}

	public Etudiant modifierEtudiant(Etudiant e) {
		return dao.update(e);
	}
	
	
	public void supprimeUnEtudiant(long idEtudiant) {
		dao.delete(idEtudiant);
		
	}
	
	
	public Etudiant chercherUnetudiantParSonNom(String nom) {
		
		
		return dao.getEtudiantByName(nom);
	}

	@Override
	public Etudiant chercherUnEtudiantParSonId(long idEtudiant) {
		//
		return dao.getEtudiantById(idEtudiant);
	}

}
