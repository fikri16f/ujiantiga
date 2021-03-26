package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartementRowMapper implements RowMapper<DepartementData> {
	
	public DepartementData mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new DepartementData(rs.getString("departement"), rs.getString("totalkaryawan"));
	}
}
