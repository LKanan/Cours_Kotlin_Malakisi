fun main(){
 val q1 = Quotient(5.0,2.0)
//    println(q1.calculer())
    val enseignant = Enseignant("Mohamed", 30)
    enseignant.manger()
    println(Quotient.attribut_de_class)
    Quotient.methode_de_class()
    val cours1 = Cours("Cours1", 15.0)
    val cours2 = Cours("Cours2", 17.0)
    val cours3 = Cours("Cours1", 15.0)
    println(cours1 == cours3)
    val (premiere_propriete) = cours1
    println(premiere_propriete)
    val (premiere_propriete_deuxiem_objet, deuxieme_propriete_deuxieme_objet ) = cours2
    println("$premiere_propriete_deuxiem_objet et $deuxieme_propriete_deuxieme_objet")
}
class Quotient(var num: Double, var den: Double) {
    init {
        num = 10.0
        println("numerateur $num et denominateur $den")
    }

    companion object{
        val attribut_de_class = "Ceci est un texte de class"
        fun methode_de_class(){
            println("Ceci est une methode de class")
        }
    }

    //Ce constructeur permet la creation d'un objet de la classe Quotient qui ne prend qu'un seul parametre à la creation, et c'est seulement le numerateur, sachant qu'on a donne une valeur par defaut au denominateur qui est 100
    constructor(pourcentage: Double) : this(pourcentage, 100.0)

    fun calculer() : Double{
        return num/den
    }
}

open class Personne(nom: String, age: Int){
    init{
        println("nom : $nom \nAge: $age")
    }
    fun marcher(){
        println("Entrain de marcher")
    }

    fun manger(){
        println("Entrain de manger")
    }
}

class Enseignant(val nom:String, val age:Int) : Personne(nom, age){
    fun enseigner(){
        println("Entrain d'enseigner")
    }
}

class Eleve(nom:String, age:Int) : Personne(nom, age){
    fun payerFraisScolaire(){
        println("Enrain de payer les frais scolaires")
    }
}

data class Cours(val nomCours:String, val note:Double){}