# RF07 - Carga de datos

### Descrpción:

La aplicación debe ser capaz de cargar personajes/partida previamente guardados y recuperar datos, tales como:

- Nombre del personaje
- Clase del personaje
- Nivel
- Vida máxima
- Vida al momento del guardado
- Ataque
- Defensa

> Esta lista está sujeta a cambios posteriores dependiendo de los requerimientos que se necesiten*

Para esto se utilizará la librería de Java `java.nio.file`, cuya utilidad es el manejo de archivos dentro del programa.

El archivo será guardado en local (memoria interna del teléfono), y su ruta de acceso será `"{ruta origen}/files/saves/{nombre del archivo}.sav"`.

El archivo será guardado con una extensión `.sav`, el cual el jugador podrá nombrar y al momento de cargar se le mostrará los atributos guardados.

Se le otorgarán 5 instancias de guardado al jugador. Si completa la cantidad máxima de archivo de guardo se podrá sobreescrir un archivo anterior.

Sólo se podrá cargar 1 archivo de personaje por usuario/jugador, mas este podrá tener un máximo de 5 archivos, equivalentes a las 5 instancias posibles de guardado, para tener 5 personajes/partidas distintas.

### Responsable: 
 
- Grupo Solvtech - José Aylwin

### Prioridad:

- Alta