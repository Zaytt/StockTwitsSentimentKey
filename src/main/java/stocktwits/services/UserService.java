package stocktwits.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import stocktwits.mappers.APIUserMapper;
import stocktwits.model.User;
import stocktwits.model.login.APIUser;


@Service
public class UserService {

    @Autowired
    APIUserMapper apiUserMapper;
    @Autowired
    KeyService keyService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //add new user
    public APIUser createUser(APIUser user) {
        String newKey = keyService.generateKey();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setApikey(newKey);
        apiUserMapper.insertUser(user);

        return user;
    }

    //Validate user API key
    public boolean validateUserAPIKey(String key){
        APIUser apiUseruser = apiUserMapper.getUserByKey(key);
        if(apiUseruser == null) return false;

        return true;
    }
}
