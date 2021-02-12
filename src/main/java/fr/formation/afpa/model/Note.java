package fr.formation.afpa.model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  long count = 0;
	private long id;
	public Enum EMatiere; 
	private Integer valeurNote;
	private Date date;
	
	
	public Note() {
		
	}


	public Note(Enum eMatiere, Integer valeurNote, Date date) {
		super();
		this.count +=1;
		this.id = count;
		EMatiere = eMatiere;
		this.valeurNote = valeurNote;
		this.date = date;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Enum getEMatiere() {
		return EMatiere;
	}


	public void setEMatiere(Enum eMatiere) {
		EMatiere = eMatiere;
	}


	public Integer getValeurNote() {
		return valeurNote;
	}


	public void setValeurNote(Integer valeurNote) {
		this.valeurNote = valeurNote;
	}


	@Override
	public String toString() {
		return "Note [id=" + id + ", EMatiere=" + EMatiere + ", valeurNote=" + valeurNote + "]";
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
