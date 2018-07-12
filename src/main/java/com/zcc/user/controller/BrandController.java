package com.zcc.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zcc.user.model.Brand;
import com.zcc.user.service.BrandService;


@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/add") 
	@ResponseBody
	public String add(Brand brand) {
		try {
			brandService.add(brand);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(Brand brand) {
		try {
			brandService.update(brand); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id) {
		try {
			brandService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public Brand findById(Long id){
		try {
			return brandService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new Brand();
	}
	
	@RequestMapping("/findByIds") 
	@ResponseBody
	public List<Brand> findByIds(String ids){
		Brand brand=new Brand();
		brand.setIds(ids);
		try {
			return brandService.findByIds(brand);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ArrayList<Brand>();
	}
	
}
