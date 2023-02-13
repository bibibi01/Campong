package com.multi.campong.bagpacking.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.campong.bagpacking.model.vo.Bagpacking;
import com.multi.campong.bagpacking.model.vo.Fishing;

@Mapper
public interface BagpackingMapper {
	List<Bagpacking> selectBagpackingList(Map<String, String> map);
	int selectBagpackingCount(Map<String, String> map);
	List<Bagpacking> selectIslandList(Map<String, String> map);
	int selectIslandCount(Map<String, String> map);
	List<Fishing> selectFishingList(Map<String, String> map);
	int selectFishingCount(Map<String, String> map);
	Bagpacking selectBagpackingByNo(int contentId);
	Fishing selectFishingByNo(int fishingNo);
	List<Bagpacking> selectBagpackingBestList(Map<String, String> map);
//	int updateReadCount(Bagpacking bagpacking);
}