package com.gts.timezone.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.timezone.model.GtsTimezone;
import com.gts.timezone.repository.GtsTimezoneRepository;
import com.gts.timezone.util.JsonResponseModel;

@Service
public class GtsTimezoneServiceImpl implements GtsTimezoneService{

	@Autowired
	private GtsTimezoneRepository GtsTimezoneRepository;	

	@Override
	public JsonResponseModel addGtsTimezone(GtsTimezone gtsTimezone) {
		System.out.println(" reaching Service implementation");
		
		JsonResponseModel jsonObject = new JsonResponseModel();
//		try {
			GtsTimezoneRepository.save(gtsTimezone);
			jsonObject.setSuccess("True");
			jsonObject.setMessage("Timezone(s) added successfully");
			jsonObject.setStatus_code("201");
//		} catch (Exception e) {
//			jsonObject.setSuccess("False");
//			jsonObject.setMessage("Not able to add timezone");
//			jsonObject.setStatus_code("403");
//		}
		return jsonObject;

	}
	
	@Override
	public JsonResponseModel updateGtsTimezone(GtsTimezone gtsTimezone) {
		
		JsonResponseModel jsonObject = new JsonResponseModel();
		try {
			GtsTimezoneRepository.save(gtsTimezone);
			jsonObject.setSuccess("True");
			jsonObject.setMessage("Timezone(s) update successfully");
			jsonObject.setStatus_code("200");
		} catch (Exception e) {
			jsonObject.setSuccess("False");
			jsonObject.setMessage("Not able to update timezone");
			jsonObject.setStatus_code("403");
		}
		return jsonObject;
	
	}
	@Override
	public List<GtsTimezone> getAllGtsTimezone() {
		
		List<GtsTimezone> gtsTimezone = new ArrayList<>();
		GtsTimezoneRepository.findAll().forEach(gtsTimezone::add);
		return gtsTimezone;
	
	}
	
	@Override
	public Optional<GtsTimezone> findByTimezoneId(int id) {
		
		return GtsTimezoneRepository.findById(id);
	
	}
	
	@Override
	public List<GtsTimezone> getTimezoneByTimezoneName(String gts_timezone_name) {
		return GtsTimezoneRepository.getTimezoneByTimezoneName(gts_timezone_name);
	}
	
	public Collection<GtsTimezone> findActiveTimezone() {
		return GtsTimezoneRepository.findActiveTimezone();
	}

	

	@Override
	public Collection<GtsTimezone> findInActiveTimezone() {
		return GtsTimezoneRepository.findInActiveTimezone();
	}
	
	@Override
	public JsonResponseModel deleteGtsTimezone(int id) {
		
		JsonResponseModel jsonObject = new JsonResponseModel();
		try {
			GtsTimezoneRepository.deleteById(id);
				jsonObject.setSuccess("True");
				jsonObject.setMessage("Timezone(s) deleted successfully");
				jsonObject.setStatus_code("200");
			} catch (Exception e) {
				jsonObject.setSuccess("False");
				jsonObject.setMessage("Not able to delete timezone");
				jsonObject.setStatus_code("403");
			}
		return jsonObject;
	
	}

	
	@Override
	public Integer generateTimezoneID() {
		 int numberoftimezone = 0;
		 System.out.println("generating ID");
		 if(GtsTimezoneRepository.getMaxOfTimezoneID()!=null)
		 {
			 numberoftimezone =GtsTimezoneRepository.getMaxOfTimezoneID();
		 }
		return numberoftimezone ;
	}


	

	
	}

	
	

	

	


	

