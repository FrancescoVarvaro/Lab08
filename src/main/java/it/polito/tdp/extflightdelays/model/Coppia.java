package it.polito.tdp.extflightdelays.model;

public class Coppia {
	private int idPartenza;
	private int idArrivo;
	private int distanza; 
	
	public Coppia(int idPartenza, int idArrivo, int distanza) {
		this.idPartenza = idPartenza;
		this.idArrivo = idArrivo;
		this.distanza = distanza;
	}
	
	public int getdistanza() {
		return distanza;
	}

	public int getIdPartenza() {
		return idPartenza;
	}
	public void setIdPartenza(int idPartenza) {
		this.idPartenza = idPartenza;
	}
	public int getIdArrivo() {
		return idArrivo;
	}
	public void setIdArrivo(int idArrivo) {
		this.idArrivo = idArrivo;
	}
	
	
}
