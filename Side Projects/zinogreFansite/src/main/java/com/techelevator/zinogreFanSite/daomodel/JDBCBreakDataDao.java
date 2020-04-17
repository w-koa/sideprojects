package com.techelevator.zinogreFanSite.daomodel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCBreakDataDao implements BreakDataDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCBreakDataDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<BreakData> getAllBreakData() {
		
		List<BreakData> breakDataList = new ArrayList<>();
		
		String sqlGetAllBreakData = "SELECT * FROM zinogre_breaks";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllBreakData);
		
		while (results.next()) {
			breakDataList.add(mapRowToExhaustData(results));
		}
		return breakDataList;
	}

	@Override
	public void createExhaustData(BreakData data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExhaustDataById(int id) {
		// TODO Auto-generated method stub

	}
	
	// Map row helper method
	private BreakData mapRowToExhaustData(SqlRowSet row) {
		BreakData exhaustData = new BreakData();
		
		exhaustData.setId(row.getInt("id"));
		exhaustData.setPart(row.getString("part"));
		exhaustData.setBreakValue(row.getInt("hp"));
		exhaustData.setSeverValue(row.getInt("sever"));
		exhaustData.setExtractColor(row.getString("extract_color"));
		
		
		return exhaustData;
	}

}
