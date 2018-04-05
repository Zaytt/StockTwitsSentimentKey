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
    String INSERT_USER = "INSERT INTO `StockTwits`.user (active, email, last_name, name, password, api_key) " +
            "VALUES (#{active}, #{email}, #{last_name}, #{name}, #{password}, #{api_key})";


    @Select(GET_USER_BY_ID)
    public APIUser getUserByID(String id);

    @Select(GET_USER_BY_EMAIL)
    public APIUser getUserByEmail(String email);

    @Insert(INSERT_USER)
    public int insertUser(APIUser user);

}
