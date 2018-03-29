package stocktwits.model.analyze;

import stocktwits.model.TickerStreamRoot;

public class CompareSentiment {

    TickerSentiment tickerSentiment1;
    TickerSentiment tickerSentiment2;

    public CompareSentiment() {
    }

    public CompareSentiment(TickerStreamRoot tickerStreamRoot1, TickerStreamRoot tickerStreamRoot2) {
        this.tickerSentiment1 = new TickerSentiment(tickerStreamRoot1);
        this.tickerSentiment2 = new TickerSentiment(tickerStreamRoot2);
    }

    public TickerSentiment getTickerSentiment1() {
        return tickerSentiment1;
    }

    public void setTickerSentiment1(TickerSentiment tickerSentiment1) {
        this.tickerSentiment1 = tickerSentiment1;
    }

    public TickerSentiment getTickerSentiment2() {
        return tickerSentiment2;
    }

    public void setTickerSentiment2(TickerSentiment tickerSentiment2) {
        this.tickerSentiment2 = tickerSentiment2;
    }
}
