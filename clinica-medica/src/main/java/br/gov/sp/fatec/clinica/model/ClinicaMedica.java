package br.gov.sp.fatec.clinica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClinicaMedica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String nomeConvenio;
	
	private String descricao;
	
	private String nomeMedico;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeConvenio == null) ? 0 : nomeConvenio.hashCode());
		result = prime * result + ((nomeMedico == null) ? 0 : nomeMedico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClinicaMedica other = (ClinicaMedica) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeConvenio == null) {
			if (other.nomeConvenio != null)
				return false;
		} else if (!nomeConvenio.equals(other.nomeConvenio))
			return false;
		if (nomeMedico == null) {
			if (other.nomeMedico != null)
				return false;
		} else if (!nomeMedico.equals(other.nomeMedico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClinicaMedica [id=" + id + ", nome=" + nome + ", nomeConvenio=" + nomeConvenio + ", descricao="
				+ descricao + ", nomeMedico=" + nomeMedico + "]";
	}
	
}
