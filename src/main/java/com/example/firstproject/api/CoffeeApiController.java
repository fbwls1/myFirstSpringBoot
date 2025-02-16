package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j

public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffees")
    public ArrayList<Coffee> index() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null) {
            log.info("{}번 데이터가 존재하지 않습니다.", id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto dto) {
        log.info(dto.toString());
        Coffee coffee = dto.toEntity();
        log.info(coffee.toString());
        coffeeRepository.save(coffee);
        return ResponseEntity.status(HttpStatus.OK).body(coffee);
    }

    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id,
                                         @RequestBody CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null || id != target.getId()) {
            log.info("잘못된 요청");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null) {
            log.info("해당 게시물이 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
