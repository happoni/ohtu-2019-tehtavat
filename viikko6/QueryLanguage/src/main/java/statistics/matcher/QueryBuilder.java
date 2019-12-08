package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;
    All all;
    PlaysIn playsIn;
    QueryBuilder query;
    
    public QueryBuilder() {
        this.matcher = new And();
        this.query = new QueryBuilder();
    }
        
    public QueryBuilder(Matcher matcher) {
        this.matcher = new And(matcher);
    }
//    
//    public QueryBuilder(PlaysIn playsIn) {
//        this.matcher = new And(playsIn);
//    }
//
//    public QueryBuilder(HasAtLeast hasAtLeast) {
//        this.matcher = new And(hasAtLeast);
//    }
//    
//    public QueryBuilder(HasFewerThan hasFewerThan) {
//        this.matcher = new And(hasFewerThan);
//    }
//    
    public Matcher build() {
        return this.matcher;
    }

    public QueryBuilder playsIn(String nyr) {
        this.query = new QueryBuilder(new PlaysIn(nyr));
        return this.query;        
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        return new QueryBuilder(new HasAtLeast(i, goals));
    }

    public QueryBuilder hasFewerThan(int i, String goals) {
        return new QueryBuilder(new HasFewerThan(i, goals));
    }

}
