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

import fr.formation.afpa.model.Etudiant;

//import medel.Contact;

public class ContactTablePanel extends JPanel{
	
	private JTable table;
	private ContactTableModel contactTableModel;
	
	private JButton modifierButton;
	private JButton deleteButton;
	private JButton afficheButton;
	
	private JPanel buttonsPanel;
	
	public ContactTablePanel() {
		/**
		 * Specification de la taille du panel
		 */
		Dimension dimension=getPreferredSize();
		dimension.width=350;
		setPreferredSize(dimension);
		dimension.width=250;
		setMinimumSize(dimension);
		
		/**
		 * L'ajout du model dans la table
		 */
		table=new JTable();
		contactTableModel=new ContactTableModel();
		table.setModel(contactTableModel);
		
		modifierButton=new JButton("modifier");
		deleteButton=new JButton("Delete");
		afficheButton=new JButton("Affiche");
		
		/**
		 * Buttons Panel
		 */
		buttonsPanel=new JPanel();
		
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		buttonsPanel.add(modifierButton);
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(afficheButton);
		
		/**
		 * Pour centrer les informations
		 */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( DefaultTableCellRenderer.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		/**
		 * Le layout manager du panel
		 */
		setLayout(new BorderLayout());
		/**
		 * L'ajout de la table dans le panel
		 */
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void setData(List<Etudiant> etudiants) {
		contactTableModel.setEtudiants(etudiants);
	}

	public void refresh() {
		contactTableModel.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public ContactTableModel getContactTableModel() {
		return contactTableModel;
	}

	public JButton getModifierButton() {
		return modifierButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getAfficheButton() {
		return afficheButton;
	}

	public void setAfficheButton(JButton afficheButton) {
		this.afficheButton = afficheButton;
	}

}
