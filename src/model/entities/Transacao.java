package model.entities;

import java.io.Serializable;
import java.util.Date;

import model.enumerations.Status;
import model.enumerations.Tipo;

public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataTransacao;
	private Tipo tipoEnum;
	private String descricao;
	private Double valorTotal;
	private Status statusEnum;
	private Integer idUsuarioSolicitante;

}
