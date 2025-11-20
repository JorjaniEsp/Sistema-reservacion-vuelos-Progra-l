## Sistema de reservación de vuelos

Simulación académica desarrollada en Java que permite gestionar reservaciones aéreas, generar tiquetes, facturas y validar disponibilidad por clase, integrando además una interfaz gráfica construida en Swing.
________________________________________
#### Comenzando 

Estas instrucciones te permitirán obtener una copia del proyecto funcionando en tu máquina local, para propósitos de desarrollo, pruebas y ejecución de la interfaz gráfica.

Más adelante encontrarás un apartado de Despliegue para ejecutar el programa de manera independiente.
________________________________________
#### Requisitos previos 

Antes de ejecutar el proyecto, necesitarás tener instalado:

1. Java Development Kit (JDK) 17+o superior

Descargar desde: https://www.oracle.com/java/technologies/javase-downloads.html

2. Un IDE compatible con Java

Ejemplo recomendado:

-	NetBeans

3. Git (opcional, para clonar el repositorio)

Instalar desde: https://git-scm.com/
________________________________________
#### Instalación 🔧

Sigue estos pasos para ejecutar el proyecto localmente:
________________________________________
##### 1. Clonar el repositorio

git clone https://github.com/tu-repositorio/Sistema-reservacion-vuelos-l.git
________________________________________
##### 2. Abrir el proyecto

En tu IDE preferido:

- File → Open Project → seleccionar la carpeta del proyecto.
________________________________________
##### 3. Verificar que src/ esté configurado como Source Root

Esto se hace automáticamente en la mayoría de IDEs.
________________________________________
##### 4. Ejecutar la aplicación

Ejecuta la clase:

  - testing/Test.java

Esto abrirá la interfaz gráfica del sistema.
________________________________________
##### 5. Ejemplo final: iniciar el sistema

Al ejecutar Test.java, verás la ventana de inicio.

Desde allí puedes:

-	Buscar vuelos

-	Verificar disponibilidad

-	Cotizar

-	Generar tiquete y factura

-	Visualizar documentos generados
________________________________________
#### Ejecutando las pruebas 

Este proyecto tiene pruebas manuales y pruebas implícitas mediante ejecución del flujo completo.

Para probarlo:

-	Ejecuta la interfaz con Test.java.

-	Registra una reservación.

-	Verifica que se generen archivos .txt en:

    - /data/tiquetes

    - /data/facturas

> [!TIP]
> Si necesita un apoyo visual, puede ver nuestro manual de uso en el siguiente enlace **->** [Manual de uso](https://jorjaniesp.github.io/manual-uso/)
________________________________________
#### Analizar pruebas de extremo a extremo 

Las pruebas E2E en este proyecto consisten en seguir el flujo completo:

1.	Seleccionar ruta.

2.	Buscar vuelo.
   
3.	Verificar disponibilidad.
   
4.	Crear pasajero y reservación.
   
5.	Generar tiquete y factura.
   
6.	Confirmar que el sistema:
    
  	- Reste un asiento correctamente

    - Calcule el precio

    - Emita documentos

    - Los guarde en /data

**Ejemplo:**

Reservar un vuelo SJO → MEX en clase Económica debería producir:

     tiquete_10.txt

     factura_11.txt
________________________________________
#### Pruebas de estilo de codificación 

Aunque este proyecto no utiliza un validador automático como Checkstyle, el código sigue prácticas estándar:

-	Uso de paquetes organizados (domain, logic, presentation, testing).

-	Clases con responsabilidades claras..

**Ejemplo:**

     DocumentoFactory valida que los objetos no sean null antes de crear tiquetes o facturas.
________________________________________
#### Despliegue 

Si deseas empaquetar el proyecto como .jar ejecutable:

1.	En tu IDE selecciona:
   
    - Export → Runnable JAR / Build Artifacts / Clean & Build

2.	Asegúrate de que Test.java sea la clase principal.
   
3.	Ejecuta el .jar así:
   
4.	java -jar SistemaReservacion.jar
________________________________________
#### Construido con:

Estas son las herramientas utilizadas en el desarrollo del proyecto:

-	Java SE 17+ – Lenguaje principal del sistema

-	Swing – GUI nativa

-	NetBeans 

-	POO (Programación Orientada a Objetos) – Arquitectura base

-	Archivos .txt – Persistencia de documentos
________________________________________
#### Contribuyendo 

Si deseas colaborar:

1.	Crea una rama nueva:
   
2.	git checkout -b feature/nueva-funcion
   
3.	Realiza tus cambios.
   
4.	Envia un Pull Request.


Versionado 

##### Versión 1.0.0 – Primer prototipo funcional
________________________________________
#### Autores 

###### Equipo de desarrollo:

-	Jorjanie Espinoza.

-	Justin Flores. 

-	Elberth Carranza. 

-	Angely Pérez.
________________________________________
#### Expresiones de Gratitud 

-	Agradecimientos a todo el equipo de trabajo que mantuvo un enfoque consistente en la elaboración de este proyecto.
