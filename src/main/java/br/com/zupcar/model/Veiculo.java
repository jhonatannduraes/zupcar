package br.com.zupcar.model;

import java.time.OffsetDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;

	private String valor;

	private String diaRodizio;

	private Boolean rodizioAtivo;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
    

	public Veiculo(@NotBlank String marca, @NotBlank String modelo, @NotBlank String ano, String valor,
			String diaRodizio, Boolean rodizioAtivo, Usuario usuario) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.diaRodizio = diaRodizio;
		this.rodizioAtivo = rodizioAtivo;
		this.usuario = usuario;
	}

	
	public Veiculo() {
	}
	

	public Long getId() {
		return id;
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


	public void setValor(String valor) {
		this.valor = valor;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}


	public String getDiaRodizio() {

		String ano = this.getAno();
		char numero = ano.charAt(3);

		if (numero == '9' || numero == '8') {
			diaRodizio = "sexta-feira";
		} else if (numero == '7' || numero == '6') {
			diaRodizio = "quinta-feira";
		} else if (numero == '5' || numero == '4') {
			diaRodizio = "quarta-feira";
		} else if (numero == '3' || numero == '2') {
			diaRodizio = "terça-feira";
		} else if (numero == '1' || numero == '0') {
			diaRodizio = "segunda-feira";
		}
		return diaRodizio;
	}

	public Boolean getRodizioAtivo() {

		String dataDeHoje = OffsetDateTime.now().getDayOfWeek()
				.getDisplayName(TextStyle.FULL, Locale.getDefault());

		if (dataDeHoje.equals(getDiaRodizio())) {
			rodizioAtivo = true;
		} else {
			rodizioAtivo = false;
		}

		return rodizioAtivo;
	}

	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}


	public String getValor() {
		return valor;
	}

}
