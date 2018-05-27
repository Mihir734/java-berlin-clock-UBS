package com.ubs.opsit.interviews;

/**
 * @author Mihirkumar Shah
 */

class BerlinClock implements TimeConverter {

    static String getTopHours(int hours) throws Exception {
        if (hours < 0 || hours > 23) {
            throw new Exception("invalid input");
        }
        return getStatus(getTopNumberOfOnCounts(hours));
    }

    static String getBottomHours(int hours) throws Exception {
        if (hours < 0 || hours > 23) {
            throw new Exception("invalid input");
        }
        return getStatus(hours % 5);
    }

    static String getTopMinutes(int minutes) throws Exception {
        if (minutes < 0 || minutes > 59) {
            throw new Exception("invalid input");
        }
        return getStatus(11, getTopNumberOfOnCounts(minutes), "Y").replaceAll("YYY", "YYR");
    }

    static String getBottomMinutes(int minutes) throws Exception {
        if (minutes < 0 || minutes > 59) {
            throw new Exception("invalid input");
        }
        return getStatus(4, minutes % 5, "Y");
    }

    static String getSeconds(int seconds) throws Exception {
        if (seconds < 0 || seconds > 59) {
            throw new Exception("invalid input");
        }
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
        String out;
        try {
            out = getSeconds(Integer.parseInt(aTime.substring(6, 8))) + System.getProperty("line.separator") +
                    getTopHours(Integer.parseInt(aTime.substring(0, 2))) + System.getProperty("line.separator") +
                    getBottomHours(Integer.parseInt(aTime.substring(0, 2))) + System.getProperty("line.separator") +
                    getTopMinutes(Integer.parseInt(aTime.substring(3, 5))) + System.getProperty("line.separator") +
                    getBottomMinutes(Integer.parseInt(aTime.substring(3, 5)));
        } catch (Exception e) {
            out = e.getMessage();
        }
        return out;
    }
}