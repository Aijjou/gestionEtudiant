package fr.formation.afpa.dao;

import java.util.List;

import fr.formation.afpa.model.Etudiant;

public interface IEtudiantDao {
	
	public List<Etudiant> getAll();
	
	public String add(Etudiant e);
	
	public Etudiant update(Etudiant e);
	
	public void delete(long idEtudiant);
	
	public Etudiant getEtudiantByName(String nom);
	
	public Etudiant getEtudiantById(long idEtudiant);
		
		
	
}
