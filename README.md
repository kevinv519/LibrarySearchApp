# Primera tarea ex aula de Programación de N-Capas
Desarrollado por: **Kevin Enmanuel Velásquez Mendoza**

Carnet: **00018616**

Aplicación consultiva para biblioteca.

Desarrollada usando Spring Web MVC, Hibernate, JPA, JSTL y Jackson.

Se adjunta el backup de la base, cuyo nombre es **_library.backup_**.

* Nombre de la base de datos: **library**
* Usuario: **postgres**
* Sin contraseña


La información detallada que se solicitó se encuentra en el archivo INFO.txt

Características:
* Pantalla principal, donde se puede filtrar la búsqueda por titulo, autor, género o ISBN. También se puede elegir ver todos los registros
![main](/screenshots/main.png)
* Pantalla de resultado para la búsqueda filtrada, donde se resalta el valor que hace match con el filtro
![filtered](/screenshots/filtered.png)
* Tercera pantalla, que muestra todos los libros, haciendo una sumatoria de de la existencia de libros y la cantidad de autores.
![all](/screenshots/all.png)