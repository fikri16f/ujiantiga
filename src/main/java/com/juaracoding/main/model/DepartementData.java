package com.juaracoding.main.model;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class DepartementData {
	
	public DepartementData(String departement, String jumlahkaryawan) {
		super();
		this.departement = departement;
		this.totalkaryawan = totalkaryawan;
		
	}

	private String departement;
	private String totalkaryawan;
	
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getTotalkryawan() {
		return totalkaryawan;
	}
	public void setTotalkryawan(String totalkryawan) {
		this.totalkaryawan = totalkaryawan;
	}
	
	
}
