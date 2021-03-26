package com.juaracoding.main.model;


import org.springframework.jdbc.core.namedparam.SqlParameterSource;


public class Title {
	
	private String Worker_ref_id;
	private String  Worker_title;
	private String Affected_from;
	
	public String getWorker_ref_id() {
		return Worker_ref_id;
	}
	public void setWorker_ref_id(String worker_ref_id) {
		Worker_ref_id = worker_ref_id;
	}
	public String getWorker_title() {
		return Worker_title;
	}
	public void setWorker_title(String worker_title) {
		Worker_title = worker_title;
	}
	public String getAffected_from() {
		return Affected_from;
	}
	public void setAffected_from(String affected_from) {
		Affected_from = affected_from;
	}

}
