package com.techelevator.zinogreFanSite.daomodel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCHitzoneDataDao implements HitzoneDataDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCHitzoneDataDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// READ
	// Gets all the hitzone Data from zinogre_hitzones table
	@Override
	public List<HitzoneData> getAllHitzoneData() {

		List<HitzoneData> hitzoneDataList = new ArrayList<>();
		
		String sqlGetHitzoneData = "SELECT id, part, sever_dmg, blunt_dmg, ranged_dmg, "
				+ "fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg "
				+ "FROM zinogre_hitzones";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetHitzoneData);
		while (results.next()) {
			hitzoneDataList.add(mapRowToHitzoneData(results));
		}
				
		
		return hitzoneDataList;
	}

	// Don't need, just for practice
	// UPDATE
	@Override
	public void updateHitzonePartDataById(int id, String partName) {
		
		String sqlUpdateHitzoneData = "UPDATE zinogre_hitzones SET part = ? WHERE id = ?";
		jdbcTemplate.update(sqlUpdateHitzoneData, partName, id);
	}

	// Don't need, just for practice
	@Override
	public void deleteHitzoneDataById(int id) {

		String sqlDeleteHitzoneData = "DELETE FROM zinogre_hitzones WHERE id = ?";
		jdbcTemplate.update(sqlDeleteHitzoneData, id);
	}

	// Don't need, just for practice
	@Override
	public void saveHitzoneData(HitzoneData hitzoneData) {
		
		String sqlSaveHitzoneData = "INSERT INTO zinogre_hitzones (part, sever_dmg, "
				+ "blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ";
		jdbcTemplate.update(sqlSaveHitzoneData, hitzoneData.getPart(), hitzoneData.getSever(), hitzoneData.getBlunt(), 
				hitzoneData.getRanged(), hitzoneData.getFire(), hitzoneData.getWater(), hitzoneData.getThunder(), 
				hitzoneData.getIce(), hitzoneData.getDragon(), hitzoneData.getStun());
	}
	
	// Helper Method to set hitzone data from RowSet
	private HitzoneData mapRowToHitzoneData(SqlRowSet row) {
		HitzoneData hitzoneData = new HitzoneData();
		hitzoneData.setId(row.getInt("id"));
		hitzoneData.setPart(row.getString("part"));
		hitzoneData.setSever(row.getInt("sever_dmg"));
		hitzoneData.setBlunt(row.getInt("blunt_dmg"));
		hitzoneData.setRanged(row.getInt("ranged_dmg"));
		hitzoneData.setFire(row.getInt("fire_dmg"));
		hitzoneData.setWater(row.getInt("water_dmg"));
		hitzoneData.setThunder(row.getInt("thunder_dmg"));
		hitzoneData.setIce(row.getInt("ice_dmg"));
		hitzoneData.setDragon(row.getInt("dragon_dmg"));
		hitzoneData.setStun(row.getInt("stun_dmg"));
		
		return hitzoneData;
	}
	
	// Helper Method to get next serial Id
	// Keeps making new Ids when used, be careful with this one.
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('zinogre_hitzones_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if (result.next()) {
			return result.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next hitzone id");
		}
	}

}
