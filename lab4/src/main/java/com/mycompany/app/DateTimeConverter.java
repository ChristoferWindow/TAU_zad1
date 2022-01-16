package com.mycompany.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateTimeConverter {

    public String getConvertedDateByFormat(Date date, String dateFormat){
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        return formatter.format(date);
    }

    public String getDateByLocale(Date date,String language) {
        Locale locale = new Locale(language);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        return dateFormat.format(date);
    }

    public int calculateDiffBetweenDates(Date earlier, Date later) {
        long diffInMillis = Math.abs(later.getTime() - earlier.getTime());

        return (int) TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
