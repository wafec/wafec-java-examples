package com.serviceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    private static final List<Wallet> walletList = new ArrayList<>();
    private final VerifyApi verifyApi;

    @Autowired
    public WalletServiceImpl(VerifyApi verifyApi) {
        this.verifyApi = verifyApi;
    }

    @Override
    public boolean createWallet(User user) {
        NameVerified nameVerified = verifyApi.verifyName(user.getName());

        if (nameVerified.isValid()) {
            Wallet wallet = new Wallet();
            wallet.setUser(user);
            wallet.setUnits(1);
            walletList.add(wallet);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Wallet getWalletByUsername(String username) {
        Optional<Wallet> walletOptional = walletList.stream().filter(wallet -> wallet.getUser().getName().equals(username)).findFirst();
        return walletOptional.orElse(null);
    }
}
