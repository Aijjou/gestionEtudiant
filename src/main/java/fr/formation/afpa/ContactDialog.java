package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ContactDialog extends JDialog{
	
	private JLabel nomLabel, prenomLabel, modePasseLabel, selectPhotoLabel;
	private JTextField nomTextField, prenomTextField;
	private JPasswordField motDePasse;
	private JButton okButton, cancelButton, photoButton;
	private JFileChooser fileChooser;
	
	public ContactDialog(JFrame parent) {
		super(parent, "Etudiant", false);
		
		nomLabel=new JLabel("Nom");
		prenomLabel=new JLabel("Prenom");
		modePasseLabel=new JLabel("Mot de passe");
		selectPhotoLabel = new JLabel("Selectionner une photo");
		
		
		nomTextField=new JTextField(15);
		prenomTextField=new JTextField(15);
		motDePasse = new JPasswordField(15);
		

		
		okButton=new JButton("Ok");
		cancelButton=new JButton("Cancel");
		photoButton=new JButton("Photo");
		
		setLayout(new GridBagLayout());
		
		layoutControls();
        
		
		setSize(700, 400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setUndecorated(true);
	}
	
	private void layoutControls() {
		JPanel controlsPannel=new JPanel();
		JPanel buttonsPanel=new JPanel();
		
		int space=15;
		Border titleBorder=BorderFactory.createTitledBorder("Ajouter un etudiant");
		Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);
		
		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		/**
		 * Buttons layout
		 */
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		GridBagConstraints gc=new GridBagConstraints();
		Insets rightPadding=new Insets(0, 0, 0, 15);
		Insets noPadding=new Insets(0, 0, 0, 0);
		
		gc.fill=GridBagConstraints.NONE;
		/**
		 * First row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(nomLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(nomTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(prenomLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(prenomTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(modePasseLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(motDePasse, gc);
		
		
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(selectPhotoLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(photoButton, gc);
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		gc.gridy++;
		
		gc.gridx=0;
		buttonsPanel.add(okButton, gc);
		gc.gridx++;
		buttonsPanel.add(cancelButton, gc);
		
		setLayout(new BorderLayout());
		add(controlsPannel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public JTextField getNomTextField() {
		return nomTextField;
	}

	public JTextField getPrenomTextField() {
		return prenomTextField;
	}
	


	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JPasswordField getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(JPasswordField motDePasse) {
		this.motDePasse = motDePasse;
	}

	public JButton getPhotoButton() {
		return photoButton;
	}

	public void setPhotoButton(JButton photoButton) {
		this.photoButton = photoButton;
	}

}
