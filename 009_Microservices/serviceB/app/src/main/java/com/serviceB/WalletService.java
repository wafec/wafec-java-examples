package com.serviceB;

public interface WalletService {
    boolean createWallet(User user);
    Wallet getWalletByUsername(String username);
}
