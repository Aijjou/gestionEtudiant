package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class EtudiantAffiche extends JDialog{
	


	private JLabel nomLabel, prenomLabel, modePasseLabel, selectPhotoLabel, nom, prenom, mdp, dateNaissance, naissance;
	private JButton cancelButton;
	private ImageIcon icon;

	
	public EtudiantAffiche(JFrame parent) {
		super(parent, "Resultat", false);
		
		
		nomLabel=new JLabel(" ");
		prenomLabel=new JLabel(" ");
		modePasseLabel=new JLabel(" ");
		dateNaissance=new JLabel(" ");
		
		
		nom =new JLabel("NOM : ");
		prenom=new JLabel("PRENOM : ");
		mdp=new JLabel("Mot de Passe : ");
		naissance=new JLabel("Date de Naissance : ");
		selectPhotoLabel=new JLabel(" ");
		icon = new ImageIcon("photo.png");
		
		cancelButton=new JButton("Cancel");
	
		
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
		JPanel photoPanel = new JPanel();
		
		
		int space=15;
		Border titleBorder=BorderFactory.createTitledBorder("Affiche un etudiant");
		Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder2=BorderFactory.createTitledBorder("Photo");
		Border spaceBorder2=BorderFactory.createEmptyBorder(space, space, space, space);
		
		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		photoPanel.setLayout(new GridBagLayout());
		photoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder2, titleBorder2));
		
		/**
		 * Buttons layout
		 */
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		GridBagConstraints gc=new GridBagConstraints();
		Insets rightPadding=new Insets(0, 0, 0, 15);
		Insets noPadding=new Insets(0, 0, 0, 0);
		
		gc.fill=GridBagConstraints.NONE;
			
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.NORTH;
		gc.insets=rightPadding;
		photoPanel.add(selectPhotoLabel, gc);
		
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=rightPadding;
		photoPanel.add(new JLabel(icon), gc);
		
		
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(nom, gc);
		

		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=noPadding;
		controlsPannel.add(nomLabel, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(prenom, gc);
	
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=noPadding;
		controlsPannel.add(prenomLabel, gc);
		
		
		/**
		 * Next row
		 */
		
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(naissance, gc);
		

		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=noPadding;
		controlsPannel.add(dateNaissance, gc);
		
		
		
		
		gc.weightx=1;
		gc.weighty=1;
		
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(mdp, gc);
	
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=noPadding;
		controlsPannel.add(modePasseLabel, gc);
		
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		gc.gridy++;
		
	
		gc.gridx++;
		buttonsPanel.add(cancelButton, gc);
		
		setLayout(new BorderLayout());
		
		add(controlsPannel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		add(photoPanel, BorderLayout.EAST);
	}

	public JLabel getNomLabel() {
		return nomLabel;
	}

	public void setNomLabel(JLabel nomLabel) {
		this.nomLabel = nomLabel;
	}

	public JLabel getPrenomLabel() {
		return prenomLabel;
	}

	public void setPrenomLabel(JLabel prenomLabel) {
		this.prenomLabel = prenomLabel;
	}

	public JLabel getModePasseLabel() {
		return modePasseLabel;
	}

	public void setModePasseLabel(JLabel modePasseLabel) {
		this.modePasseLabel = modePasseLabel;
	}

	public JLabel getSelectPhotoLabel() {
		return selectPhotoLabel;
	}

	public void setSelectPhotoLabel(JLabel selectPhotoLabel) {
		this.selectPhotoLabel = selectPhotoLabel;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public JLabel getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(JLabel dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public JLabel getNaissance() {
		return naissance;
	}

	public void setNaissance(JLabel naissance) {
		this.naissance = naissance;
	}






}
