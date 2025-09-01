fun main(){
    afficher("toto")
    afficher(12)
    afficher(true)
    afficher(12.5f)

    val object_ui_1 = UI("toto", "interface graphique 1")
    val object_ui_2 = UI(578, "interface graphique 2")
    object_ui_1.afficher()
    object_ui_2.afficher()
}

//Fonction ave notion de generique
//entre les chervrons on peut mettre n'importe quelle lettre pour representer le type generique mais par convention on met T
fun <T> afficher( donnee: T) {
    println(donnee)
}

class UI <T>(val donnee:T, val nom_interface:String){
    fun afficher(){
        println("caracteristiques, nom :$nom_interface,  donnee: $donnee")
    }
}