package br.gov.sp.fatec.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.clinica.model.BusinessException;
import br.gov.sp.fatec.clinica.model.ClinicaMedica;
import br.gov.sp.fatec.clinica.repository.ClinicaMedicaRepository;

@Service
public class ClinicaMedicaService {
	
	@Autowired
	private ClinicaMedicaRepository repository;
	
	public void saveOrUpdate(ClinicaMedica clinica) throws BusinessException {
		if (clinica == null || ((clinica.getNome() == null || clinica.getNome().trim().isEmpty())
				&& (clinica.getNomeConvenio() == null || clinica.getNomeConvenio().trim().isEmpty())
				&& (clinica.getNomeMedico() == null || clinica.getNomeMedico().trim().isEmpty()))) {
			throw new BusinessException("Não é possível inserir uma clínica nova sem nome, nome do convênio e nome do médico.");
		}
		repository.save(clinica);
	}

	public ClinicaMedica findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(ClinicaMedica clinica) {
		repository.delete(clinica);
	}

	public List<ClinicaMedica> findAll() {
		return repository.findAll();
	}
	
	public void saveAll(List<ClinicaMedica> clinicas) {
		repository.saveAll(clinicas);
	}
	
	public List<ClinicaMedica> findByNomeLikeAndNomeConvenioLikeAndNomeMedicoLike(ClinicaMedica clinica) {
		
		int blankArgs = 0;
		
		if(clinica == null) {
			return this.findAll();
		}
		
		if (clinica.getNome() != null && !clinica.getNome().trim().isEmpty()) {
			String nome = new StringBuilder("%").append(clinica.getNome().toLowerCase()).append("%").toString();
			clinica.setNome(nome);
		} else {
			blankArgs++;
		}
		
		if (clinica.getNomeConvenio() != null && !clinica.getNomeConvenio().trim().isEmpty()) {
			String nomeConvenio = new StringBuilder("%").append(clinica.getNomeConvenio().toLowerCase()).append("%").toString();
			clinica.setNomeConvenio(nomeConvenio);
		} else {
			blankArgs++;
		}
		
		if (clinica.getNomeMedico() != null && !clinica.getNomeMedico().trim().isEmpty()) {
			String nomeMedico = new StringBuilder("%").append(clinica.getNomeMedico().toLowerCase()).append("%").toString();
			clinica.setNomeMedico(nomeMedico);
		} else {
			blankArgs++;
		}
		
		if (blankArgs == 3) {
			return this.findAll();
		}
		
		return repository.findByNomeLikeAndNomeConvenioLikeAndNomeMedicoLike(
				clinica.getNome(), 
				clinica.getNomeConvenio(),
				clinica.getNomeMedico());
	}
}
