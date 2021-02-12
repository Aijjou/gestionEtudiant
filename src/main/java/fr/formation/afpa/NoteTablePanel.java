package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fr.formation.afpa.model.EMatiere;
import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.model.Note;

public class NoteTablePanel extends JPanel {

	Note note = new Note();

	private JTable table;
	private NoteTableModel noteTableModel;

	private JButton modifierButton;
	private JButton deleteButton;
	private JButton afficheButton;
	

	private JPanel buttonsPanel;

	public NoteTablePanel() {
		/**
		 * Specification de la taille du panel
		 */
		Dimension dimension = getPreferredSize();
		dimension.width = 400;
		setPreferredSize(dimension);
		dimension.width = 400;
		setMinimumSize(dimension);

		/**
		 * L'ajout du model dans la table
		 */
		table = new JTable();
		noteTableModel = new NoteTableModel();
		table.setModel(noteTableModel);
		 

		/**
		 * Buttons Panel
		 */
		buttonsPanel = new JPanel();

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


	

		/**
		 * Pour centrer les informations
		 */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		/**
		 * Le layout manager du panel
		 */
		setLayout(new BorderLayout());
		/**
		 * L'ajout de la table dans le panel
		 */
		add(new JScrollPane(table), BorderLayout.CENTER);
//		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void setData(List<Note> notes) {
		noteTableModel.setNotes(notes);
	}

	public void refresh() {
		noteTableModel.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public NoteTableModel getNoteTableModel() {
		return noteTableModel;
	}

	public void setNoteTableModel(NoteTableModel noteTableModel) {
		this.noteTableModel = noteTableModel;
	}

	public JButton getModifierButton() {
		return modifierButton;
	}

	public void setModifierButton(JButton modifierButton) {
		this.modifierButton = modifierButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getAfficheButton() {
		return afficheButton;
	}

	public void setAfficheButton(JButton afficheButton) {
		this.afficheButton = afficheButton;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

}
