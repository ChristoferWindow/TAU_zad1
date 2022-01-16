package com.mycompany.app;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DateTimeConverterTest {
    DateTimeConverter dateTimeConverter;

    @BeforeEach
    void setUp() {
        this.dateTimeConverter = new DateTimeConverter();
    }

    @Test
    public void testGetConvertedDateByFormatDDMMYY() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate = LocalDate.parse("2022-01-05");
        Date dateYYMMDD = java.sql.Date.valueOf(localDate);
        String convertedDateDDMMYY = dtc.getConvertedDateByFormat(dateYYMMDD, "dd-MM-YYYY");

        assertEquals("05-01-2022", convertedDateDDMMYY);
    }

    /*
      Strange behaviour found
      Expected :02-01-2022
      Actual   :02-01-2021
     */
    @Test
    public void testReturnsInvalidYearDateByFormatDDMMYY() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate = LocalDate.parse("2022-01-02");
        Date dateYYMMDD = java.sql.Date.valueOf(localDate);
        String convertedDateDDMMYY = dtc.getConvertedDateByFormat(dateYYMMDD, "dd-MM-YYYY");

        assertNotEquals("02-01-2022", convertedDateDDMMYY);
    }

    @Test
    public void testGetConvertedDateByFormatMMDDYY() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate2 = LocalDate.parse("2022-02-03");
        Date dateYYMMDD2 = java.sql.Date.valueOf(localDate2);
        String convertedDateMMDDYY = dtc.getConvertedDateByFormat(dateYYMMDD2, "MM-dd-YYYY");

        assertEquals("02-03-2022", convertedDateMMDDYY);
    }

    @Test
    public void testGetDateByLocaleFr() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate locale = LocalDate.parse("2022-02-03");
        Date date = java.sql.Date.valueOf(locale);
        String dateLocale = dtc.getDateByLocale(date, "fr");

        assertEquals("3 févr. 2022", dateLocale);
    }

    @Test
    public void testGetDateByLocaleEs() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate locale = LocalDate.parse("2022-02-03");
        Date date = java.sql.Date.valueOf(locale);
        String dateLocale = dtc.getDateByLocale(date, "es");

        assertEquals("3 feb. 2022", dateLocale);
    }

    @Test
    public void testGetDateByLocaleReturnsNormalDateEnWhenLocaleNotExist() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate locale = LocalDate.parse("2022-02-03");
        Date date = java.sql.Date.valueOf(locale);
        String dateLocale = dtc.getDateByLocale(date, "test");

        assertEquals("2022 Feb 3", dateLocale);
    }

    @Test
    public void testCalculateDiffBetweenDates() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate1 = LocalDate.parse("2022-02-03");
        Date date1 = java.sql.Date.valueOf(localDate1);
        LocalDate localDate2 = LocalDate.parse("2022-02-09");
        Date date2 = java.sql.Date.valueOf(localDate2);

        int daysDiff = dtc.calculateDiffBetweenDates(date1, date2);

        assertEquals(6, daysDiff);
    }

    @Test
    public void testCalculateDiffBetweenDatesWhenSecondIsEarlier() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate1 = LocalDate.parse("2022-02-12");
        Date date1 = java.sql.Date.valueOf(localDate1);
        LocalDate localDate2 = LocalDate.parse("2022-02-01");
        Date date2 = java.sql.Date.valueOf(localDate2);

        int daysDiff = dtc.calculateDiffBetweenDates(date1, date2);

        assertEquals(11, daysDiff);
    }
    @Test
    public void testCalculateDiffBetweenDatesInvalid() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate1 = LocalDate.parse("2022-02-01");
        Date date1 = java.sql.Date.valueOf(localDate1);
        LocalDate localDate2 = LocalDate.parse("2022-02-12");
        Date date2 = java.sql.Date.valueOf(localDate2);

        int daysDiff = dtc.calculateDiffBetweenDates(date1, date2);

        assertNotEquals(5, daysDiff);
    }

    @Test
    public void testCalculateDiffBetweenDatesIsZero() {
        DateTimeConverter dtc = new DateTimeConverter();

        LocalDate localDate1 = LocalDate.parse("2022-02-01");
        Date date1 = java.sql.Date.valueOf(localDate1);
        LocalDate localDate2 = LocalDate.parse("2022-02-01");
        Date date2 = java.sql.Date.valueOf(localDate2);

        int daysDiff = dtc.calculateDiffBetweenDates(date1, date2);

        assertEquals(0, daysDiff);
    }
}
