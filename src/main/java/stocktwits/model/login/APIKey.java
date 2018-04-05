package stocktwits.model.login;

public class APIKey {

    private int apikey_id;
    private String key;
    private int active;

    public int getApikey_id() {
        return apikey_id;
    }

    public void setApikey_id(int apikey_id) {
        this.apikey_id = apikey_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
