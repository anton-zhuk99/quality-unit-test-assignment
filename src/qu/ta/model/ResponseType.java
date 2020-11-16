package qu.ta.model;

public enum ResponseType {

    FIRST_ANSWER("P"),
    NEXT_ANSWER("N");

    private final String str;

    ResponseType(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
