package br.gov.sp.fatec.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.clinica.model.ClinicaMedica;

public interface ClinicaMedicaRepository extends JpaRepository<ClinicaMedica, Long> {

//	@Query(value = "SELECT cm FROM ClinicaMedica cm WHERE ((:nome IS NULL) OR (LOWER(cm.nome) LIKE :nome)) OR ((:nomeConvenio IS NULL) OR (LOWER(cm.nomeConvenio) LIKE :nomeConvenio)) OR ((:nomeMedico IS NULL) OR (LOWER(cm.nomeMedico) LIKE :nomeMedico))")
	@Query(value = "SELECT cm FROM ClinicaMedica cm WHERE ((LOWER(cm.nome) LIKE COALESCE(:nome))) OR ((LOWER(cm.nomeConvenio) LIKE COALESCE(:nomeConvenio))) OR ((LOWER(cm.nomeMedico) LIKE COALESCE(:nomeMedico)))")
	List<ClinicaMedica> findByNomeLikeAndNomeConvenioLikeAndNomeMedicoLike(@Param("nome") String nome, @Param("nomeConvenio") String nomeConvenio, @Param("nomeMedico") String nomeMedico);
}
