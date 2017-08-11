package instances;

public enum Symbol {
    LINE_SEPARATOR("\n");

    private String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
