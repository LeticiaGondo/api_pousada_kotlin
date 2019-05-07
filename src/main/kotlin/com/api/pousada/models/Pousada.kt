package com.api.pousada.models

import javax.persistence.*

@Entity
@Table(name = "POUSADA")
class Pousada (nameParam: String, classificationParam: Int, nbRoomsParam: Int) {

    @Id
    @Column (name = "ID")
    var id: Long = 1L

    @Column (name = "QUARTOS_DESOCUPADOS")
    var nbFreeRooms: Int = nbRoomsParam

    @Column (name = "NAME")
    var name : String = nameParam

    @Column (name = "CLASSIFICACAO")
    var classification : Int = classificationParam

    @Column (name = "NUMERO_QUARTOS")
    var nbRooms: Int = nbRoomsParam
    
    fun checkIn(nbGuests : Int) {
        if (this.nbFreeRooms >= nbGuests){
            this.nbFreeRooms -= nbGuests
        }
    }

    fun checkOut(nbGuests: Int) {
        this.nbFreeRooms += nbGuests
    }






}