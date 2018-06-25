package service;

import model.Account;
import config.PwdConfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PwdService {

    private CryptoService cryptoService;

    public PwdService(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    public String retrievePassword(String key) {
        List<Account> data = this.retrieveAll();
        Optional<Account> targetAccount = data.stream().filter(item -> item.getKey().equals(key)).findFirst();
        return targetAccount.get().getPassword();
    }

    public List<String> retrieveNameList() {
        List<Account> data = this.retrieveAll();
        List<String> accountNameList = data.stream().map(Account::getKey).collect(Collectors.toList());
        return accountNameList;
    }

    public List<Account> retrieveAll() {
        String data = cryptoService.decrypt(PwdConfig.getEncryptedFile());
        List<Account> accountList = (new Gson()).fromJson(data, new TypeToken<List<Account>>() {
        }.getType());
        return accountList;
    }
}
