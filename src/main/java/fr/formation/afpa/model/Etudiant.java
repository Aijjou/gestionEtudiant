package fr.formation.afpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Etudiant implements Serializable {

	
	private static long serialVersionUID = 0;
	private long id;
	String nomString;
	String prenomString;
	String motDePasseString;
	String imageString; 
	List<Integer> notes;

	public Etudiant(String nomString, String prenomString, String motDePasseString, List<Integer> notes) {
		super();
		serialVersionUID += 1;
		this.id = serialVersionUID;
		this.nomString = nomString;
		this.prenomString = prenomString;
		this.motDePasseString = motDePasseString;
		this.notes = new ArrayList<>();
	}
	public Etudiant() {
		serialVersionUID += 1;
		this.id = serialVersionUID;
	}

	public Etudiant(String nomString, String prenomString, String motDePasseString, String image) {
		super();
		serialVersionUID += 1;
		this.id = serialVersionUID;
		this.nomString = nomString;
		this.prenomString = prenomString;
		this.motDePasseString = motDePasseString;
		this.imageString = image;
		this.notes = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "Etudiant [nomString=" + nomString + ", prenomString=" + prenomString + "]";
	}

	public Double getMoyenne() {
		return (double) (notes.stream().mapToInt(Integer::intValue).sum() / notes.stream().count());
	}

	public String getNomString() {
		return nomString;
	}

	public void setNomString(String nomString) {
		this.nomString = nomString;
	}

	public String getPrenomString() {
		return prenomString;
	}

	public void setPrenomString(String prenomString) {
		this.prenomString = prenomString;
	}

	public String getMotDePasseString() {
		return motDePasseString;
	}

	public void setMotDePasseString(String motDePasseString) {
		this.motDePasseString = motDePasseString;
	}

	public List<Integer> getNotes() {
		return notes;
	}

	public void setNotes(List<Integer> notes) {
		this.notes = notes;
	}

	public long getId() {
		return id;
	}
	public String getImageString() {
		return imageString;
	}
	public void setImageString(String imageString) {
		this.imageString = imageString;
	}


}
