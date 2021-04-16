
Réalisé par MANOUBI Farah et DENDOUNE Rayane.
manoubi.farah@yahoo.com, rayane.dendoune@gmail.com.
16/04/21  
Université Cergy-Pontoise 


<h2 align="center"> Description des services </h2>

### 1) Service WS
Concernant la réalisation de ce projet de WebService, la première étape a été la mise en place d'un service web de type WS. Notre application est divisée en 3 différents packages:
* Package com.webservice.model 
* Package com.webservice.service

Le premier package "com.webservice.model" comporte nos classes de données qui sont aux nombre de 2 : 
* Country
* Politician

Ces classes vont nous permettre de modéliser un objet représentant un pays ainsi qu'un objet modélisant un politicien.
Dans le deuxieme package "com.webservice.service ", ce dernier comporte l'interface dans laquelle sont décrites les méthodes fournis par le notre service web. Ces méthodes ont été implémentées dans une autre classe "CountryImplement". Cette classe comporte 3 méthodes:
* addCountry
* addPolitician
* getPoliticianByCountry

La méthode "addCountry" permet à un client d'ajouter un pays à notre web service.
La méthode "addPolitician" permet à un client d'ajouter un politicien en précisant son nom, son âge, sa popularité et son pays.
La méthode "getPoliticianByCountry" permet de récupérer une liste de politiciens en fonction du pays choisit par le client.

Pour pouvoir créer notre service web, nous avons ajouté des annotations "jax-ws", qui comporte :
* @WebService précédent le nom de notre interface.
* @WebMethode précédent chacune de nos méthodes.
* @WebResult correspondant au nom du résultat pour chaque méthode.


### 2) Service RS
Par la suite, nous avons mis en place un second service. Ce service web est de type RS (RestFul), il utilise CXF. Nous avons avons créer différents packages pour distingués les données, les ressources ainsi que les service. Ces packages sont au nombre de 3 :
* com.web.data
* com.web.resource
* com.web.service

Le premier package comporte les différentes classes de données qui sont : "Country" et "Politician". 
Dans le second package com.web.resource, nous avons réaliser des méthodes qui vont permettrent de gérer les services de notre application. Celles-ci contiennent des méthodes HTTP : par exemple POST qui va permettre de créer un politicien ou un pays. Une méthode GET est aussi utilisée. Elle va permettre de récuperer le nom des différents politiciens en fonction d'un pays. Nous avons également indiqué les différents chemins à l'aide de l'annotation "@Path". Ce qui va nous permettre de pouvoir réaliser les différentes requêtes HTTP. Ces méthodes retournent chacunes différentes réponses HTTP :
* CREATED pour la méthode POST
* OK pour la méthode GET

Le package com.web.service, lui, contient les différentes méthodes de notre service identiques à celle citées précedement, elles permettent la même chose à savoir :  ajouter un nouveau pays, ajouté un politicien et pouvoir obtenir différents politiciens d'un pays en indiquant ce pays. 


