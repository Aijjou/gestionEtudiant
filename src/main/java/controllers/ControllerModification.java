package controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.JOptionPane;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerModification implements ActionListener {

	static Fenetre fenetre;
	Etudiant etudiant;
	File selectedFile;
	static long id;

	ControllerImage controllerImage = new ControllerImage(fenetre);

	public ControllerModification(Fenetre fenetre, long idEtudiant) {
		this.fenetre = fenetre;
		this.id = idEtudiant;
	}

	public ControllerModification(Fenetre fenetre) {
		this.fenetre = fenetre;

	}
	
	
	public static void changed() {
		if (!fenetre.getContactDialog().getNomTextField().getText().isEmpty()
				&& fenetre.getContactDialog().getNomTextField().getText().length() > 4
				&& !fenetre.getContactDialog().getPrenomTextField().getText().isEmpty()
				&& fenetre.getContactDialog().getPrenomTextField().getText().length() > 0
				&& !fenetre.getContactDialog().getMotDePasse().getText().isEmpty()
				&& fenetre.getContactDialog().getMotDePasse().getText().length() > 4) {
			fenetre.getContactDialog().getModifierButton().setEnabled(true);
		}else {
			fenetre.getContactDialog().getModifierButton().setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getContactDialog().getModifierButton())) {

			etudiant = fenetre.getControllerGeneral().iEtudiantService.chercherUnEtudiantParSonId(id);

			String nom = fenetre.getContactDialog().getNomTextField().getText();
			String prenom = fenetre.getContactDialog().getPrenomTextField().getText();
			String mdpString = fenetre.getContactDialog().getMotDePasse().getText();
			String pathString = controllerImage.recupPath();
			Date selectedDate = (Date) fenetre.getContactDialog().getDatePicker().getModel().getValue();

			etudiant.setNomString(nom);
			etudiant.setPrenomString(prenom);
			etudiant.setMotDePasseString(mdpString);
			etudiant.setImageString(pathString);
			etudiant.setDatenaissance(selectedDate);

			fenetre.getControllerGeneral().iEtudiantService.modifierEtudiant(etudiant);
			fenetre.getContactTablePanel().setData(fenetre.getControllerGeneral().iEtudiantService.listEtudiant());
			fenetre.getContactTablePanel().refresh();
			JOptionPane.showMessageDialog(fenetre, "L'etudiant a été modifié avec succes", "Succes",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
