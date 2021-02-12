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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.formation.afpa.model.DateLabelFormatter;
import fr.formation.afpa.model.EMatiere;

public class NoteEtudiantAffiche extends JDialog {

	private JLabel dateNote, matiereLabel, noteLabel, nom, prenom, id, listeJLabel;
	private JButton cancelButton, validationButton;
	private JTextField textFieldNomField, noteTextField;
	private JComboBox jComboBoxMatiere;
	private JTable table;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private NoteTablePanel noteTablePanel;
	private JScrollPane sp;

	public NoteEtudiantAffiche(JFrame parent) {
		super(parent, "Resultat", false);

		nom = new JLabel(" ");
		prenom = new JLabel(" ");
		id = new JLabel(" ");
		listeJLabel = new JLabel(" ");
		dateNote = new JLabel("Date de la note : ");
		matiereLabel = new JLabel("Selectionner une matiere : ");
		noteLabel = new JLabel("Saisir une note:");
		jComboBoxMatiere = new JComboBox(EMatiere.values());

		textFieldNomField = new JTextField(12);
		noteTextField = new JTextField(5);

		cancelButton = new JButton("Cancel");
		validationButton = new JButton("Validation");

		noteTablePanel = new NoteTablePanel();

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

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
		JPanel panelNote = new JPanel();

		JPanel infosEtudiantJPanel = new JPanel(new BorderLayout());

		Border border = prenom.getBorder();
		Border margin = new EmptyBorder(0, 0, 0, 10);
		prenom.setBorder(new CompoundBorder(border, margin));
		infosEtudiantJPanel.add(prenom, BorderLayout.WEST);
		infosEtudiantJPanel.add(nom, BorderLayout.EAST);

		JPanel listeNoteEtudiantPanel = new JPanel();

		int space = 15;
		Border titleBorder = BorderFactory.createTitledBorder("Ajouter une note");
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder2 = BorderFactory.createTitledBorder("Nom - Prenom");
		Border spaceBorder2 = BorderFactory.createEmptyBorder(space, space, space, space);

		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		panelNote.setLayout(new GridBagLayout());
		panelNote.setBorder(BorderFactory.createCompoundBorder(spaceBorder2, titleBorder2));

		/**
		 * Buttons layout
		 */
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		GridBagConstraints gc = new GridBagConstraints();
		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);

		gc.fill = GridBagConstraints.NONE;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = rightPadding;
		panelNote.add(infosEtudiantJPanel, gc);

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = rightPadding;
		controlsPannel.add(dateNote, gc);
		gc.gridy++;
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
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = rightPadding;
		controlsPannel.add(matiereLabel, gc);
		gc.gridy++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(jComboBoxMatiere, gc);

		/**
		 * Next row
		 */

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = rightPadding;
		controlsPannel.add(noteLabel, gc);
		gc.gridy++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPannel.add(noteTextField, gc);

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;

		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPannel.add(validationButton, gc);

		/**
		 * Next row
		 */
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridy++;

		gc.gridx++;
		buttonsPanel.add(cancelButton, gc);

		setLayout(new BorderLayout());

		add(controlsPannel, BorderLayout.WEST);
		add(buttonsPanel, BorderLayout.SOUTH);
		add(panelNote, BorderLayout.NORTH);
		add(noteTablePanel, BorderLayout.CENTER);
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getValidationButton() {
		return validationButton;
	}

	public void setValidationButton(JButton validationButton) {
		this.validationButton = validationButton;
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	public JLabel getPrenom() {
		return prenom;
	}

	public void setPrenom(JLabel prenom) {
		this.prenom = prenom;
	}

	public JTextField getTextFieldNomField() {
		return textFieldNomField;
	}

	public void setTextFieldNomField(JTextField textFieldNomField) {
		this.textFieldNomField = textFieldNomField;
	}

	public JTextField getNoteTextField() {
		return noteTextField;
	}

	public void setNoteTextField(JTextField noteTextField) {
		this.noteTextField = noteTextField;
	}

	public JComboBox getjComboBoxMatiere() {
		return jComboBoxMatiere;
	}

	public void setjComboBoxMatiere(JComboBox jComboBoxMatiere) {
		this.jComboBoxMatiere = jComboBoxMatiere;
	}

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public NoteTablePanel getNoteTablePanel() {
		return noteTablePanel;
	}

	public void setNoteTablePanel(NoteTablePanel noteTablePanel) {
		this.noteTablePanel = noteTablePanel;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public JLabel getListeJLabel() {
		return listeJLabel;
	}

	public void setListeJLabel(JLabel listeJLabel) {
		this.listeJLabel = listeJLabel;
	}

}
