package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerTable implements ActionListener {

	Fenetre fenetre;

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
						"Voulez-vous vraiment supprimé le contact en question", "Confirmer la modification",
						JOptionPane.OK_CANCEL_OPTION);
				if (respone == JOptionPane.OK_OPTION) {
					fenetre.getControllerGeneral().supprimerUnEtudian(etudiant.getId());
					fenetre.getContactTablePanel().setData(fenetre.getControllerGeneral().getAllEtudiants());
					fenetre.getContactTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le contact a été supprimé avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (e.getSource().equals(fenetre.getContactTablePanel().getModifierButton())) {
				fenetre.getContactDialog().getNomTextField().setText(etudiant.getNomString());
				fenetre.getContactDialog().getPrenomTextField().setText(etudiant.getPrenomString());
				fenetre.getContactDialog().getMotDePasse().setText(etudiant.getMotDePasseString());
				fenetre.getContactDialog().getOkButton().setText("Modifier");
				fenetre.getContactDialog().getOkButton().setActionCommand("Modification");
				fenetre.getContactDialog().setVisible(true);
//				int respone = JOptionPane.showConfirmDialog(fenetre,
//						"Voulez-vous vraiment modifier le contact en question", "Confirmer la modification",
//						JOptionPane.OK_CANCEL_OPTION);
//				if (respone == JOptionPane.OK_OPTION) {
//					fenetre.getControllerGeneral().supprimerUnEtudian(etudiant.getId());
//					fenetre.getContactTablePanel().setData(fenetre.getControllerGeneral().getAllEtudiants());
//					fenetre.getContactTablePanel().refresh();
//					JOptionPane.showMessageDialog(fenetre, "Le contact a été supprimé avec succes", "Succes",
//							JOptionPane.INFORMATION_MESSAGE);
//				}

			}
		}
	}

}