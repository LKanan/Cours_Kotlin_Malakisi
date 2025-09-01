# Cours_Kotlin_Malakisi

Cours de Kotlin sur base du tuto de Malakisi https://www.youtube.com/watch?v=ZNz3u88VAA0&amp;list=PLT2KSPhMMiqqd3hRyTiyyja6ic9TiiV1S

## Declaration de variable

Le mot clé **var** permet de declarer une variable mutable(qui peut changer) tandis que le mot clé **val** permet de délarer une variable constante ou pour laquele la valeur ne sera pas modifiée par la suite.

- **Déclaration simple avec précision du type**

`var ou val` nom_variable : type_variable

- **Déclaration et initialisation avec précision du type**

`var ou val` nom_variable : type_variable = valeur_initiale

- **Déclaration et initialisation qui fixe automatiquement le type de la variable**

`var ou val` nom_variable = valeur_initiale

## Structure itérative when(){}

Cette structure remplace le switch case dans d'autres langages

**Syntaxe générale**

```kotlin
when(variable_a_tester){
valeur_1 -> //expression
valeur_2 -> {
//expression
}
in valeur_debut_intervalle..valeur_finale_intervalle -> //expression
1,2,3,5,6,8 -> {
//expression qui s'execute si la valeur de la variable_a_tester est égale à l'une de valeur de la liste donnée
}
is  type_primitif ou classe -> {
//expression s'execute si variable_a_tester est du type_indiqué
}
else -> {
//expression s'execute si aucune des otption prédefinies n'a été éxecutée
}
}
```

## Structure itérative for(){}

**Syntaxe**

```kotlin
for(variable_d_iteartion in valeur_debut_intervalle..valeur_finale_intervalle){
//expessions
}
```

## Programmation orientée objet

une classe se declare généralement avec la syntaxe:

- **Généralement**

```kotlin
class NomClass(){
var attribut_1 : type_attribut
var attribut_2 : type_attribut = valeur_initiale
}
```

on peut la déclarer en donnant les parametre ainsi dans la fonction main:

```kotlin

val objet_1 : NomClasse = NomClasse()
objet_1.attribut_1 = valeur_attribut1
```

- **Deuxième methode**

```kotlin
class NomClass(val attribut_1 : type_attribut, val attribut_2 : type_attribut){

}
```

on peut la déclarer en donnant les parametre ainsi dans la fonction main:

```kotlin
val objet_1 = NomClass(valeur_attribut_1, valeur_attribut_2)
```

Dans une classe Kotlin il existe une fonction speciale `init{}` cette fonction permet permet d'executer un certain code à la creation d'un nouvel objet de la classe, ce code peut meme influer sur les valeurs des paramettres au besoin, et faut savoir qu'elle s'execute à chaque instanciation de la classe.

Ex:

```kotlin
class NomClasse(val attribut_1 : type_attribut, val attribut_2: type_attribut){
init{
attrribut_1 = 3
attribut_2 = "a"
}
```

on peut aussi concevoir un constructeur secondaire ne faisant par exemple:

```kotlin
class Quotient(val num: Double, val den: Double){
init{
println("numerateur $num et denominateur $den")
}
//Ce constructeur permet la creation d'un objet de la classe Quotient qui ne prend qu'un seul parametre à la creation, et c'est seulement le numerateur, sachant qu'on a donne une valeur par defaut au denominateur qui est 100
constructor(pourcentage: Double): this(pourcentage, 100)
}
```

pour l'eritage de classe en Kotlin, faut savoir qu'à la création des classes elles sont par defaut final ce qui signifie qu'elle ne peuvent etre héritée, dans ce cas il faut ajouter le mot clé open au debut de la class qui devra etre héritée comme ceci:

```kotlin
open class NomClass(){
}
```

Exemple:

```kotlin
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
```

Faut pas oublier qu'en heritant d'une classe, en instanciant la classe fille, la methode `init` de la classe mere s'executera aussi.

Si on veut redefinir une methode de la classe mère il faudra que cette fonction soit déclarée avec le mot clé `open` devant dans a classe mere; exemple

`open fun marcher(){}` et à la redéfinition on fera juste au debut de la fonction `override fun marcher(){}`, on peut acceder aux methodes ou aux proprietes d'une classe en utilisant le mot clé `super` exemples: `super.manger() ou super.marcher()`

**Lorsqu'on fait de l'orienté objet, on voit si il y a des indices qui nous meneraient à avoir une classe mère quelque part, si oui on la met et si elle existe, alors on doit encore verifier si il y a des possibilite ou s'il y a quelque part dans le code où on aura besoin de l'instancier sinon elle doit devenir une classe abstraite qui n'implemente rien et qui ne peut etre instanciée**

Une classe abstraite se déclare avec la syntaxe générale `abstract class NomClass(){}`, s'il y a des attribut, on les place et une classe abstraite est par defaut `open` ce qui signifie qu'elle est héritable, sans oublier qu'on peut aussi déclarer des fonctions abstraites dans la classe abstraite avec la syntaxe `abstract nomFoction()`, s'il y a aumoins une methode abstraite qui a été declarée il faut nécessairement redefinir cette methode(l'implementer) dans toutes les classes filles sinon il y aura des erreurs.

En Kotlin il n' y a pas d'heritage multiple.

**En Kotlin, si on veut definir cetaines propriètés(methode, attribut) comme des proprietes de classe il faut mettre ces proprietes dans une fonction speciale avec cette syntaxe `companion object{}`, ces proprietes seront accessible directement sur la classe on aura pas besoin d'un objet de la classe pour y acceder**

**Exemple :**

```kotlin

class NomClass{
companion object{
fun marcher(){
println("Entrain de marcher")
}
}
}

//Pour utiliser cette methode dans la fonction main, on fera:
fun main(){
NomClass.marcher()
}
```

## Types de classes kotlin

### 1. Classe de type object

Cette classe implemente la logique de classe singleton, avec cette classe on a possibilité d'avoir seulement une seule instance, ce qui signifie que meme si on tente de creer une autre instance, il ira prendre l'adresse de l'instance deja cree et remettre ca, une classe object n'a pas besoin d'un constructeur et ne supporte pas le companion object puisque deja toutes ses proprietes, on peut y acceder par le nom de la classe.

**Syntaxe de creation d'une classe object**

```kotlin
object class NomClassSingleton{
val attribut_1 : String = "Hello"
}
```

**Syntaxe d'instanciation d'une classe object**

```kotlin
fun main(){
//Instanciation
val object_singleton = NomClassSingleton
//Acces aux attributs
object_singleton.attribut1
}
```

### 2. Classe de type data

Les data class en Kotlin c'es un type de class qui permet de bien contextualiser les données; les objets sont représentées par les valeurs de leurs proprieté; ce aui fait que deux objets ayant les meme valeur de proprietes(ouattribut) sont egaux, la comparaison ne se fait pas sur les adresses mais plutot les valeur de proprietes, ce qui pourait aider pour eviter les doublons.

**Syntaxe de creation de la class**

```kotlin
data class NomClass{
val attribut_1: String,
val attribut_2: Int
}
```

**Syntaxe d'instaciation et comparaison d'objets(donnees)**

```kotlin
fun main(){
val objet_1 = NomClass()
objet_1.attribut_1 = "toto"
objet_1.attribut_2 = 4

val objet_2 = NomClass()
objet_2.attribut_1 = "toto"
objet_2.attribut_2 = 4

println(objet_1 == objet_2)
//va afficher true
}
```

**Cette classe permet aussi ce qu'on appelle la destructuration d'objet, ce qui fait qu'on peut qu'on peut mettre les valeur de certains attributs d'un objet dans des vaeriables particuliere de ctte facon :**

```kotlin
val cours2 = Cours("Cours2", 17.0)

val (premiere_propriete_deuxiem_objet, deuxieme_propriete_deuxieme_objet ) = cours2
println("$premiere_propriete_deuxiem_objet et $deuxieme_propriete_deuxieme_objet")
```

## La notion de génériques en Kotlin

Les generiques nous servent quand le contenu(les instructions) d'une classe ou d'une fonction peut s'executer sur différents types de donnée mais on est obligés de donner explicitement le type du parametre ou de l'attribut, alors dans ce cas on recours à ce dynamisme que nous offre les generiques en Kotlin.

**Syntaxe**

```kotlin
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

//Fonction avec notion de generique
//entre les chervrons on peut mettre n'importe quelle lettre pour representer le type generique mais par convention on met T
fun <T> afficher( donnee: T) {
    println(donnee)
}

//Class avec notio des generiques
class UI <T>(val donnee:T, val nom_interface:String){
    fun afficher(){
        println("caracteristiques, nom :$nom_interface,  donnee: $donnee")
    }
}
```

## Les collections en Kotlin

### 1. Les collections immutable

- **List** Declaration : `val liste_valeurs : List<type_valeurs> = listOf("valeurs_de_ce_type_1","valeurs_de_ce_type_2","valeurs_de_ce_type_3")`
  Exemple: `val liste_noms : List<String> = listOf("totot","tata")` et acces par indice avec `list_noms[indice]` ou `list_noms.indexAt(indice)`
- **Set** Declaration : `val ensemble_valeurs: Set<type_valeurs> = setOf("valeur_1","valeur_2")` la particularite c'est que dans un ensemble il n'y a pas de doublon.
  Exemple: `val ensemble_age: Set<Int> = setof(14,15,37,54)` et acces aux element uniquement par la methode `indexAt(indice)`
- **Map** Declaration : `val dictionnaire: Map<type_de_cle, type_de_valeur> = mapOf(cle_1 to valeur_1, cle_2 to valeur 2, cle_3 to valeur_3)` ceci represente un dictionnaire dans d'autre langage
  Exemple: `val dictionnaire_nom_age: Map<String, Int> = mapOf("toto" to 14, "tata" to 5, "koko" to 16)` et acces a une valeur par sa cle avec `dictionnaire_nom_age[cle]` ou dans une boucle `for` avec `for((cle,valeur) in dictionnaire_nom_age){}`

### 2. Les collections mutables

Pour toutes les collections citée prececedemment, leurs variantes mutables sont `MutableListe<> et mutableListOf()` , `MutableSet<> et mutableSetOf()` et MutableMap<> et `mutableMapOf()` et la on peut utiliser des methode d'ajout et suppression d'element de la collection.

## Des notions sur les fonction d'ordre superieur

**En Kotlin lorsqu'une fonction ne routerne rien, il return Unit et du coupt dans la declaration on a fun test_fonction():Unit{}, on peut ou ne pas mettre Unit ca ne change rien**

**Une fonction d'ordre superieur est une fonction qui peut prendre une fonction en parametre ou qui peut retourner une fonction**

**Styntaxe**:

```kotlin
fun fonctionTest(nom: String, nom_parametre_representant_fonction:(type_parametre1, type_parametre2) -> type_retour ou Unit){}
```

**Exemple:**

```kotlin
fun fonctiontest(texte:string, fn:(Int, String)-> String){}
```

**Exemple pratique**

```kotlin
fun main() {
    val personne = Person()
  //Syntaxe generale
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
```

Quand on appelle cette fonction à l'endroit de placer la fonction en parametre on met `::` ca permet de faire reference à une classe ou une fonctionction
