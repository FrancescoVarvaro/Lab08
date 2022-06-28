package it.polito.tdp.extflightdelays.model;

import org.jgrapht.graph.DefaultWeightedEdge;

public class ArchiPesati {
	
	private int distanza;
	private DefaultWeightedEdge arco;
	
	public ArchiPesati(int distanza, DefaultWeightedEdge archi) {
		this.distanza = distanza;
		this.arco = archi;
	}
	
	public int getDistanza() {
		return distanza;
	}
	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}
	public DefaultWeightedEdge getArchi() {
		return arco;
	}
	public void setArchi(DefaultWeightedEdge archi) {
		this.arco = archi;
	}

	@Override
	public String toString() {
		return "ArchiPesati [distanza=" + distanza + ", arco=" + arco + "]";
	}
	
	
}
