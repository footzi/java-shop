package com.java_shop.Client;

import com.java_shop.Client.DTOs.InputAddClientDTO;
import com.java_shop.Helpers.Helpers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.java_shop.Response.Response;
import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @PostMapping(value = "add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody InputAddClientDTO inputAddClientDTO) {
        try {
            Client client = ClientService.add(inputAddClientDTO);

            URI uri = Helpers.createUri(client.getId());

            Response<Client> response = new Response<>(client);

            return ResponseEntity.created(uri).body(response.getBody());
        } catch (Exception error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.badRequest().body(response.getBody());
        }
    }
}
