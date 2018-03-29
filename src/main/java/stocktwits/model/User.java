package stocktwits.model;

public class User {
    int id;
    String username;
    String name;
    String avatar_url;
    String avatar_url_ssl;
    String join_date;
    boolean official;
    String identity;
    String[] classification;
    int followers;
    int following;
    int ideas;
    int watchlist_stocks_count;
    int ike_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url_ssl() {
        return avatar_url_ssl;
    }

    public void setAvatar_url_ssl(String avatar_url_ssl) {
        this.avatar_url_ssl = avatar_url_ssl;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String[] getClassification() {
        return classification;
    }

    public void setClassification(String[] classification) {
        this.classification = classification;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getIdeas() {
        return ideas;
    }

    public void setIdeas(int ideas) {
        this.ideas = ideas;
    }

    public int getWatchlist_stocks_count() {
        return watchlist_stocks_count;
    }

    public void setWatchlist_stocks_count(int watchlist_stocks_count) {
        this.watchlist_stocks_count = watchlist_stocks_count;
    }

    public int getIke_count() {
        return ike_count;
    }

    public void setIke_count(int ike_count) {
        this.ike_count = ike_count;
    }
}
