package com.gts.timezone.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gts.timezone.model.GtsTimezone;

@Repository
public interface GtsTimezoneRepository extends JpaRepository<GtsTimezone,Integer>,GtsTimezoneDAO<GtsTimezone, String>{
	
	
	@Transactional
	@Query(
			  value = "SELECT * FROM GTS_TIMEZONES WHERE  gts_timezone_name like %:gts_timezone_name%",
			  nativeQuery = true)
	     List<GtsTimezone> getTimezoneByTimezoneName(String gts_timezone_name);
	 
	
	@Query(
			value="SELECT max(gts_timezone_id) from GTS_TIMEZONES ",
			nativeQuery= true)
	       Integer getMaxOfTimezoneID();
	
	@Query(
			  value = "SELECT * FROM GTS_TIMEZONES WHERE gts_timezone_status = true",
			  nativeQuery = true)
	          Collection<GtsTimezone> findActiveTimezone();
	
	@Query(
			  value = "SELECT * FROM GTS_TIMEZONES WHERE gts_timezone_status = false",
			  nativeQuery = true)
	          Collection<GtsTimezone> findInActiveTimezone();
}