package stocktwits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocktwits.mappers.APIKeyMapper;
import stocktwits.model.login.APIKey;

import java.util.UUID;

@Service
public class KeyService {

    @Autowired
    APIKeyMapper aPIKeyMapper;

    public APIKey getAPIKey(String key){
        return aPIKeyMapper.getAPIKey(key);
    }

    public APIKey getAPIKeyActive(String key){
        return aPIKeyMapper.getAPIKeyActive(key);
    }

    public boolean validateKey(String key){
        if(getAPIKey(key) == null) {
            System.out.println("Authentication Error: Non existent API Key");
            return false;
        }
        if(getAPIKeyActive(key) == null) {
            System.out.println("Expired API Key");
            return false;
        }
        return true;
    }

//    public APIKey createKey(){
//        UUID uuid = UUID.randomUUID();
//        //aPIKeyMapper.createKey(uuid.toString());
//        APIKey newKey = aPIKeyMapper.getAPIKey(uuid.toString());
//        return newKey;
//    }
    public String generateKey(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
