package support.enums;

public enum Title {

    MR(1),
    MRS(2);

    private Integer idSuffix;

    Title(Integer value) {
        this.idSuffix = value;
    }

    public Integer getIdSuffix() {
        return idSuffix;
    }
}

