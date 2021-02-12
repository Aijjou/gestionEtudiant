package fr.formation.afpa;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.formation.afpa.model.Note;

public class NoteTableModel extends AbstractTableModel {

	String[] colonnes = new String[] { "idNote", "Matiere", "Note", "Date" };

	List<Note> notes = new ArrayList<>();

	@Override
	public String getColumnName(int index) {

		return colonnes[index];
	}

	@Override
	public int getRowCount() {

		return notes.size();
	}

	@Override
	public int getColumnCount() {

		return colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Note note = notes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return note.getId();
		case 1:
			return note.getEMatiere();
		case 2:
			return note.getValeurNote();
		case 3:
			return formatter.format(note.getDate());
		}
		return null;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
