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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controllers.ControllerEtudiant;
import fr.formation.afpa.model.DateLabelFormatter;

public class ContactDialog extends JDialog {

	private JLabel nomLabel, prenomLabel, modePasseLabel, selectPhotoLabel, selectBirthDay;
	private JTextField nomTextField, prenomTextField;
	private JPasswordField motDePasse;
	private JButton okButton, cancelButton, photoButton, modifierButton;
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;

	public ContactDialog(JFrame parent) {
		super(parent, "Etudiant", false);

		nomLabel = new JLabel("Nom");
		prenomLabel = new JLabel("Prenom");
		modePasseLabel = new JLabel("Mot de passe");
		selectPhotoLabel = new JLabel("Selectionner une photo");
		selectBirthDay = new JLabel("Date de naissance");

		nomTextField = new JTextField(15);
		prenomTextField = new JTextField(15);
		motDePasse = new JPasswordField(15);

		nomTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void removeUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void insertUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

		});
		
		prenomTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void removeUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void insertUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

		});
		
		motDePasse.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void removeUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

			public void insertUpdate(DocumentEvent e) {
				ControllerEtudiant.changed();
			}

		});

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		
		okButton = new JButton("Ajouter");
		cancelButton = new JButton("Cancel");
		photoButton = new JButton("Photo");
		modifierButton = new JButton("Modifier");

		setLayout(new GridBagLayout());

		layoutControls();

		setSize(700, 400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setUndecorated(true);
	}

	private void layoutControls() {
		JPanel controlsPannel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border titleBorder = BorderFactory.createTitledBorder("Ajouter un etudiant");
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);

		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

		/**
		 * Buttons layout
		 */
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		GridBagConstraints gc = new GridBagConstraints();
		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);

		gc.fill = GridBagConstraints.NONE;
		/**
		 * First row
		 */
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(nomLabel, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(nomTextField, gc);

		/**
		 * Next row
		 */
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(prenomLabel, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(prenomTextField, gc);

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(selectBirthDay, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(datePicker, gc);

		/**
		 * Next row
		 */
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(modePasseLabel, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(motDePasse, gc);

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(selectPhotoLabel, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(photoButton, gc);
		/**
		 * Next row
		 */
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridy++;

		gc.gridx = 0;
		buttonsPanel.add(okButton, gc);
		gc.gridx++;
		buttonsPanel.add(cancelButton, gc);
		gc.gridx++;
		buttonsPanel.add(modifierButton, gc);

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

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public JButton getModifierButton() {
		return modifierButton;
	}

	public void setModifierButton(JButton modifierButton) {
		this.modifierButton = modifierButton;
	}

}
