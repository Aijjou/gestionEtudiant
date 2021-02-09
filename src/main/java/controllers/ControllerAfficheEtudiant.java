package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.formation.afpa.Fenetre;

public class ControllerAfficheEtudiant implements ActionListener {

	Fenetre fenetre;

	public ControllerAfficheEtudiant(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getEtudiantAffiche().getCancelButton())) {
			fenetre.getEtudiantAffiche().setVisible(false);

		}

	}

}
