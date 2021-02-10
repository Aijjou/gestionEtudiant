package fr.formation.afpa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.formation.afpa.Fenetre;
import fr.formation.afpa.model.Etudiant;

public class ControllerImage implements ActionListener {

	private JTextField filename = new JTextField(), dir = new JTextField();

	Fenetre fenetre;
	Etudiant etudiant;
	static File selectedFile;

	public ControllerImage(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(fenetre.getContactDialog().getPhotoButton())) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(fenetre.getContactDialog());
			if (result == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
				System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				recupPath();
			}
		}

	}

	public String recupPath() {
		System.out.println(this.selectedFile.getAbsolutePath());
		return this.selectedFile.getAbsolutePath();
	}

}
