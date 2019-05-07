package com.api.pousada.controllers

import com.api.pousada.models.Pousada
import com.api.pousada.repository.PousadaRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping ("api")
class PousadaController (val pousadaRepository: PousadaRepository) {

    @GetMapping("/teste")
    fun teste () : String {
        return "teste ok"

    }

    @GetMapping ("/all")
    fun all () : MutableIterable<Pousada> {
        return pousadaRepository.findAll()
    }

    @GetMapping ("/pousadaById/{id}")
    fun getPousadaById (@PathVariable("id") id : Long ): Optional<Pousada> {
        return pousadaRepository.findById(id)
    }

    @PostMapping ("/newPousada")
    fun newPousada(@RequestBody pousada: Pousada) {
        pousadaRepository.save(pousada)
    }

    @GetMapping ("/deleteById/{id}")
    fun deleteById (@PathVariable("id") id : Long){
        pousadaRepository.deleteById(id)
    }
}