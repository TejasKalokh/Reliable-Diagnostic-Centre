package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Service
public class UPIService {

    public String generateUPIString(String vpa, String merchantName, String merchantCode,
                                    String transactionRefId, String transactionNote, double amount, String currency) {

        // 1. Format the amount to two decimal places (e.g., 10.00)
        String formattedAmount = String.format("%.2f", amount);

        // 2. Build the UPI link, piece by piece.
        //    It's like assembling a sentence with specific words in the right order.
        String upiLink = "upi://pay?pa=" + vpa +
                "&pn=" + urlEncode(merchantName) + // Encode for safety
                "&mc=" + merchantCode +
                "&tr=" + transactionRefId +
                "&tn=" + urlEncode(transactionNote) + // Encode for safety
                "&am=" + formattedAmount +
                "&cu=" + currency ;

        return upiLink;
    }

    // Helper function to make sure special characters in the URL are handled correctly.
    private String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            // Handle the error (in a real app, you'd log this)
            return ""; // Return empty string for now
        }
    }

}