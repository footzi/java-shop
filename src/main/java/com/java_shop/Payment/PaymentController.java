package com.java_shop.Payment;

import com.java_shop.Response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping(value = "success", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity success(@RequestParam("paymentId") String paymentId) {

        try {
            PaymentService.success(Integer.parseInt(paymentId));

            return ResponseEntity.ok("12233");
        } catch (SQLException error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }
}
