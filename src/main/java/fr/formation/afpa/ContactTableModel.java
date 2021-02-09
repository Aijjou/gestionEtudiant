package fr.formation.afpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.service.EtudiantService;

public class ContactTableModel extends AbstractTableModel {

	/**
	 * Les colonnes a afficher
	 */
	String[] colonnes = new String[] { "idEtudiant", "nom", "prenom", "mdp", "image" };

	/**
	 * La liste des contacts
	 */


	
	List<Etudiant> etudiants = new ArrayList<>();

	@Override
	public String getColumnName(int index) {

		return colonnes[index];
	}

	@Override
	public int getColumnCount() {

		return colonnes.length;
	}

	@Override
	public int getRowCount() {

		return etudiants.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Etudiant etudiant = etudiants.get(row);
		switch (col) {
			case 0: return etudiant.getId();
			case 1: return etudiant.getNomString();
			case 2: return etudiant.getPrenomString();
			case 3: return etudiant.getMotDePasseString();
			case 4: return etudiant.getImageString();
			
		}
		return null;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}
