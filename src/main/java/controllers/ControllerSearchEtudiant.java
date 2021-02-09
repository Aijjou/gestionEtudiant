package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultListModel;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerSearchEtudiant implements ActionListener {

	Fenetre fenetre;

	public ControllerSearchEtudiant(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**
		 * Si on veut chercher(La fenetre principale)
		 */
		if (e.getSource().equals(fenetre.getContactRechercheDialog().getRechercherButton())) {
			String nomCherche = fenetre.getContactRechercheDialog().getNomTextField().getText();
			fenetre.getContactRechercheResultatDialog().getNomTextField().setText(nomCherche);
			fenetre.getContactRechercheResultatDialog().setVisible(true);
		}
		/**
		 * Si on veut Rechercher(Le dialog de recherche)
		 */
		else if (e.getSource().equals(fenetre.getContactRechercheResultatDialog().getRechercherButton())) {
			/**
			 * On recupere les donnees depuis le dialog
			 */
			String nomCherche = fenetre.getContactRechercheResultatDialog().getNomTextField().getText();

			Etudiant etudiant = fenetre.getControllerGeneral().searchEtudiant(nomCherche);

			DefaultListModel<String> modelHomophones = new DefaultListModel<>();
			modelHomophones.addElement(etudiant.getNomString());

			fenetre.getContactRechercheResultatDialog().getHomophonesList().setModel(modelHomophones);
			fenetre.getContactRechercheDialog().getNbHomophonesTextField().setText(modelHomophones.size()+"");

		}
		/**
		 * Si on veut quitter le dialog de recherche
		 */
		else if (e.getSource().equals(fenetre.getContactRechercheResultatDialog().getQuiterButton())) {
			fenetre.getContactRechercheResultatDialog().setVisible(false);
		}
	}

}
