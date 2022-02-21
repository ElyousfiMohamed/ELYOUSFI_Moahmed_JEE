<img src="./github/assets/images/topo_readme.jpg"/>

<h1 align="center">Mohamed ELYOUSFI</h1>

<h2 align="center"><💻 Compte Rendu des Travaux Pratiques JEE💻/></h2>

---

<details>
    <summary>TP1 - Injection de dependances Statique/Dynamique/Framework</summary><br>
    <p>
        On considère le schéma suivant ou les classes sont liées par un couplage faible<br>
        <img src="./github/assets/images/TP1/Screenshot_1.png"/>
        <pre>Implémentation en java :
- Interface IDao et leurs implémentations :</pre>
        <img src="./github/assets/images/TP1/Screenshot_3.png" />
        <img src="./github/assets/images/TP1/Screenshot_2.png"/>
        <img src="./github/assets/images/TP1/Screenshot_6.png"/><br>
        <pre>- Interface IMetier et son implémentation :</pre>
        <img src="./github/assets/images/TP1/Screenshot_5.png"/>
        <img src="./github/assets/images/TP1/Screenshot_4.png"/>
        <h3>1- Injection de dependances Statique</h3>
        <img src="./github/assets/images/TP1/Screenshot_7.png"/>
        <h3>2- Injection de dependances Dynamique</h3>
        <pre>L'injection dynamique et faite à l'aide d'un fichier config.txt qui contient les noms des classes qui vont etre chargé dans la couche presentation</pre>
        <img src="./github/assets/images/TP1/Screenshot_9.png"/>
        <pre>1 : Chargement du fichier config.txt
2 : Lecture des noms complets(package + nom de la classe) des classes existant dans ce fichier
3 : Récuperation des instances de "Class" à partir des noms complet des classes 
4 : L'instanciation des classes(si ces classe ont un constructeur sans paramètre)
5 : Chargement et invocation(injection) du methode "setDao"</pre>
        <img src="./github/assets/images/TP1/Screenshot_8.png"/>
    </p>
</details>

<details>
    <summary>TP2</summary>
    <br />
    <p align="center">
        Coming soon...
    </p>
</details>

<h3>...</h3>
<img src="./github/assets/images/rodape_readme.jpg" alt="Art for footer readme.md" />
