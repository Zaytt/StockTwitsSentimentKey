package stocktwits.model;

public class Symbol {

    int id;
    String symbol;
    String title;
    String[] aliases;
    boolean is_following;
    int watchlist_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public boolean isIs_following() {
        return is_following;
    }

    public void setIs_following(boolean is_following) {
        this.is_following = is_following;
    }

    public int getWatchlist_count() {
        return watchlist_count;
    }

    public void setWatchlist_count(int watchlist_count) {
        this.watchlist_count = watchlist_count;
    }
}
