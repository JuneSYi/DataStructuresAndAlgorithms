public class secondEnum {
    firstEnum day;

    public secondEnum(firstEnum chooseDay) {
        this.day = chooseDay;
    }
    public void expressionOfTheDay() {
        switch (day) {
            case SUNDAY:
                System.out.println("Sundays are relaxing");
                break;
            case MONDAY:
                System.out.println("Mondays are awful");
                break;
            case FRIDAY:
                System.out.println("Fridays are the best");
                break;
            case SATURDAY:
                System.out.println("Saturdays are for partying");
                break;
            default:
                System.out.println("middle of the week are slow");
                break;
        }
    }


    public static void main(String[] args) {
//        firstEnum business = firstEnum.MONDAY;
//        if (business == firstEnum.MONDAY) {
//            System.out.println(firstEnum.getVerb("Enum is good"));
//        }


        secondEnum program = new secondEnum(firstEnum.SUNDAY);
        program.expressionOfTheDay();
        secondEnum friday = new secondEnum(firstEnum.FRIDAY);
        friday.expressionOfTheDay();
        secondEnum middle = new secondEnum(firstEnum.WEDNESDAY);
        middle.expressionOfTheDay();
        firstEnum newArray[] = firstEnum.values();
        for (firstEnum enumValues : newArray) {
            System.out.println(enumValues);
        }
    }
}
