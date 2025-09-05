package model
class Rectangulo(var color:Int, var ancho:Int, var alto: Int) {

    //coordenadas iniciales.
    var x: Int = 0
    var y: Int = 0

// Comportamientos

    fun moverArriba() {

        y -= 10
    }
    fun moverAbajo(){
        y+=10
    }
    fun moverIzquierda(){
        x-=10
    }
    fun moverDerecha(){
        x+=10
    }
}