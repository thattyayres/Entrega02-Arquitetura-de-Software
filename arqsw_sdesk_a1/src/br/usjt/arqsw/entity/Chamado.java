package br.usjt.arqsw.entity;

import java.util.Date;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author Tatiane Ayres 816118367
 *
 */

public class Chamado {
	@NotNull
	@Max(value = 11)
		private int idChamado;
	
	@NotNull
	@Max(value = 100)
		private String descricao;
	
	@NotNull
	@Max(value = 10)
		private String status;
	
	@NotNull
		private Date dtAbertura;
	
	@NotNull
		private Date dtFechamento;
	
	@NotNull
		private Fila fila;		
	
	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	@Override
	public String toString() {
		return "Chamado [idChamado=" + idChamado + ", descricao=" + descricao + ", status=" + status + ", dtAbertura="
				+ dtAbertura + ", dtFechamento=" + dtFechamento + ", fila=" + fila + "]";
	}



}
