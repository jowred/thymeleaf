package br.gov.sp.fatec.clinica.model;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}
	
	public BusinessException(String str) {
		super(str);
	}
	
}
