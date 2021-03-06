package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private int codigo;
	private String nome;
	private int telefone;
	private List<Comanda> comandas;
	
	public Cliente(int codigo, String nome, int telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.comandas = new ArrayList<Comanda>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}
}