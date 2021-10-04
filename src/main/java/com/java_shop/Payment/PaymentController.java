package com.java_shop.Payment;

import com.java_shop.Payment.DTOs.OutputSuccessPaymentDTO;
import com.java_shop.Response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PutMapping(value = "success", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> success(@RequestParam("paymentId") String paymentId) {

        try {
            boolean result = PaymentService.success(Integer.parseInt(paymentId));
            OutputSuccessPaymentDTO output = new OutputSuccessPaymentDTO(result);
            Response<OutputSuccessPaymentDTO> response = new Response<>(output);

            return ResponseEntity.ok(response.getBody());
        } catch (SQLException error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }
}
