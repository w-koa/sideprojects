package com.techelevator.zinogreFanSite.daomodel;

import java.util.List;

public interface BreakDataDao {

	public List<BreakData> getAllBreakData();
	public void createExhaustData(BreakData data);
	public void deleteExhaustDataById(int id);
	
}
