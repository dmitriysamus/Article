public enum TestNumber {
    М11 ("M.1.1"),
    М12 ("M.1.2"),
    М13 ("M.1.3"),
    М14 ("M.1.4"),
    М15 ("M.1.5"),
    М16 ("M.1.6");

    private String value;

    TestNumber(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
