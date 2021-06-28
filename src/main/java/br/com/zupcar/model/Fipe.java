package br.com.zupcar.model;

public class Fipe{

	private String nome;
	private String codigo;
	private String valor;
	private String marca;
	private String modelo;
	private String ano;

	
	public Fipe() {
	}


	public Fipe(String nome, String codigo, String valor, String marca, String modelo, String ano) {
		this.nome = nome;
		this.codigo = codigo;
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
}
