package model;

import java.sql.Date;

public class Comanda {

	private int codigo;
	private Date dataAbertura;
	private Date dataFechamento;
	
	public Comanda(int codigo, Date dataAbertura, Date dataFechamento) {
		super();
		this.codigo = codigo;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
}