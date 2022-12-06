package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.QuyenEntity;
import com.example.reposity.QuyenReposity;

@RestController
@RequestMapping("/api")
public class QuyenAPI {
	
	@Autowired
	private QuyenReposity reposity;
	
	@GetMapping("/Quyen")
	public List<QuyenEntity> getAll(){
		return reposity.findAll();
	}
	
	@GetMapping("/Quyen/{MaQuyen}")
	  public ResponseEntity<Optional<QuyenEntity>> getRoleById(@PathVariable(value = "MaQuyen") Long MaQuyen)
	       {
	  Optional<QuyenEntity> entity = reposity.findById(MaQuyen);
	    return ResponseEntity.ok().body(entity);
	  }
	
	@PostMapping("/Quyen")
	  public QuyenEntity createQ(@RequestBody QuyenEntity entity) {
	    return reposity.save(entity);
	  }
}
