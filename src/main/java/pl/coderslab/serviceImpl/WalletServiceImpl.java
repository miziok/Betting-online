package pl.coderslab.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.User;
import pl.coderslab.model.Wallet;
import pl.coderslab.repositories.WalletRepository;
import pl.coderslab.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public Wallet saveWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet createWallet(User user) {
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		wallet.setAmount(new BigDecimal(0));
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet findByUser(User user) {
		return walletRepository.findByUser(user);
	}

}