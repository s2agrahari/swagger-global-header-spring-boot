package com.suraj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** created by @author suraj on 23/05/20 */
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

  @GetMapping
  public ResponseEntity sayHello() {
    return ResponseEntity.ok("Hello There!!!");
  }
}
