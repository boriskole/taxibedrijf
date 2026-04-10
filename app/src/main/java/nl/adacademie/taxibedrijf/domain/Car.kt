package nl.adacademie.taxibedrijf.domain

data class Car(val kenteken: String, val voertuigsoort: String) {
    override fun toString(): String {
        return "Kenteken: $kenteken \nVoertuigsoort: $voertuigsoort"
    }
}