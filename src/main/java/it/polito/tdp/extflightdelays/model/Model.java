package it.polito.tdp.extflightdelays.model;

import java.util.LinkedList;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> aereoportiId;
	
	List<Airline> tratte = null;
	List<Airport> aereoporti = null;
	List<Flight> voli = null;
	
	public void creaGrafo(int distanzaMinima) {
		
		this.grafo = new SimpleWeightedGraph(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		Graphs.addAllVertices(grafo, getAirports());
		
		List<Coppia> aereoportiCollegati = dao.getAereoportiConnessi();
		for(Coppia c : aereoportiCollegati) {
			if(c.getdistanza()>distanzaMinima)
				Graphs.addEdgeWithVertices(this.grafo, this.aereoportiId.get(c.getIdPartenza()), 
										   this.aereoportiId.get(c.getIdArrivo()), c.getdistanza());
		}
	}
	
	public int nVertici(){
		return this.grafo.vertexSet().size();
	}
	
	public int nEdge(){
		return this.grafo.edgeSet().size();
	}
	
	public List<ArchiPesati> getArchiPesati(){
		
		Set<DefaultWeightedEdge> archi = this.grafo.edgeSet();
		List<ArchiPesati> arco = new LinkedList <ArchiPesati>();
		
		for(DefaultWeightedEdge d : archi) {
			arco.add(new ArchiPesati((int) this.grafo.getEdgeWeight(d), d));
		}
		return arco;
	} 
	
	public List<Airline> getAirlines(){
		if(tratte == null) {
			ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
			tratte = new LinkedList<Airline>(dao.loadAllAirlines());
		}
		return this.tratte;
	}
	
	public List<Flight> getFlights(){
		if(tratte == null) {
			ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
			this.voli = new LinkedList<Flight>(dao.loadAllFlights());
		}
		return this.voli;
	}
	
	public List<Airport> getAirports(){
		
		if(tratte == null) {
			ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
			this.aereoporti = new LinkedList<Airport>(dao.loadAllAirports());
			aereoportiId = new HashMap<Integer,Airport>();
			for(Airport a : aereoporti) {
				aereoportiId.put(a.getId(), a);
			}
			return this.aereoporti;
		}
		
		return this.aereoporti;
	}
	
	
	
}
