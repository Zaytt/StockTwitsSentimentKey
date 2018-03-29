package stocktwits.model.analyze;

import stocktwits.model.Message;
import stocktwits.model.TickerStreamRoot;

public class TickerSentiment {

    String ticker;
    String name;
    String datetime;
    int bullishcount;
    int bearishcount;
    int sentimentRating;


    public TickerSentiment() {
    }


    public TickerSentiment(TickerStreamRoot tickerStreamRoot) {
        //Set the attributes
        this.ticker = tickerStreamRoot.getSymbol().getSymbol();
        this.name = tickerStreamRoot.getSymbol().getTitle();

        this.bullishcount = getSentimentCount(tickerStreamRoot, "Bullish");
        this.bearishcount = getSentimentCount(tickerStreamRoot, "Bearish");
        this.setSentimentRating(calculateSentimentRating(bullishcount, bearishcount));
        this.setDatetime(getCurrentDateTime());

    }

    public int getSentimentCount(TickerStreamRoot tickerStreamRoot, String sentiment){
        int sentimentCount = 0;
        for (Message message: tickerStreamRoot.getMessages()) {
            if(message.getEntities().getSentiment() != null &&
                    message.getEntities().getSentiment().getBasic().compareTo(sentiment) == 0)
                sentimentCount++;
        }

        return sentimentCount;
    }

    public int calculateSentimentRating(int bullishCount, int bearishCount){
        double bullPercent =  ((double)bullishCount/(double)(bullishCount+bearishCount))*100;
        return (int)bullPercent;
    }

    public String getCurrentDateTime(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyyMMddHHmmss");

        return sdf.format(dt);
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBullishcount() {
        return bullishcount;
    }

    public void setBullishcount(int bullishcount) {
        this.bullishcount = bullishcount;
    }

    public int getBearishcount() {
        return bearishcount;
    }

    public void setBearishcount(int bearishcount) {
        this.bearishcount = bearishcount;
    }

    public int getSentimentRating() {
        return sentimentRating;
    }

    public void setSentimentRating(int sentimentRating) {
        this.sentimentRating = sentimentRating;
    }


}
