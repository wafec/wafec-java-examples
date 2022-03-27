package com.serviceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/api/wallet")
    public ResponseEntity<String> post(@RequestBody User user) {
        boolean result = this.walletService.createWallet(user);

        if (result)
            return ResponseEntity.<String>ok().build();
        else
            return ResponseEntity.<String>badRequest().build();
    }

    @GetMapping("/api/wallet")
    public Wallet get(@RequestParam("username") String username) {
        return this.walletService.getWalletByUsername(username);
    }
}
