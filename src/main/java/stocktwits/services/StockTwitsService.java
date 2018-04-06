package stocktwits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import stocktwits.exception.APIUnavailableException;
import stocktwits.exception.SymbolNotFoundException;
import stocktwits.mappers.StockTwitsMapper;
import stocktwits.model.StockTwitsResponse;
import stocktwits.model.TickerStreamRoot;
import stocktwits.model.analyze.CompareSentiment;
import stocktwits.model.analyze.TickerSentiment;

import java.util.ArrayList;

@Service
public class StockTwitsService {

//    @Value("this.is.ryan")
//    String ryanVal;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StockTwitsMapper stockTwitsMapper;

    @Autowired
    UserService userService;



    public TickerStreamRoot getStreamTicker(String ticker)
            throws SymbolNotFoundException, RestClientException, APIUnavailableException {


        String fQuery = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker+".json";
        TickerStreamRoot tickerStreamRoot = null;
        try {
            tickerStreamRoot = restTemplate.getForObject(fQuery, TickerStreamRoot.class);
        } catch (HttpClientErrorException e) {
            if(e.getRawStatusCode() == 404)
                throw new SymbolNotFoundException();
        } catch (RestClientException e) {
            throw e;
        }

        if(tickerStreamRoot == null)
            throw new APIUnavailableException();

        return tickerStreamRoot;


    }

    public TickerSentiment getSentimentByPK(String ticker, String datetime){

        return stockTwitsMapper.getTickerSentimentByPK(ticker, datetime);
    }

    public TickerSentiment getSentimentByTicker(String ticker)
            throws SymbolNotFoundException, RestClientException, APIUnavailableException {
        String fQuery = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker+".json";
        TickerStreamRoot tickerStreamRoot = null;
        try {
         tickerStreamRoot = restTemplate.getForObject(fQuery, TickerStreamRoot.class);
        } catch (HttpClientErrorException e) {
            if(e.getRawStatusCode() == 404)
                throw new SymbolNotFoundException();
        } catch (RestClientException e) {
            throw e;
        }

        if(tickerStreamRoot == null)
            throw new APIUnavailableException();

        TickerSentiment tickerSentiment = new TickerSentiment(tickerStreamRoot);
        return tickerSentiment;
    }

    public ArrayList<TickerSentiment> getTickerSentimentHistory(String ticker){
        ArrayList<TickerSentiment> tickerSentimentArrayList = null;
        try {
            tickerSentimentArrayList = stockTwitsMapper.getTickerSentimentHistory(ticker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickerSentimentArrayList;
    }

    public CompareSentiment compareSentiment(String ticker1, String ticker2) {
        String fQuery = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker1+".json";
        String fQuery2 = "https://api.stocktwits.com/api/2/streams/symbol/"+ticker2+".json";

        //Get the last 30 messages of ticker1 and ticker2 streams.
        TickerStreamRoot tickerStreamRoot1 = restTemplate.getForObject(fQuery, TickerStreamRoot.class);
        TickerStreamRoot tickerStreamRoot2 = restTemplate.getForObject(fQuery2, TickerStreamRoot.class);

        CompareSentiment compareSentiment = new CompareSentiment(tickerStreamRoot1, tickerStreamRoot2);



        return compareSentiment;
    }

    //add new ticker sentiment
    public TickerSentiment insertTickerSentiment(TickerSentiment tickerSentiment){
        stockTwitsMapper.insertSentiment(tickerSentiment);
        return stockTwitsMapper.getTickerSentimentByPK(tickerSentiment.getTicker(), tickerSentiment.getDatetime());
    }

    //update a ticker sentiment
    public TickerSentiment updateByPK(TickerSentiment tickerSentiment){
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
