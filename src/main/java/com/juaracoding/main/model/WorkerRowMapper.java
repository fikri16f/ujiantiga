package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class WorkerRowMapper implements RowMapper<Worker> {

	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Worker worker = new Worker ();
		worker.setWorker_id(rs.getString("worker_id"));
		worker.setFirst_name(rs.getString("first_name"));
		worker.setLast_name(rs.getString("last_name"));
		worker.setSalary(rs.getString("salary"));
		worker.setJoining_date(rs.getString("joining_date"));
		worker.setDepartement(rs.getString("departement"));
		
		return worker;
	}
	
	
	
	
	
	
	
	
	

}
