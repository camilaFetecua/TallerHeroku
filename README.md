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
     
 
      
# Diagrama de clases  

![Imagen](https://github.com/camilaFetecua/TallerHeroku/blob/master/Imagenes/Clasesservifot.PNG)

  Para este proyecto tenemos 6 clases y una interfaz 
  + HttpServer: Clase donde implementamos y corremos nuestro servidor. 
  + SocketClient : Clase donde se atiende cada peticion del cliente.
  + ChooserR : Clase  utilizada por el SocketClient para escoger el WriterR y su ejecucuion. 
  + Writerl: Clase utilizada para retornar la image. 
  + TextWriter: Clase utilizada para retornar el texto de un archivo. 
  + WriteE: Clase utilizada para retornar un Html.
  + WriterR: Clase que puede ser usada cuando el tipo de archivo no es      compatible. 

# Licencia

  Para consultar la Licencia del proyecto haga [click aqui](https://github.com/camilaFetecua/ServidorConcurrente/blob/master/LICENSE.md)
  
  
# Autor 
  **Maria Camila Fetecua Garcia**  LOCS/HORA 180/6= 30 LOCS/Hora 

