package com.multi.campong.car.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.campong.car.model.mapper.CarMapper;
import com.multi.campong.car.model.vo.Bus;
import com.multi.campong.car.model.vo.Car;
import com.multi.campong.car.model.vo.Train;
import com.multi.campong.common.util.PageInfo;

@Service
public class CarService {
	@Autowired
	private CarMapper mapper;
	
	public int getCarCount(Map<String, String> param) {
		return mapper.selectCarCount(param);
	}
	
	public List<Car> getCarList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectCarList(param);
	}
	@Transactional(rollbackFor = Exception.class)
	public Car findByNo(int contentId) {
		Car car = mapper.selectCarByNo(contentId); 
		return car; 
	}
	
	// 버스
	public int bookingBus(Bus bus) {
		return mapper.insertBookingBus(bus);
	}

	public List<Bus> getBookingBusList(int mNo) {
		return mapper.selectBusTicketList(mNo);
	}
	
	// 열차
	public int bookingTrain(Train train) {
		return mapper.insertBookingTrain(train);
	}
	
	public List<Train> getBookingTrainList(int mNo) {
		return mapper.selectTrainTicketList(mNo);
	}

	public int deleteBusTicket(int ticketNo) {
		return mapper.deleteBusTicket(ticketNo);
	}

	public int deleteTrainTicket(int ticketNo) {
		return mapper.deleteTrainTicket(ticketNo);
	}
}
