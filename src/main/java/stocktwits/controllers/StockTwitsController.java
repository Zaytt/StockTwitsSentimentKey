package stocktwits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import stocktwits.exception.APIUnavailableException;
import stocktwits.model.TickerStreamRoot;
import stocktwits.model.User;
import stocktwits.model.analyze.CompareSentiment;
import stocktwits.model.analyze.TickerSentiment;
import stocktwits.model.login.APIUser;
import stocktwits.services.StockTwitsService;
import stocktwits.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("stocktwits")
public class StockTwitsController {

    @Autowired
    StockTwitsService stockTwitsService;

    @Autowired
    UserService userService;

    @RequestMapping("/stream/{ticker:.+}")
    public TickerStreamRoot getTickerStream(@PathVariable(value="ticker")String ticker,
                                            @RequestParam(value="key")String key) {
        return stockTwitsService.getStreamTicker(ticker, key);
    }

    @RequestMapping("/sentiment/{ticker:.+}")
    public TickerSentiment getTickerSentiment(@PathVariable(value="ticker")String ticker,
                                              @RequestParam(value="key")String key) {
        return stockTwitsService.getSentimentByTicker(ticker, key);
    }

    @RequestMapping("/sentiment/{ticker:.+}/{datetime}")
    public TickerSentiment getTickerSentiment(@PathVariable(value="ticker")String ticker,
                                              @PathVariable(value="datetime")String datetime,
                                              @RequestParam(value="key")String key) {
        return stockTwitsService.getSentimentByPK(ticker, datetime, key);
    }

    @RequestMapping("/sentiment/compare")
    public CompareSentiment compareSentiment(@RequestParam(value="ticker1")String ticker1,
                                             @RequestParam(value="ticker2")String ticker2,
                                             @RequestParam(value="key")String key){
        return stockTwitsService.compareSentiment(ticker1, ticker2, key);
    }

    //----------TICKER SENTIMENT CRUD---------------

    // Create Ticker Sentiment
    @RequestMapping(method = RequestMethod.POST, value = "/sentiment")
    public TickerSentiment insertTickerSentiment(@RequestBody TickerSentiment tickerSentiment,
                                                 @RequestParam(value="key")String key) {
        return stockTwitsService.insertTickerSentiment(tickerSentiment, key);
    }

    // Read Ticker Sentiment History
    @RequestMapping(method= RequestMethod.GET, value = "/getsentiment/{ticker:.+}/{datetime}")
    public TickerSentiment getTickerSentimentDB(@PathVariable(value="ticker")String ticker,
                                                @PathVariable(value="ticker")String datetime,
                                                @RequestParam(value="key")String key) {
        return stockTwitsService.getSentimentByPK(ticker, datetime, key);
    }

    // Read Ticker Sentiment History
    @RequestMapping(method= RequestMethod.GET, value = "/getsentiment/{ticker:.+}")
    public ArrayList<TickerSentiment> getTickerSentimentHistory(@PathVariable(value="ticker")String ticker,
                                                                @RequestParam(value="key")String key) {
        return stockTwitsService.getTickerSentimentHistory(ticker, key);
    }

    // Update Ticker Sentiment
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public TickerSentiment updateByPK(@RequestBody TickerSentiment tickerSentiment,
                                      @RequestParam(value="key")String key) {
        return stockTwitsService.updateByPK(tickerSentiment, key);
    }

    // Delete Ticker Sentiment
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ticker:.+}/{datetime}")
    public TickerSentiment deleteByPK(@PathVariable(value="ticker")String ticker,
                                      @PathVariable(value="datetime")String datetime,
                                      @RequestParam(value="key")String key) {
        return stockTwitsService.deleteByPK(ticker, datetime, key);
    }

    @RequestMapping("/generror1")
    public ArrayList<User> generror1() throws APIUnavailableException {
        throw new APIUnavailableException();
    }

    //----------USERS CRUD---------------

    // Create APIUser
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public APIUser createUser(@RequestBody APIUser user) {
        return userService.createUser(user);
    }

}
