package com.gts.timezone.repository;

import java.util.List;

import com.gts.timezone.model.GtsTimezone;

public interface GtsTimezoneDAO<T, S> {
	
	List<GtsTimezone> getTimezoneByTimezoneName(String gts_timezone_name);
	

}
