package com.example.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.ShipperEntity;
import com.example.reposity.ShipperReposity;

@RestController
@RequestMapping("/api/Shipper")
public class ShipperAPI {
	
	@Autowired
	private ShipperReposity reposity;
	
	@GetMapping("")
	public List<ShipperEntity> getAll(){
		return reposity.findAllShipper();
	}
}