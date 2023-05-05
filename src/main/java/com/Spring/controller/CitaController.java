package com.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.entity.Cita;
import com.Spring.repository.CitaRepository;


@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaRepository citaRepository;
    
    @Autowired
    public CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping("/agendar")
    public String agendarCita(Model model) {
        model.addAttribute("cita", new Cita());
        return "user-form/cita-scheduller";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita) {
        citaRepository.save(cita);
        //return "user-form/user-view";
        return "redirect:/citas/agendar";
    }

    @GetMapping("/citas-mostrar")
    public String mostrarCitas(Model model) {
        List<Cita> citas = citaRepository.findAll();
        model.addAttribute("appointmentList", citas);
        return "user-form/cita-scheduller";
    }

}