public enum firstEnum {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public static firstEnum getVerb(String verbString) {

        return firstEnum.valueOf(verbString.toUpperCase());
    }
}
