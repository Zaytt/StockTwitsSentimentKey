package stocktwits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stocktwits.model.TickerStreamRoot;
import stocktwits.model.analyze.CompareSentiment;
import stocktwits.model.analyze.TickerSentiment;
import stocktwits.services.StockTwitsService;

import java.util.ArrayList;

@RestController
@RequestMapping("stocktwits")
public class StockTwitsController {

    @Autowired
    StockTwitsService stockTwitsService;

    @RequestMapping("/stream/{ticker}")
    public TickerStreamRoot getTickerStream(@PathVariable(value="ticker")String ticker) {
        return stockTwitsService.getStreamTicker(ticker);
    }

    @RequestMapping("/sentiment/{ticker}/{datetime}")
    public TickerSentiment getTickerSentiment(@PathVariable(value="ticker")String ticker,
                                              @PathVariable(value="datetime")String datetime) {
        return stockTwitsService.getSentimentByPK(ticker, datetime);
    }

    @RequestMapping("/compare")
    public CompareSentiment compareSentiment(@RequestParam(value="ticker1")String ticker1,
                                             @RequestParam(value="ticker2")String ticker2){
        return stockTwitsService.compareSentiment(ticker1, ticker2);
    }

    // Create Ticker Sentiment
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public TickerSentiment insertTickerSentiment(@RequestBody TickerSentiment tickerSentiment) {
        return stockTwitsService.insertTickerSentiment(tickerSentiment);
    }

    // Read Ticker Sentiment
    @RequestMapping(method= RequestMethod.GET, value = "/{ticker:.+}")
    public ArrayList<TickerSentiment> getTickerSentimentHistory(@PathVariable(value="ticker")String ticker) {
        return stockTwitsService.getTickerSentimentHistory(ticker);
    }

    // Update Ticker Sentiment
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public TickerSentiment updateByPK(@RequestBody TickerSentiment tickerSentiment) {
        return stockTwitsService.updateByPK(tickerSentiment);
    }

    // Delete Ticker Sentiment
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ticker:.+}/{datetime}")
    public TickerSentiment deleteByPK(@PathVariable(value="ticker")String ticker,
                                      @PathVariable(value="datetime")String datetime) {
        return stockTwitsService.deleteByPK(ticker, datetime);
    }

}
