package org.techprophet.saop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.techprophet.saop.services.PaymentService;

import java.util.UUID;

@RestController
@RequestMapping("/api/aop")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("")
    public String processPayment(@RequestParam double amount) {
        return paymentService.processPayment(UUID.randomUUID().toString(), amount);
    }

}
