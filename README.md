## Étapes de réalisation

### 1. Création du projet Spring Boot
- Utilisation de **Spring Initializr** pour créer le projet.
- Choix de la dernière version de Spring Boot disponible (LTS).
- Gestion des dépendances avec Maven.
- Ajout des dépendances : Spring Web, Spring Data JPA, H2 Database.

---

### 2. Configuration du projet
- Configuration du port **8081** dans `application.properties` :
  ```properties
  server.port=8081
  spring.application.name=dice

### 3. Création de la classe Dice
- Implémentation d'une classe Dice pour simuler un lancer de dé.
- Annotation @Component pour l'injection.

---
  
### 4. Création de l'entité DiceRollLog
- Entité JPA avec les champs : id, diceCount, results, timestamp.
- Annotations JPA : @Entity, @Id, @GeneratedValue, @ElementCollection.

---

### 5. Création du Repository
- Interface héritant de JpaRepository<DiceRollLog, Long>.

---

### 6. Création du contrôleur REST pour lancer les dés
- GET /rollDice : Lancer un seul dé.
- GET /rollDices/{X} : Lancer X dés (paramètre dynamique).

---

### 7. Création du Service
-Service avec méthode pour lancer les dés et enregistrer les résultats dans la base.

---

### 8. Contrôleur pour afficher les historiques
- GET /diceLogs : Endpoint pour retourner tous les enregistrements.

---

### 9. Tests et validation
- Test des endpoints avec Postman ou un navigateur.
- Validation des données dans la base de données avec H2 Console.
