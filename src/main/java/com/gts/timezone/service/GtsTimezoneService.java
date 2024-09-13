package com.gts.timezone.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.gts.timezone.model.GtsTimezone;
import com.gts.timezone.util.JsonResponseModel;


public interface GtsTimezoneService {
	
	List<GtsTimezone> getAllGtsTimezone();
	
	JsonResponseModel addGtsTimezone(GtsTimezone gtsTimezone);
	
	JsonResponseModel updateGtsTimezone(GtsTimezone gtsTimezone);
	
	Optional<GtsTimezone> findByTimezoneId(int id) ;
	
	List<GtsTimezone> getTimezoneByTimezoneName(String gts_timezone_name);
	
	Collection<GtsTimezone> findActiveTimezone();
	
	Collection<GtsTimezone> findInActiveTimezone();
	
	JsonResponseModel deleteGtsTimezone(int id);
	
	Integer generateTimezoneID();

	

	

	

	

	





	



	
	

	
	

	

}
