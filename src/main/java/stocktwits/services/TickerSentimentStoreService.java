package stocktwits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import stocktwits.model.analyze.TickerSentiment;

import java.lang.annotation.Repeatable;

public class TickerSentimentStoreService {
    @Autowired
    StockTwitsService stockTwitsService;

    @Value("${list.stocks}")
    private String stocklist;

    @Value("${list.crypto}")
    private String cryptolist;

    @Scheduled(cron = "0 0 9-17 * * MON-FRI")
    public void storeStocks(){
        String[] stocksArray = stocklist.split(",");
        for (String ticker: stocksArray) {
            TickerSentiment tickerSentiment =stockTwitsService.getSentimentByTicker(ticker);
            stockTwitsService.insertTickerSentiment(tickerSentiment);
        }
    }

    @Scheduled(cron = "0 0 * * * *")
    public void storeCrypto(){

        String[] stocksArray = cryptolist.split(",");
    }

}
