package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkolaController {

    private final SkolaService service;

    public SkolaController(SkolaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznamTrid() {
        ModelAndView seznam = new ModelAndView("seznam");
        seznam.addObject("seznam", service.seznam());
        return seznam;
    }

    @GetMapping("/{id}")
    public ModelAndView jednaTrida(@PathVariable Short id) {
        ModelAndView trida = new ModelAndView("trida");
        trida.addObject("trida", service.jednaTrida(id).get());
        return trida;
    }

    @GetMapping("/zak/{id}")
    public ModelAndView jedenZak(@PathVariable Integer id) {
        ModelAndView zak = new ModelAndView("zak");
        zak.addObject("zak", service.jedenStudent(id).get());
        return zak;
    }
}
