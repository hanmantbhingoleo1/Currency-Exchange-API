package com.example.billcalculator.controller;

import com.example.billcalculator.dto.BillCalculationResponse;
import com.example.billcalculator.model.Bill;
import com.example.billcalculator.service.BillCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BillController {

    private final BillCalculationService billCalculationService;

    @Autowired
    public BillController(BillCalculationService billCalculationService) {
        this.billCalculationService = billCalculationService;
    }

    @PostMapping("/calculate")
    public BillCalculationResponse calculatePayableAmount(@RequestBody Bill bill) {
        return billCalculationService.calculatePayableAmount(bill);
    }
}
