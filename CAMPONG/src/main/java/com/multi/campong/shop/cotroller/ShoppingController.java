package com.multi.campong.shop.cotroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.campong.common.util.PageInfo;
import com.multi.campong.shop.model.service.ShoppingService;
import com.multi.campong.shop.model.vo.Shopping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/shop")
@Controller
public class ShoppingController {

	@Autowired
	private ShoppingService service;

	@GetMapping("/shopping")
	public String shopping(Model model, @RequestParam Map<String, String> paramMap,
			@RequestParam(required = false) List<String> CheckItem,
			@RequestParam(required = false) List<String> CheckBrand){
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, Object> searchMap = new HashMap<>();
		try {
			String searchValue = paramMap.get("searchValue");

			if (searchValue != null && searchValue.length() > 0) {
				searchMap.put("title", searchValue);
			}

			page = Integer.parseInt(paramMap.get("page"));
		} catch (Exception e) {
		}
		
		searchMap.put("CheckItem", CheckItem);
		if (CheckItem == null) {
			CheckItem = new ArrayList<>();
		}
		
		searchMap.put("CheckBrand", CheckBrand);
		if (CheckBrand == null) {
			CheckBrand = new ArrayList<>();
		}

		int shoppingCount = service.getShoppingCount(searchMap);
		PageInfo pageInfo = new PageInfo(page, 10, shoppingCount, 12);
		List<Shopping> list = service.getShoppingList(pageInfo, searchMap);

		model.addAttribute("CheckItem", CheckItem);
		model.addAttribute("CheckBrand", CheckBrand);
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("shoppingCount", shoppingCount);

		return "shop/shopping";
	}

	@GetMapping("/shopping-basket")
	public String basket(Model model, @RequestParam Map<String, String> paramMap) {

		return "shop/shopping-basket";
	}
}