package fr.formation.afpa.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerTable implements ActionListener {

	private Fenetre fenetre;
	private BufferedImage image;
	private long idEtudiant;
	private SimpleDateFormat formatter;
	private ControllerModification controllerModification;

	public ControllerTable(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowIndex = fenetre.getContactTablePanel().getTable().getSelectedRow();
		if (rowIndex == -1) {
			// message d'erreur
		} else {
			Etudiant etudiant = fenetre.getControllerGeneral().getAllEtudiants().get(rowIndex);

			if (e.getSource().equals(fenetre.getContactTablePanel().getDeleteButton())) {
				int respone = JOptionPane.showConfirmDialog(fenetre,
						"Voulez-vous vraiment supprimé l'etudiant en question", "Confirmer la suppression,",
						JOptionPane.OK_CANCEL_OPTION);
				if (respone == JOptionPane.OK_OPTION) {
					fenetre.getControllerGeneral().supprimerUnEtudian(etudiant.getId());
					fenetre.getContactTablePanel().setData(fenetre.getControllerGeneral().getAllEtudiants());
					fenetre.getContactTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le contact a été supprimé avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (e.getSource().equals(fenetre.getContactTablePanel().getModifierButton())) {
				fenetre.getContactDialog().getOkButton().setVisible(false);
				fenetre.getContactDialog().getModifierButton().setVisible(true);
				int respone = JOptionPane.showConfirmDialog(fenetre,
						"Voulez-vous vraiment modifier l'etudiant en question", "Confirmer la Modification,",
						JOptionPane.OK_CANCEL_OPTION);
				if (respone == JOptionPane.OK_OPTION) {
					controllerModification = new ControllerModification(fenetre, etudiant.getId());
					formatter = new SimpleDateFormat("dd/MM/yyyy");
					fenetre.getContactDialog().setVisible(true);
					fenetre.getContactDialog().getNomTextField().setText(etudiant.getNomString());
					fenetre.getContactDialog().getPrenomTextField().setText(etudiant.getPrenomString());
					fenetre.getContactDialog().getMotDePasse().setText(etudiant.getMotDePasseString());
					fenetre.getContactDialog().getDatePicker()
							.setToolTipText(formatter.format(etudiant.getDatenaissance()));

				}

			} else if (e.getSource().equals(fenetre.getContactTablePanel().getAfficheButton())) {
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				ImageIcon imageIcon = new ImageIcon(etudiant.getImageString());
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(250, 300, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);

				fenetre.getControllerGeneral().searchEtudiantById(etudiant.getId());
				fenetre.getEtudiantAffiche().getNomLabel().setText(etudiant.getNomString());
				fenetre.getEtudiantAffiche().getPrenomLabel().setText(etudiant.getPrenomString());
				fenetre.getEtudiantAffiche().getModePasseLabel().setText(etudiant.getMotDePasseString());
				fenetre.getEtudiantAffiche().getDateNaissance().setText(formatter.format(etudiant.getDatenaissance()));
				fenetre.getEtudiantAffiche().getSelectPhotoLabel().setIcon(imageIcon);
				fenetre.getEtudiantAffiche().setVisible(true);

			}
			else if (e.getSource().equals(fenetre.getContactTablePanel().getAfficheNoteButton())) {
				fenetre.getControllerGeneral().searchEtudiantById(etudiant.getId());	
				fenetre.getNoteEtudiantAffiche().getId().setText(etudiant.getId().toString());
				fenetre.getNoteEtudiantAffiche().getNom().setText(etudiant.getNomString());
				fenetre.getNoteEtudiantAffiche().getPrenom().setText(etudiant.getPrenomString());
				fenetre.getNoteEtudiantAffiche().getNoteTablePanel().setData(etudiant.getNotes());
				fenetre.getNoteEtudiantAffiche().getValidationButton().setActionCommand("Valid");
				fenetre.getNoteEtudiantAffiche().setVisible(true);

			}
		}
	}

}
