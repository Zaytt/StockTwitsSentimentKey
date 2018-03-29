package stocktwits.mappers;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import stocktwits.model.analyze.TickerSentiment;

import java.util.ArrayList;

@Mapper
public interface StockTwitsMapper {

    String GET_TICKER_SENTIMENT_PK = "SELECT * FROM `Stocktwits`.sentiment where ticker = #{arg0} AND " +
                                        "datetime = #{arg1}";
    String GET_TICKER_SENTIMENT_HISTORY = "SELECT * FROM `Stocktwits`.sentiment where ticker = #{ticker}";
    String INSERT_SENTIMENT = "INSERT INTO `Stocktwits`.sentiment (ticker, datetime, name, bullishcount, bearishcount, " +
                                                                   "sentimentRating) " +
            "VALUES (#{ticker}, #{datetime}, #{name}, #{bullishcount}, #{bearishcount},#{sentimentRating})";
    String UPDATE_SENTIMENT = "UPDATE `Stocktwits`.sentiment SET bullishcount = #{bullishcount}, " +
            "bearishcount = #{bearishcount}, sentimentRating = #{sentimentRating} " +
            "WHERE ticker = #{ticker} AND datetime = #{datetime}";
    String DELETE_SENTIMENT = "DELETE FROM StockTwits.sentiment " +
            "WHERE ticker = #{arg0} AND datetime = #{arg1}";

    @Select(GET_TICKER_SENTIMENT_PK)
    public TickerSentiment getTickerSentimentByPK(String ticker, String datetime);

    @Select(GET_TICKER_SENTIMENT_HISTORY)
    public ArrayList<TickerSentiment> getTickerSentimentHistory(String ticker);

    @Insert(INSERT_SENTIMENT)
    public int insertSentiment(TickerSentiment tickerSentiment);

    @Update(UPDATE_SENTIMENT)
    public int updateSentiment(TickerSentiment tickerSentiment);

    @Update(DELETE_SENTIMENT)
    public int deleteSentiment(String ticker, String datetime);

}
