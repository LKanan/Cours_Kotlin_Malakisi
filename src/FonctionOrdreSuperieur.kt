fun main() {
    val personne = Person()
    nomDePersonne(personne, ::recupererNom)
//    utilisation d'une fonction lambda forme 1
//    Ici la variable nom represente la valeur de la variable attendu de la fonction, ca represente le parametre de la fonction lambda dont la logique suit
    nomDePersonne(personne, { nom ->
        recupererNom(nom) })
//    utilisation d'une fonction lambda forme 2
//    Si on ne precise pas le nom du parametre, la valeur chargeee dans lafonction lambda aura comme nom it
    nomDePersonne(personne, {
        println("Le nom de la personne est ${it.uppercase()}") })
//    utilisation d'une fonction lambda forme 3
//    Dans cette troisieme forme on dit que on peut placer la fonction lambda comme si c'etait le corps de l'appel de cette fonction mais sans oublier que c'est un parametre
    nomDePersonne(personne){
        println("Le nom de la personne est ${it.uppercase()}") }
}

data class Person(val nom: String = "Louis", val post_nom: String = "Toto")

fun nomDePersonne(personne: Person, fn: (String) -> Unit) {
    fn(personne.nom)
}

fun recupererNom(nom: String) {
    println("Le nom de la personne est $nom")
}