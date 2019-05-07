package com.api.pousada.controllers

import com.api.pousada.models.CheckIn
import com.api.pousada.models.CheckOut
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

    @PostMapping ("/checkIn")
    fun checkIn(@RequestBody checkIn: CheckIn) {
        var pousada = pousadaRepository.findById(checkIn.pousadaId).get()
        pousada.checkIn(checkIn.nbGuest)
        pousadaRepository.save(pousada)
    }

    @PostMapping ("/checkOut")
    fun checkOut (@RequestBody checkout: CheckOut) {
        var pousada = pousadaRepository.findById(checkout.pousadaId).get()
        pousada.checkOut(checkout.nbGuest)
        pousadaRepository.save(pousada)



    }
}

