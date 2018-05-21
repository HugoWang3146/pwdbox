package service;

import model.Account;
import config.PwdConfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PwdService {

    private CryptoService cryptoService;

    public PwdService(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    public String retrievePassword(String key) {
        String data = cryptoService.decrypt(PwdConfig.getEncryptedFile());
        List<Account> accountList = (new Gson()).fromJson(data,new TypeToken<List<Account>>(){}.getType());
        Optional<Account> targetAccount = accountList.stream().filter(item -> {
            return item.getKey().equals(key);
        }).findFirst();
        return targetAccount.get().getPassword();
    }

    public Map<String, Account> retrieveAll() {

        return null;
    }
}
