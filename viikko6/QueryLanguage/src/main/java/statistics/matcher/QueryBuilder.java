package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        this.matcher = new And(this.matcher, new HasAtLeast(i, goals));
        return this;
    }

    public QueryBuilder hasFewerThan(int i, String goals) {
        this.matcher = new And(this.matcher, new HasFewerThan(i, goals));
        return this;
    }

    public QueryBuilder or(Matcher... matcher) {
        this.matcher = new And(this.matcher, new Or(matcher));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(this.matcher, new Or(matchers));
        return this;
    }

    public Matcher build() {
        Matcher m = this.matcher;
        this.matcher = new All();
        return m;
    }

}
