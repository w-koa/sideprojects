package com.techelevator.zinogreFanSite.daomodel;

import java.util.List;

public interface HitzoneDataDao {

	public List<HitzoneData> getAllHitzoneData();
	
	// Don't need these, just for practice purposes
	public void updateHitzonePartDataById(int id, String partName);
	public void deleteHitzoneDataById(int id);
	public void saveHitzoneData(HitzoneData hitzoneData);
}
