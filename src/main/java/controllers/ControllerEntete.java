package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.formation.afpa.Fenetre;

public class ControllerEntete implements ActionListener {

	Fenetre fenetre;

	public ControllerEntete(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getEntetePanel().getExitItem())) {
			int respone = JOptionPane.showConfirmDialog(fenetre.getEntetePanel(),
					"Voulez-vous vraiment quiter l'application", "Confirmer le quit", JOptionPane.OK_CANCEL_OPTION);
			if (respone == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource().equals(fenetre.getEntetePanel().getAjouterContactItem())) {
			fenetre.getContactDialog().getOkButton().setText("Ajouter");
			fenetre.getContactDialog().getOkButton().setActionCommand("Ajout");
			fenetre.getContactDialog().setVisible(true);
		} else if (e.getSource().equals(fenetre.getEntetePanel().getChercherContactItem())) {
			fenetre.getContactRechercheDialog().setVisible(true);
		}

	}

}
