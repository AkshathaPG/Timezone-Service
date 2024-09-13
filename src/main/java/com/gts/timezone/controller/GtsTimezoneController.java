package com.gts.timezone.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.timezone.exception.ApplicationException;
import com.gts.timezone.exception.GtsTimezoneNotFoundException;
import com.gts.timezone.model.GtsTimezone;
import com.gts.timezone.service.GtsTimezoneService;
import com.gts.timezone.util.JsonResponseModel;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="api/v1/timezone")

public class GtsTimezoneController {
	
	
	@Autowired
	private GtsTimezoneService gtsTimezoneService;
	

	@PostMapping
	public ResponseEntity<JsonResponseModel> addGtsTimezone(@RequestBody GtsTimezone[] gtsTimezones){
		System.out.println("post mapping started");
		
		
		JsonResponseModel gtsTimezoneObj=null;
		for(GtsTimezone gtsTimezone: gtsTimezones ) {
			
			if(gtsTimezone.getgts_timezone_name()== null ||gtsTimezone.getgts_timezone_name().isEmpty())  {
				throw new ApplicationException("GTS timezone name should not be empty ");
			}
			
		   List<GtsTimezone> gtsTimezoneName=gtsTimezoneService.getTimezoneByTimezoneName(gtsTimezone.getgts_timezone_name());
		   System.out.println("timezone verification");
		   
		   if(gtsTimezoneName.isEmpty()==false) {
			throw new ApplicationException("GTS timezone already exists");
		   }
		
		    int nextTimezoneID=generateTimezoneID();
			gtsTimezone.setgts_timezone_id(nextTimezoneID);
			gtsTimezoneObj=gtsTimezoneService.addGtsTimezone(gtsTimezone);
		}
		return new ResponseEntity<>(gtsTimezoneObj, HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<JsonResponseModel> updateGtsTimezone(@RequestBody GtsTimezone[] gtsTimezones){
		JsonResponseModel GtsTimezoneObj=null;
		
		for(GtsTimezone gtsTimezone: gtsTimezones) {

			if(gtsTimezone.getgts_timezone_id()==null || gtsTimezone.getgts_timezone_id()<=0)
			{
				throw new ApplicationException("GTSTimezone id is invalid");
			}
			
			if(gtsTimezone.getgts_timezone_name()== null ||gtsTimezone.getgts_timezone_name().isEmpty()) {
				throw new ApplicationException("GTS timezone name should not be empty ");
			}
			
			Optional<GtsTimezone> gtsTimezoneObj= gtsTimezoneService.findByTimezoneId(gtsTimezone.getgts_timezone_id());
			if(!gtsTimezoneObj.isPresent())
			{
				throw new GtsTimezoneNotFoundException("GTS timezone id does not exist");
			}	
			
			List<GtsTimezone> gtsTimezoneName= gtsTimezoneService.getTimezoneByTimezoneName(gtsTimezone.getgts_timezone_name());
		
			 if(gtsTimezoneName.isEmpty()==false)
				{
					throw new ApplicationException("GTS timezone name already exists ");
				}
			
			GtsTimezoneObj=gtsTimezoneService.updateGtsTimezone(gtsTimezone);
		
		}
		return new ResponseEntity<>(GtsTimezoneObj,HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<GtsTimezone>> getAll() {
		return new ResponseEntity<>(gtsTimezoneService.getAllGtsTimezone(),HttpStatus.OK);
	}
	
	@GetMapping(path="/timezone_id/{gts_timezone_id}")
	public ResponseEntity<GtsTimezone> searchByTimezoneId(@PathVariable int gts_timezone_id) {
		
		if(gts_timezone_id<=0)
		{
			throw new ApplicationException("GTS Timezone id is invalid");
		}
		
		Optional<GtsTimezone> gtstimezoneId= gtsTimezoneService.findByTimezoneId( gts_timezone_id);
		
		if(!gtstimezoneId.isPresent()) {
			throw new GtsTimezoneNotFoundException("Gts timezone id not found ");
			}
		
		return new ResponseEntity<>(gtstimezoneId.get(), HttpStatus.OK);

	}
	
	@GetMapping(path="/timezone_name/{gts_timezone_name}")
	public ResponseEntity<List<GtsTimezone>> searchByTimezoneName(@PathVariable String gts_timezone_name) {
		
		List<GtsTimezone> gtsTimezoneName= gtsTimezoneService.getTimezoneByTimezoneName(gts_timezone_name);
	
		if(gtsTimezoneName.isEmpty()) {
			throw new GtsTimezoneNotFoundException("GTS language name not found ");
			}
			
			
		return new ResponseEntity<>(gtsTimezoneName, HttpStatus.OK);		
	}
	
	@GetMapping(path="/active")
	public ResponseEntity<Collection<GtsTimezone>> findActiveTimezone(){
		Collection<GtsTimezone> listOfActiveTimezone=gtsTimezoneService.findActiveTimezone();
		if(listOfActiveTimezone.isEmpty())
		{
			throw new ApplicationException("There are no active languages");
		}
		return new ResponseEntity<>(gtsTimezoneService.findActiveTimezone(),HttpStatus.OK);
	}

	@GetMapping(path="/inactive")
	public ResponseEntity<Collection<GtsTimezone>> findInActiveTimezone(){
		Collection<GtsTimezone> listOfInactiveTimezone=gtsTimezoneService.findInActiveTimezone();
		if(listOfInactiveTimezone.isEmpty())
		{
			throw new ApplicationException("There are no inaactive timezones ");
		}
		return new ResponseEntity<>(gtsTimezoneService.findInActiveTimezone(),HttpStatus.OK);
	}	
	
	@DeleteMapping(path="/timezone_id/{gts_timezone_id}")
	public ResponseEntity<JsonResponseModel> deleteGtsTimezone(@PathVariable int gts_timezone_id){
		System.out.println(1);
		
		Optional<GtsTimezone> gtsTimezoneId= gtsTimezoneService.findByTimezoneId(gts_timezone_id);
		
	  if(!gtsTimezoneId.isPresent()) {	
			throw new GtsTimezoneNotFoundException("GTS timezone id not found ");
		}
	
		return new ResponseEntity<>(gtsTimezoneService.deleteGtsTimezone(gts_timezone_id),HttpStatus.OK);
		
	}
	
	
	private synchronized int generateTimezoneID() {
	     return gtsTimezoneService.generateTimezoneID()+1;	
   }

}
