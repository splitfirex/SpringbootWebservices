package io.splitfirex.commons.controller;

import io.splitfirex.commons.model.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<?> getHealth(){
        return ResponseEntity.ok(new HealthResponse("OK"));
    }
}
