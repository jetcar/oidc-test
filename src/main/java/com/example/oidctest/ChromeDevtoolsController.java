package com.example.oidctest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class ChromeDevtoolsController {
    @GetMapping(value = "/.well-known/appspecific/com.chrome.devtools.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDevtoolsConfig() {
        String json = "{\"devtools\":true}";
        return ResponseEntity.ok(json);
    }
}
