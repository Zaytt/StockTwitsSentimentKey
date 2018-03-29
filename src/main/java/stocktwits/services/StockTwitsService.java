package stocktwits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import stocktwits.mappers.StockTwitsMapper;
import stocktwits.model.TickerStreamRoot;
import stocktwits.model.analyze.CompareSentiment;
import stocktwits.model.analyze.TickerSentiment;

import java.util.ArrayList;

@Service
public class StockTwitsService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StockTwitsMapper stockTwitsMapper;

    public TickerStreamRoot getStreamTicker(String ticker){
        String fQuery = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker+".json";
        TickerStreamRoot tickerStreamRoot = restTemplate.getForObject(fQuery, TickerStreamRoot.class);

        return tickerStreamRoot;
    }

    public TickerSentiment getSentimentByPK(String ticker, String datetime){
        return stockTwitsMapper.getTickerSentimentByPK(ticker, datetime);
    }

    public ArrayList<TickerSentiment> getTickerSentimentHistory(String ticker){
        return stockTwitsMapper.getTickerSentimentHistory(ticker);
    }

    public CompareSentiment compareSentiment(String ticker1, String ticker2){
        String fQuery = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker1+".json";
        String fQuery2 = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker2+".json";

        //Get the last 30 messages of ticker1 and ticker2 streams.
        TickerStreamRoot tickerStreamRoot1 = restTemplate.getForObject(fQuery, TickerStreamRoot.class);
        TickerStreamRoot tickerStreamRoot2 = restTemplate.getForObject(fQuery2, TickerStreamRoot.class);

        CompareSentiment compareSentiment = new CompareSentiment(tickerStreamRoot1, tickerStreamRoot2);



        return compareSentiment;
    }

    //add new ticker sentiment
    public TickerSentiment insertTickerSentiment(TickerSentiment tickerSentiment) {
        stockTwitsMapper.insertSentiment(tickerSentiment);
        return stockTwitsMapper.getTickerSentimentByPK(tickerSentiment.getTicker(), tickerSentiment.getDatetime());
    }

    //update a ticker sentiment
    public TickerSentiment updateByPK(TickerSentiment tickerSentiment) {
        stockTwitsMapper.updateSentiment(tickerSentiment);
        return stockTwitsMapper.getTickerSentimentByPK(tickerSentiment.getTicker(), tickerSentiment.getDatetime());
    }

    //update a ticker sentiment
    public TickerSentiment deleteByPK(String ticker, String datetime) {
        TickerSentiment tickerSentiment = stockTwitsMapper.getTickerSentimentByPK(ticker, datetime);
        stockTwitsMapper.deleteSentiment(ticker, datetime);
        return tickerSentiment;
    }
    


}
