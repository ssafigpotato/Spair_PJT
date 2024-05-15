package com.ssafy.spair.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spair.model.dao.SportsCenterDao;
import com.ssafy.spair.model.dto.SportsCenter;

@Service
public class SportsCenterServiceImpl implements SportsCenterService  {
	
	private SportsCenterDao sportsCenterDao ;
	
	@Autowired
	public SportsCenterServiceImpl(SportsCenterDao sportsCenterDao) {
		this.sportsCenterDao = sportsCenterDao ;
	}

	@Override
	public int insert(SportsCenter sportsCenter) {
		sportsCenterDao.insert(sportsCenter) ;
		SportsCenter result = sportsCenterDao.search(sportsCenter.getRoadAddress()) ;
		return result.getCenterId();
	}

	@Override
	public int search(String address) {
		if(sportsCenterDao.search(address) == null) {
			return 0 ;
		}
		
		SportsCenter sportsCenter = sportsCenterDao.search(address) ;
		return sportsCenter.getCenterId();
	}

}