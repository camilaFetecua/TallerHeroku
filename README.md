# SERVIDOR WEB CONCURRENTE
## Taller ARSW 2021-i / 16 Junio del 2021

  Este repositorio muestre una versión concurrente de su servidor web. 

# Prerequisitos 
  + Git version 2.25.1
  + Apavhe Maven version 4.0.0
  + Java version 11.0.11
  
  Para verificar que esten instalados los programas puede usar los suguientes comandos
    + mvn --version
    + git version
    +java --version
       
# Ejecucion del proyecto

  Para empezar debemos clonar el repositorio con el siguiente comando:

     git clone https://github.com/camilaFetecua/ServidorConcurrente.git
  
  Debemos ir al directorio raiz y se debe ejecutar el comando:
 
       mvn package
  
   
  Para ejecutar el proyecto se debe utilizar el siguiente comando 

     java -cp ServidorConcurrente-1.0-SNAPSHOT.jar edu.escuelaing.arsw.HttpServer
     
   Para ejecutar las pruebas se debe utilizar el siguiente comando , pero es importante antes de ejecutar las pruebas ejecutar el servidor
   
    java -cp ServidorConcurrente-1.0-SNAPSHOT.jar edu.escuelaing.arsw.HttpServerTest
      
# Diagrama de clases  

![Imagen](https://github.com/camilaFetecua/ServidorConcurrente/blob/master/Imagenes/Clasesservifot.PNG)

# Licencia

  Para consultar la Licencia del proyecto haga [click aqui](https://github.com/camilaFetecua/ServidorConcurrente/blob/master/LICENSE.md)
  
  
# Autor 
  **Maria Camila Fetecua Garcia**  LOCS/HORA 180/6= 30 LOCS/Hora 

