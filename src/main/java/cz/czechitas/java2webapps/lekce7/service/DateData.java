package cz.czechitas.java2webapps.lekce7.service;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Filip Jirsák
 */
public class DateData {
  private final String label;
  private final LocalDate date;

  public DateData(String label, LocalDate date) {
    this.label = label;
    this.date = date;
  }

  public String getLabel() {
    return label;
  }

  public LocalDate getDate() {
    return date;
  }
}
