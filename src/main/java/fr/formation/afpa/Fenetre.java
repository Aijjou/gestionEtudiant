package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import controllers.ControllerEntete;
import controllers.ControllerEtudiant;
import controllers.ControllerGeneral;
import controllers.ControllerImage;

import controllers.ControllerTable;



public class Fenetre extends JFrame{
	
	private EntetePanel entetePanel;
	private ContactTablePanel contactTablePanel;
	private ContactDialog contactDialog;
	private EtudiantAffiche etudiantAffiche;
	private ControllerGeneral controleurGeneral;
	private ControllerEntete controllerEntete;
	private ControllerEtudiant controllerEtudiant;
	private ControllerTable controllerTableEtudiant;
	private ControllerImage controllerImage;
	
	public Fenetre() {
		
		this.setTitle("Gestion des etudiants");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,400);
		/**
		 * Pour centrer la fenetre dans le screen
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		/**
		 * L'instanciation des panels
		 */
		entetePanel=new EntetePanel();
		contactTablePanel=new ContactTablePanel();
		contactDialog=new ContactDialog(this);
		etudiantAffiche=new EtudiantAffiche(this);
		
		controleurGeneral=new ControllerGeneral();
		controllerImage = new ControllerImage(this);
		controllerEntete=new ControllerEntete(this);
		controllerEtudiant=new ControllerEtudiant(this);
		controllerTableEtudiant=new ControllerTable(this);
	
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
		entetePanel.getChercherContactItem().addActionListener(controllerEntete);
		
		contactDialog.getCancelButton().addActionListener(controllerEtudiant);
		contactDialog.getOkButton().addActionListener(controllerEtudiant);
		contactDialog.getPhotoButton().addActionListener(controllerImage);
		
		contactTablePanel.getModifierButton().addActionListener(controllerTableEtudiant);
		contactTablePanel.getDeleteButton().addActionListener(controllerTableEtudiant);
		contactTablePanel.getAfficheButton().addActionListener(controllerTableEtudiant);
		
	
		
		
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

	public ContactTablePanel getContactTablePanel() {
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

}
