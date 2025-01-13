package com.example.billcalculator.service;

import com.example.billcalculator.dto.BillCalculationResponse;
import com.example.billcalculator.model.Bill;

public interface BillCalculationService {
    BillCalculationResponse calculatePayableAmount(Bill bill);

	double applyDiscounts(Bill bill);
}
