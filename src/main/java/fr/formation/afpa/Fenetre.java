package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import fr.formation.afpa.controllers.ControllerAfficheEtudiant;

import fr.formation.afpa.controllers.ControllerEntete;
import fr.formation.afpa.controllers.ControllerEtudiant;
import fr.formation.afpa.controllers.ControllerGeneral;
import fr.formation.afpa.controllers.ControllerImage;
import fr.formation.afpa.controllers.ControllerModification;
import fr.formation.afpa.controllers.ControllerNoteEtudiant;
import fr.formation.afpa.controllers.ControllerTable;

public class Fenetre extends JFrame {

	private EntetePanel entetePanel;
	private EtudiantTablePanel contactTablePanel;
	private ContactDialog contactDialog;
	private EtudiantAffiche etudiantAffiche;
	private NoteEtudiantAffiche noteEtudiantAffiche;
	private NoteTablePanel noteTablePanel;
	private ControllerGeneral controleurGeneral;
	private ControllerEntete controllerEntete;
	private ControllerEtudiant controllerEtudiant;
	private ControllerTable controllerTableEtudiant;
	private ControllerImage controllerImage;
	private ControllerAfficheEtudiant controllerAfficheEtudiant;
	private ControllerModification controllerModification;
	private ControllerNoteEtudiant controllerNoteEtudiant;
	
	

	public Fenetre() {

		this.setTitle("Gestion des etudiants");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 400);
		/**
		 * Pour centrer la fenetre dans le screen
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		/**
		 * L'instanciation des panels
		 */
		entetePanel = new EntetePanel();
		contactTablePanel = new EtudiantTablePanel();
		contactDialog = new ContactDialog(this);
		etudiantAffiche = new EtudiantAffiche(this);
		noteEtudiantAffiche = new NoteEtudiantAffiche(this);
		noteTablePanel =  new NoteTablePanel();

		controleurGeneral = new ControllerGeneral();
		controllerImage = new ControllerImage(this);
		controllerEntete = new ControllerEntete(this);
		controllerEtudiant = new ControllerEtudiant(this);
		controllerTableEtudiant = new ControllerTable(this);
		controllerAfficheEtudiant = new ControllerAfficheEtudiant(this);
		controllerModification = new ControllerModification(this);
		controllerNoteEtudiant = new ControllerNoteEtudiant(this);
	

		/**
		 * L'ajout de donnees dans la table
		 */
		contactTablePanel.setData(controleurGeneral.getAllEtudiants());

		contactTablePanel.refresh();

		/**
		 * Les evenements
		 */
		entetePanel.getExitItem().addActionListener(controllerEntete);
		entetePanel.getAjouterContactItem().addActionListener(controllerEntete);
		

		contactDialog.getCancelButton().addActionListener(controllerEtudiant);

		contactDialog.getOkButton().addActionListener(controllerEtudiant);

		contactDialog.getModifierButton().addActionListener(controllerModification);

		contactDialog.getPhotoButton().addActionListener(controllerImage);

		contactTablePanel.getModifierButton().addActionListener(controllerTableEtudiant);
		contactTablePanel.getDeleteButton().addActionListener(controllerTableEtudiant);
		contactTablePanel.getAfficheButton().addActionListener(controllerTableEtudiant);
		contactTablePanel.getAfficheNoteButton().addActionListener(controllerTableEtudiant);
		
		

		etudiantAffiche.getCancelButton().addActionListener(controllerAfficheEtudiant);
		

		noteEtudiantAffiche.getCancelButton().addActionListener(controllerNoteEtudiant);
		noteEtudiantAffiche.getValidationButton().addActionListener(controllerNoteEtudiant);

		/**
		 * Le layout manager de la fenetre
		 */
		this.setLayout(new BorderLayout());

		/**
		 */
		/**
		 * L'ajout des panels dans le layout principale
		 */
		this.add(entetePanel, BorderLayout.NORTH);
		this.add(contactTablePanel, BorderLayout.CENTER);

		/**
		 * Rendre la fenetre visible
		 */
		this.setVisible(true);
	}

	public EntetePanel getEntetePanel() {
		return entetePanel;
	}

	public EtudiantTablePanel getContactTablePanel() {
		return contactTablePanel;
	}

	public ContactDialog getContactDialog() {
		return contactDialog;
	}

	public EtudiantAffiche getEtudiantAffiche() {
		return etudiantAffiche;
	}

	public ControllerGeneral getControllerGeneral() {
		return controleurGeneral;
	}

	public NoteEtudiantAffiche getNoteEtudiantAffiche() {
		return noteEtudiantAffiche;
	}

	public void setNoteEtudiantAffiche(NoteEtudiantAffiche noteEtudiantAffiche) {
		this.noteEtudiantAffiche = noteEtudiantAffiche;
	}

}
