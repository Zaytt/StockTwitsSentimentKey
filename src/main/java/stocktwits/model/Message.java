package stocktwits.model;

public class Message {

    int id;
    String body;
    String created_at;
    User user;
    Source source;
    Symbol[] symbols;
    User[] mentionedUsers;
    Entity entities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Symbol[] getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbol[] symbols) {
        this.symbols = symbols;
    }

    public User[] getMentionedUsers() {
        return mentionedUsers;
    }

    public void setMentionedUsers(User[] mentionedUsers) {
        this.mentionedUsers = mentionedUsers;
    }

    public Entity getEntities() {
        return entities;
    }

    public void setEntities(Entity entities) {
        this.entities = entities;
    }
}
