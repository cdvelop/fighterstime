# Sprint

### Formato para un Milestone de Sprint en GitHub

Este formato está pensado para ser claro, conciso y para que de un vistazo se entiendan los objetivos y el alcance del Sprint.

#### **1. Título del Milestone (Title)**

Usa un formato consistente que sea fácil de leer y ordenar.

**Formato:**
`Sprint [Número]: [Meta Principal del Sprint en pocas palabras]`

**Ejemplo:**
`Sprint 1: Implementar registro y login de usuarios`

#### **2. Fecha de Finalización (Due date)**

Establece la fecha en la que termina el Sprint. Esto es crucial en Scrum, ya que los Sprints tienen una duración fija (time-boxed). Si el Sprint dura dos semanas, la fecha de finalización será 14 días después del inicio.

**Ejemplo:**
Si el Sprint comienza el 1 de septiembre y dura 2 semanas, la fecha de finalización sería el 15 de septiembre.

#### **3. Descripción (Description)**

Esta es la parte más importante para detallar el plan del Sprint. Te recomiendo usar Markdown para organizarlo bien. Aquí tienes una plantilla completa que puedes copiar y pegar.

**Plantilla de Descripción:**

```markdown
### Objetivo del Sprint (Sprint Goal)
> _Aquí se describe en una o dos frases el objetivo principal que el equipo se compromete a alcanzar al final del Sprint. Debe ser claro y medible._

**Ejemplo:**
> Al final del Sprint, el usuario podrá registrarse en la plataforma con su correo electrónico y contraseña, iniciar y cerrar sesión de forma segura.

---

### Alcance del Sprint (Sprint Backlog)

_Listado de los elementos del Product Backlog (User Stories) que el equipo se ha comprometido a completar en este Sprint._

- [ ] **HU01:** Como usuario nuevo, quiero poder registrarme en el sistema usando mi correo y una contraseña para poder acceder a sus funcionalidades.
- [ ] **HU02:** Como usuario registrado, quiero poder iniciar sesión con mis credenciales para acceder a mi perfil.
- [ ] **HU03:** Como usuario con sesión iniciada, quiero poder cerrar mi sesión para proteger mi cuenta.
- [ ] **Tarea Técnica:** Configurar la base de datos de usuarios.

---

### Definición de "Hecho" (Definition of Done)

_Criterios que una tarea debe cumplir para ser considerada "completa". Esto es un acuerdo del equipo._

- [ ] El código está revisado por al menos un miembro del equipo (Code Review).
- [ ] Las pruebas unitarias fueron creadas y todas pasan.
- [ ] Cumple con los criterios de aceptación de la Historia de Usuario.
- [ ] La funcionalidad ha sido desplegada en el ambiente de pruebas.
- [ ] No se han introducido nuevos bugs de alta prioridad.

---

### Fechas Clave del Sprint

* **Sprint Planning:** Lunes, 01/09/2025
* **Sprint Review:** Viernes, 12/09/2025
* **Sprint Retrospective:** Viernes, 12/09/2025

```

### ¿Cómo se ve en GitHub?


-----

### Objetivo del Sprint (Sprint Goal)

> Al final del Sprint, el usuario podrá registrarse en la plataforma con su correo electrónico y contraseña, iniciar y cerrar sesión de forma segura.

-----

### Alcance del Sprint (Sprint Backlog)

*Listado de los elementos del Product Backlog (User Stories) que el equipo se ha comprometido a completar en este Sprint.*

  - [ ] **HU01:** Como usuario nuevo, quiero poder registrarme en el sistema usando mi correo y una contraseña para poder acceder a sus funcionalidades.
  - [ ] **HU02:** Como usuario registrado, quiero poder iniciar sesión con mis credenciales para acceder a mi perfil.
  - [ ] **HU03:** Como usuario con sesión iniciada, quiero poder cerrar mi sesión para proteger mi cuenta.
  - [ ] **Tarea Técnica:** Configurar la base de datos de usuarios.

-----

### Definición de "Hecho" (Definition of Done)

*Criterios que una tarea debe cumplir para ser considerada "completa". Esto es un acuerdo del equipo.*

  - [ ] El código está revisado por al menos un miembro del equipo (Code Review).
  - [ ] Las pruebas unitarias fueron creadas y todas pasan.
  - [ ] Cumple con los criterios de aceptación de la Historia de Usuario.
  - [ ] La funcionalidad ha sido desplegada en el ambiente de pruebas.
  - [ ] No se han introducido nuevos bugs de alta prioridad.

-----

### Fechas Clave del Sprint

  * **Sprint Planning:** Lunes, 01/09/2025
  * **Sprint Review:** Viernes, 12/09/2025
  * **Sprint Retrospective:** Viernes, 12/09/2025

-----

### Ventajas de este formato:

1.  **Refuerza conceptos de Scrum:** obliga a pensar y definir el *Sprint Goal*, el *Sprint Backlog* y la *Definition of Done*.
2.  **Claridad y Foco:** Cualquiera puede entrar al milestone y entender de qué se trata el Sprint.
3.  **Seguimiento Fácil:** Las casillas de verificación (checkboxes) en el alcance del Sprint permiten ver el progreso de un vistazo. A medida que los desarrolladores cierran los *Issues* o *Pull Requests* asociados, pueden marcar estas casillas.
4.  **Promueve la Responsabilidad:** Deja claro cuál fue el compromiso del equipo al inicio del Sprint.



### ¿Dónde organizar los Sprints?

sugerencia es **no usar documentos estáticos para la planificación y seguimiento diario del Sprint**. En su lugar, utiliza las herramientas colaborativas diseñadas para ello.

  * **Herramientas como GitHub, Jira o Trello:** La mejor práctica es mantener la información del Sprint directamente en la herramienta que usan para gestionar el trabajo. Para tu caso, el propio **Milestone de GitHub** es el lugar perfecto.

      * **¿Por qué?** Se convierte en la **"única fuente de la verdad"** (Single Source of Truth). Todo el equipo sabe dónde mirar, la información está siempre actualizada en tiempo real y está directamente vinculada a los issues y al código. Usar documentos externos crea duplicidad y el riesgo de que queden desactualizados rápidamente.

  * **Si de todas formas necesitas documentos (para resúmenes o retrospectivas):** Tu idea de estructura es muy buena y lógica.

      * **Ubicación:** `docs/scrum/sprints/` 
 
-----

### Opción (Más Simple): Solo Número de Sprint

**Formato:**
`SPRINT_[Numero].md`

  * **`SPRINT_`:** Un prefijo claro.
  * **`[Numero]`:** El número del Sprint, también con dos dígitos para el orden.

**Ejemplos:**

  * `SPRINT_01.md`
  * `SPRINT_02.md`
  * `SPRINT_03.md`

**Ventaja:** Súper limpio y fácil de estandarizar.

-----

### ¿Cómo se vería y qué contendría el archivo?

la idea es enlazar al Milestone, el contenido de estos archivos resumen o "acta" de los eventos clave del Sprint que no viven directamente en el Milestone, como la retrospectiva.

```
/docs
└── scrum/
      └── sprints
             ├── SPRINT_00.md
             ├── SPRINT_01.md
             └── SPRINT_02.md 
```


```markdown
# Resumen del Sprint 1: Registro y Login de Usuarios

**Fechas:** 01 de Septiembre, 2025 - 15 de Septiembre, 2025

Este documento contiene los resultados y aprendizajes clave del Sprint 1.

### Enlace al Milestone en GitHub
Toda la planificación, el Sprint Backlog y el seguimiento del trabajo se encuentran en el Milestone correspondiente:

➡️ **[Ver Milestone del Sprint 1 en GitHub](https://github.com/tu-usuario/tu-repositorio/milestone/1)**

---

### Resumen de la Retrospectiva

**¿Qué funcionó bien?**
* La comunicación diaria fue muy fluida.
* Logramos completar todas las historias de usuario comprometidas.

**¿Qué podemos mejorar?**
* Necesitamos definir mejor las tareas técnicas antes de iniciar.
* Algunas pruebas unitarias no se escribieron hasta el final.

**Acciones a tomar para el siguiente Sprint:**
* [ ] Dedicar 1 hora extra en el Sprint Planning para desglosar tareas técnicas.
* [ ] Recordar en cada Daily Scrum el estado de las pruebas unitarias.

```
De esta manera, se mantiene un registro histórico limpio y ordenado, y se usas el archivo para lo que aporta más valor: documentar los resultados (como la retro) y servir como un índice centralizado que apunta a la herramienta principal de trabajo (el Milestone).
