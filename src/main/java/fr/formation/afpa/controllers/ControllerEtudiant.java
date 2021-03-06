package fr.formation.afpa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.formation.afpa.ContactDialog;
import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerEtudiant implements ActionListener {

	static Fenetre fenetre;
	Etudiant etudiant;
	File selectedFile;

	ControllerImage controllerImage = new ControllerImage(fenetre);

	public ControllerEtudiant(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	public static void changed() {
		if (!fenetre.getContactDialog().getNomTextField().getText().isEmpty()
				&& fenetre.getContactDialog().getNomTextField().getText().length() > 4
				&& !fenetre.getContactDialog().getPrenomTextField().getText().isEmpty()
				&& fenetre.getContactDialog().getPrenomTextField().getText().length() > 0
				&& !fenetre.getContactDialog().getMotDePasse().getText().isEmpty()
				&& fenetre.getContactDialog().getMotDePasse().getText().length() > 4 && fenetre.getContactDialog().getDatePicker().getSize()!=null)
			fenetre.getContactDialog().getOkButton().setEnabled(true);
		else {
			fenetre.getContactDialog().getOkButton().setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getContactDialog().getCancelButton())) {
			fenetre.getContactDialog().setVisible(false);

		} else if (e.getSource().equals(fenetre.getContactDialog().getOkButton())) {

			String nom = fenetre.getContactDialog().getNomTextField().getText();
			String prenom = fenetre.getContactDialog().getPrenomTextField().getText();
			String mdpString = fenetre.getContactDialog().getMotDePasse().getText();
			String pathString = controllerImage.recupPath();
			Date selectedDate = (Date) fenetre.getContactDialog().getDatePicker().getModel().getValue();
			etudiant = new Etudiant(nom, prenom, mdpString, pathString, selectedDate);

			if (fenetre.getContactDialog().getOkButton().getActionCommand().equals("Ajout")) {

				fenetre.getControllerGeneral().addEtudiant(etudiant);
				fenetre.getContactTablePanel().setData(fenetre.getControllerGeneral().iEtudiantService.listEtudiant());
				fenetre.getContactTablePanel().refresh();
				JOptionPane.showMessageDialog(fenetre, "Le contact a été ajouté avec succes", "Succes",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}

}
