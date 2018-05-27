package com.ubs.opsit.interviews;

/**
 * @author Mihirkumar Shah
 */

class BerlinClock implements TimeConverter {

    private static String getTopHours(int hours) {
        return getStatus(getTopNumberOfOnCounts(hours));
    }

    private static String getBottomHours(int hours) {
        return getStatus(hours % 5);
    }

    private static String getTopMinutes(int minutes) {
        return getStatus(11, getTopNumberOfOnCounts(minutes), "Y").replaceAll("YYY", "YYR");
    }

    private static String getBottomMinutes(int minutes) {
        return getStatus(4, minutes % 5, "Y");
    }

    private static String getSeconds(int seconds) {
        if (seconds % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }

    private static String getStatus(int on) {
        return getStatus(4, on, "R");
    }

    private static String getStatus(int light, int onCount, String on) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < onCount; i++) {
            out.append(on);
        }
        for (int i = 0; i < (light - onCount); i++) {
            out.append("O");
        }
        return out.toString();
    }

    private static int getTopNumberOfOnCounts(int on) {
        return (on - (on % 5)) / 5;
    }

    @Override
    public String convertTime(String aTime) {
        String out =
                getSeconds(Integer.parseInt(aTime.substring(6, 8))) + System.getProperty("line.separator") +
                        getTopHours(Integer.parseInt(aTime.substring(0, 2))) + System.getProperty("line.separator") +
                        getBottomHours(Integer.parseInt(aTime.substring(0, 2))) + System.getProperty("line.separator") +
                        getTopMinutes(Integer.parseInt(aTime.substring(3, 5))) + System.getProperty("line.separator") +
                        getBottomMinutes(Integer.parseInt(aTime.substring(3, 5)));
        return out.intern();
    }

}