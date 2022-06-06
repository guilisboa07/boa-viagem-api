package br.com.etechoracio.boa_viagem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import br.com.etechoracio.boa_viagem.enums.TipoViagemEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_VIAGEM")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VIAGEM")
	private Long id;
	
	
	@NotBlank(message="Destino está vazio")
	@Column(name = "TX_DESTINO")
	private String destino;

	@Enumerated(EnumType.STRING)
	@Column(name = "TP_VIAGEM")
	private TipoViagemEnum tipo;

	
	@Column(name = "DT_CHEGADA")
	private LocalDate chegada;

	@Column(name = "DT_SAIDA")
	private LocalDate saida;

	@DecimalMin(value="0.01")
	@Column(name = "VLR_ORCAMENTO")
	private Double orcamento;

	@Min(value = 1)
	@Column(name = "QTD_PESSOAS")
	private Integer pessoas;
}
