package Musicas;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Musica {
	private String nome;
	private String artista;
	private int tempoSec;
	private String tempoMin;
	private String diretorio;
	
	NumberFormat formatter = new DecimalFormat("00");

	public Musica(String nome, String artista, String diretorio, int min, int sec) {
		this.nome = nome;
		this.artista = artista;
		this.diretorio = (getClass().getResource(diretorio).toString()).replace("file:", "");
		this.tempoSec = min * 60 + sec;
		this.tempoMin = min + ":" + formatter.format(sec);
	}
	
	public Musica(String nome, String artista, String diretorio, String tempo_min, int tempo_sec) {
		this.nome = nome;
		this.artista = artista;
		this.diretorio = diretorio;
		this.tempoMin = tempo_min;
		this.tempoSec = tempo_sec;
	}
	
	public void limpar() {
		this.nome = "";
		this.artista = "";
		this.diretorio = "";
		this.tempoSec = 0;
		this.tempoMin = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getTempoSec() {
		return tempoSec;
	}

	public void setTempoSec(int tempoSec) {
		this.tempoSec = tempoSec;
	}

	public String getTempoMin() {
		return tempoMin;
	}

	public void setTempoMin(String tempoMin) {
		this.tempoMin = tempoMin;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	
	
}
