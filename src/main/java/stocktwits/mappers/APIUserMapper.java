package stocktwits.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import stocktwits.model.login.APIKey;
import stocktwits.model.login.APIUser;

@Mapper
public interface APIUserMapper {
    String GET_USER_BY_ID = "SELECT * FROM `StockTwits`.user where user.user_id = #{id}";
    String GET_USER_BY_EMAIL = "SELECT * FROM `StockTwits`.user where user.email = #{email}";
    String INSERT_USER = "INSERT INTO `StockTwits`.user (active, email, last_name, name, password, apikey) " +
            "VALUES (#{active}, #{email}, #{last_name}, #{name}, #{password}, #{apikey})";
    String GET_USER_KEY = "SELECT * FROM `StockTwits`.user where user.apikey = #{key}";

    @Select(GET_USER_BY_ID)
    public APIUser getUserByID(String id);

    @Select(GET_USER_BY_EMAIL)
    public APIUser getUserByEmail(String email);

    @Select(GET_USER_KEY)
    public APIUser getUserByKey(String key);

    @Insert(INSERT_USER)
    public int insertUser(APIUser user);

}
