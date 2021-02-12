package fr.formation.afpa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.Comparator;
import java.util.Date;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.NoteTableModel;
import fr.formation.afpa.model.EMatiere;
import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.model.Note;

public class ControllerNoteEtudiant implements ActionListener {

	Fenetre fenetre;
	Long idEtudiantLong;
	Etudiant etudiant;
	Note note;

	public ControllerNoteEtudiant(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getNoteEtudiantAffiche().getCancelButton())) {

			System.out.println("fin");
			fenetre.getNoteEtudiantAffiche().setVisible(false);

		} else if (e.getSource().equals(fenetre.getNoteEtudiantAffiche().getValidationButton())) {
			idEtudiantLong = Long.parseLong(fenetre.getNoteEtudiantAffiche().getId().getText());
			etudiant = fenetre.getControllerGeneral().iEtudiantService.chercherUnEtudiantParSonId(idEtudiantLong);

			EMatiere matiere = (EMatiere) fenetre.getNoteEtudiantAffiche().getjComboBoxMatiere().getSelectedItem();

			Date date = (Date) fenetre.getNoteEtudiantAffiche().getDatePicker().getModel().getValue();

			Integer valeur = Integer.parseInt(fenetre.getNoteEtudiantAffiche().getNoteTextField().getText());

			note = new Note(matiere, valeur, date);

			if (etudiant.getNotes().isEmpty()) {
				etudiant.getNotes().add(note);
			} else {

				for (int i = 0; i < etudiant.getNotes().size(); i++) {

					if (note.getId() == etudiant.getNotes().get(i).getId()) {

						long id;
						try {
							id = etudiant.getNotes().stream().max(Comparator.comparingLong(Note::getId))
									.orElseThrow(NoSuchFieldException::new).getId();
							note.setId(id + 1);
							System.out.println(note);
							etudiant.getNotes().add(note);
							break;

						} catch (NoSuchFieldException e1) {

							e1.printStackTrace();
						}

					} else {
						etudiant.getNotes().add(note);
						break;

					}
				}

			}

			etudiant = fenetre.getControllerGeneral().iEtudiantService.modifierEtudiant(etudiant);
			fenetre.getNoteEtudiantAffiche().getNoteTablePanel().setData(etudiant.getNotes());
			fenetre.getNoteEtudiantAffiche().getNoteTablePanel().refresh();
		}
	}

}