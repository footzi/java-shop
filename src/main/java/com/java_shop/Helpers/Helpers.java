package com.java_shop.Helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Helpers {
    public static URI createUri(int id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
