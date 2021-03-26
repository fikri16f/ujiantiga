package com.juaracoding.main.model;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Bonus {
	
	private String Worker_ref_id;
	private String Bonus_date;
	private String Bonus_amount;
	
	
	public String getWorker_ref_id() {
		return Worker_ref_id;
	}
	public void setWorker_ref_id(String worker_ref_id) {
		Worker_ref_id = worker_ref_id;
	}
	public String getBonus_date() {
		return Bonus_date;
	}
	public void setBonus_date(String bonus_date) {
		Bonus_date = bonus_date;
	}
	public String getBonus_amount() {
		return Bonus_amount;
	}
	public void setBonus_amount(String bonus_amount) {
		Bonus_amount = bonus_amount;
	}

}
