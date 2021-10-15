package com.pet.clinic.crm.controller;


import com.pet.clinic.crm.dto.Purchase;
import com.pet.clinic.crm.dto.PurchaseResponse;
import com.pet.clinic.crm.service.PurchaseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/purchase")
public class PurchaseServiceController {



    private PurchaseServiceService purchaseServiceService;

    @Autowired
    public PurchaseServiceController(PurchaseServiceService purchaseServiceService) {
        this.purchaseServiceService = purchaseServiceService;
    }


    @PostMapping("/purchaseService")
    public PurchaseResponse createStaff(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = purchaseServiceService.purchaseService(purchase);
        return purchaseResponse;
    }

}
