package com.mcf.diagnosis.model.enums;

public enum Classification {

	RISCO("Risco"),
	ALERTA("Alerta"), 
	MEDIANO("Mediano"), 
	FAVORAVEL("Favorável"),
	BEM_ESTAR_FINANCEIRO("Bem-Estar-Financeiro");
	
	private String value;

	Classification(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
