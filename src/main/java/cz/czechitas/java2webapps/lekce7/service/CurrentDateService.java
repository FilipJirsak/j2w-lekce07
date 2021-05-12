package cz.czechitas.java2webapps.lekce7.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author Filip Jirsák
 */
@Service
public class CurrentDateService {

  public LocalDate currentDate() {
    return LocalDate.now();
  }
}
