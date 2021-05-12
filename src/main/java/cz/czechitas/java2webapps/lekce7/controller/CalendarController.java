package cz.czechitas.java2webapps.lekce7.controller;

import cz.czechitas.java2webapps.lekce7.service.CalendarData;
import cz.czechitas.java2webapps.lekce7.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Filip Jirsák
 */
@Controller
public class CalendarController {

  private final CalendarService service;

  @Autowired
  public CalendarController(CalendarService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String index(@ModelAttribute("calendar") CalendarData data) {
    return "index";
  }

  @GetMapping("/vypocet")
  public String form(int rok, String typ) {
    return String.format("redirect:/%s/%d", typ, rok); //vrací to samé, jako return "redirect:/"+typ+"/"+rok;
  }

  @GetMapping("/easter/{year}")
  public ModelAndView easter(@PathVariable int year) {
    return new ModelAndView("easter")
            .addObject("year", year)
            .addObject("calendar", service.easter(year));
  }

  @GetMapping("/pentecost/{year}")
  public ModelAndView pentecost(@PathVariable int year) {
    return new ModelAndView("pentecost")
            .addObject("year", year)
            .addObject("calendar", service.pentecost(year));
  }

  @GetMapping("/christmas/{year}")
  public ModelAndView christmas(@PathVariable int year) {
    return new ModelAndView("christmas")
            .addObject("year", year)
            .addObject("calendar", service.christmas(year));
  }

  @GetMapping("/sylvester/{year}")
  public ModelAndView sylvester(@PathVariable int year) {
    return new ModelAndView("sylvester")
            .addObject("year", year)
            .addObject("calendar", service.sylvester(year));
  }

//Univerzální metoda, která hledá typ svátku dynamicky a pokud jej nenajde, vrací výchozí stránku.
  /*
  @GetMapping("/{type}/{year}")
  public Object detail(@PathVariable int year, @PathVariable String type) {
    ModelAndView modelAndView;
    switch (type) {
      case "sylvester":
        modelAndView = new ModelAndView(type);
        modelAndView.addObject("calendar", service.sylvester(year));
        break;
      case "christmas":
        modelAndView = new ModelAndView(type);
        modelAndView.addObject("calendar", service.christmas(year));
        break;
      case "easter":
        modelAndView = new ModelAndView(type);
        modelAndView.addObject("calendar", service.easter(year));
        break;
      case "pentecost":
        modelAndView = new ModelAndView(type);
        modelAndView.addObject("calendar", service.pentecost(year));
        break;
      default:
        return "forward:/default.html";
    }
    modelAndView.addObject("year", year);
    return modelAndView;
  }
  */

}
