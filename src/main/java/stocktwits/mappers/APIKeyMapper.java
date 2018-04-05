package stocktwits.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import stocktwits.model.login.APIKey;

@Mapper
public interface APIKeyMapper {

    String GET_KEY = "SELECT * FROM `StockTwits`.apikey where apikey.key = #{key}";
    String GET_KEY_ACTIVE = "SELECT * FROM `StockTwits`.apikey where apikey.key = #{key} AND active = 1";
    //String INSERT_KEY = "INSERT INTO `StockTwits`.apikey (key, active) VALUES (#{key}, 1)";

    @Select(GET_KEY)
    public APIKey getAPIKey(String key);

    @Select(GET_KEY_ACTIVE)
    public APIKey getAPIKeyActive(String key);

//    @Insert(INSERT_KEY)
//    public int createKey(String key);
}
