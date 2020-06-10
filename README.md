
# Bank Account Kata (FR)
AccountController contient les US suivantes: 
#### User Story 1
> En tant que banque, j'accepte le dépôt d'argent d'un client vers son compte, s'il est supérieur à 0,01€

#### User Story 2
> En tant que banque, j'accepte le retrait d'argent d'un client depuis son compte, s'il n'utilise pas le découvert

#### User Story 3
> En tant que banque, j'offre la possibilité à mon client de consulter le solde de son compte

TransactionController contient les US suivantes:
#### User Story 4
> En tant que banque, j'offre la possibilité à mon client de consulter l'historique des transactions sur son compte


## Notes
> J'ai ajouté quelques fonctionnalmités standard comme getAll() etc

> J'ai injecté quelques données des qu'on lance l'appli vous pouvez le trouvez dans le fichier Src/main/ressources/script.sql.

> Si vous ne voulez pas injeter des donnés lors de lancemenr de l'appli merci de commenter cette ligne dans application.proprieties:  
     spring.datasource.data=classpath:script.sql
     
> J'ai utilisé une Base de donnés H2.

>  J'ai implémenter le modéle et les differentes relations entre les tables.







