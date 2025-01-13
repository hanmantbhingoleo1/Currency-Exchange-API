package com.example.billcalculator.service;

import com.example.billcalculator.model.Bill;
import com.example.billcalculator.model.CurrencyResponse;
import com.example.billcalculator.dto.BillCalculationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BillCalculationServiceImpl implements BillCalculationService {

    @Value("${currency.api.url}")
    private String apiUrl;

    @Value("${currency.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public BillCalculationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BillCalculationResponse calculatePayableAmount(Bill bill) {
        // Apply discounts
        double discount = applyDiscounts(bill);
        double amountAfterDiscounts = bill.getTotalAmount() - discount;

        // Print debug info for discount calculation
        System.out.println("Applied discount: " + discount);
        System.out.println("Amount after discounts: " + amountAfterDiscounts);

        // Convert to target currency using the exchange rate
        double exchangeRate = getExchangeRate(bill.getOriginalCurrency(), bill.getTargetCurrency());

        // Print debug info for exchange rate
        System.out.println("Exchange rate from " + bill.getOriginalCurrency() + " to " + bill.getTargetCurrency() + ": " + exchangeRate);

        // Calculate final payable amount in target currency
        double finalAmount = amountAfterDiscounts * exchangeRate;

        // Print debug info for final payable amount
        System.out.println("Final payable amount in " + bill.getTargetCurrency() + ": " + finalAmount);

        // Construct the response object
        return new BillCalculationResponse(
                bill.getTotalAmount(),
                bill.getGroceryAmount(),
                bill.getUserType(),
                bill.getCustomerTenure(),
                bill.getOriginalCurrency(),
                bill.getTargetCurrency(),
                discount,
                amountAfterDiscounts,
                exchangeRate,
                finalAmount
        );
    }

    public double applyDiscounts(Bill bill) {
        double totalAmount = bill.getTotalAmount();
        double groceryAmount = bill.getGroceryAmount();
        double discount = 0;

        // Apply percentage-based discounts based on user type or tenure
        if (bill.getUserType().equalsIgnoreCase("employee")) {
            discount = (totalAmount - groceryAmount) * 0.30;
            System.out.println("Employee discount: " + discount);
        } else if (bill.getUserType().equalsIgnoreCase("affiliate")) {
            discount = (totalAmount - groceryAmount) * 0.10;
            System.out.println("Affiliate discount: " + discount);
        } else if (bill.getCustomerTenure() >= 2) {  // Updated condition to include tenure >= 2
            discount = (totalAmount - groceryAmount) * 0.05;
            System.out.println("Customer tenure discount: " + discount);
        }

        // Apply $5 discount for every $100 if total amount >= 100
        if (totalAmount >= 100) {
            double additionalDiscount = (int) (totalAmount / 100) * 5;
            discount += additionalDiscount;
            System.out.println("Additional $5 discount for every $100: " + additionalDiscount);
        } else if (bill.getCustomerTenure() >= 2) {
            // Apply only the 5% discount for tenure if amount < 100
            discount = (totalAmount - groceryAmount) * 0.05;
            System.out.println("Customer tenure discount applied for amount < 100: " + discount);
        } else {
            System.out.println("No proportional discount applied as the total amount is less than $100.");
        }

        // Print total discount for debugging
        System.out.println("Total discount applied: " + discount);
        return discount;
    }


    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Build the URL dynamically with the provided baseCurrency and API key
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .buildAndExpand(baseCurrency, apiKey)
                .toUriString();

        // Print URL for debugging
        System.out.println("Fetching exchange rate with URL: " + url);

        // Make the API call and get the response as a CurrencyResponse object
        CurrencyResponse response = restTemplate.getForObject(url, CurrencyResponse.class);

        // Extract the exchange rate for the target currency
        if (response != null && response.getRates() != null) {
            double exchangeRate = response.getRates().getOrDefault(targetCurrency, 0.0);
            // Print exchange rate for debugging
            System.out.println("Exchange rate retrieved: " + exchangeRate);
            return exchangeRate;
        } else {
            throw new RuntimeException("Failed to get exchange rate.");
        }
    }
}
