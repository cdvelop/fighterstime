



---

## Daily Scrum

En **Scrum**, la reunión diaria se llama **Daily Scrum** o **Daily Stand-up**.

La idea es que cada desarrollador responda de forma **breve y clara** a 3 preguntas clave:

1. **¿Qué hice ayer que ayudó al equipo a alcanzar el objetivo del Sprint?**
   (progreso realizado).

2. **¿Qué haré hoy para ayudar al equipo a alcanzar el objetivo del Sprint?**
   (plan inmediato).

3. **¿Qué impedimentos tengo que dificulten mi trabajo o el avance del equipo?**
   (bloqueos o problemas que deben resolverse).


### 🔑 Notas importantes

* La reunión es **máximo 15 minutos**.
* No es un reporte al profesor / Scrum Master, sino un **compromiso dentro del equipo**.
* El Scrum Master solo escucha y ayuda a eliminar impedimentos, pero no da órdenes.
* Si surge un tema largo, se agenda una conversación aparte (“parking lot”).
---

# 📝 Plantilla Daily Scrum

## 👥 Equipo: \_\_\_\_\_\_\

## 📅 Fecha: \_\_\_\_\_\_\_\

### Preguntas para cada integrante:

1. **¿Qué hice ayer?**
   *(Progreso: qué completé o avancé en el Sprint)*

2. **¿Qué haré hoy?**
   *(Plan: en qué tarea/issue trabajaré hoy)*

3. **¿Qué impedimentos tengo?**
   *(Bloqueos: algo que me frene o que necesito del equipo)*

---

### 🧑‍💻 Ejemplo de registro

* **Nombre:** Ana

  * **Ayer:** Terminé el diseño de la pantalla de login.
  * **Hoy:** Conectar la pantalla con la API de autenticación.
  * **Impedimentos:** No tengo la documentación del endpoint de login.
 
## 🔑 organización dailys:  


### 1. 📂 Carpeta

```
docs/
 └── scrum/
      └── daily/
```

---

### 2. 📄 Nombre de archivos

formato **fecha + equipo** para que se ordenen cronológicamente:

```
YYYY-MM-DD-equipo.md
```

Ejemplo:

* `2025-09-01-equipoA.md`
* `2025-09-01-equipoB.md`

✅ Ventaja: todos los registros del mismo día quedan juntos, y cada equipo tiene su archivo.

---

### 3. 📄 Una plantilla por día (no por alumno)

* **Recomendado:** **un archivo por día y por equipo**, con secciones para cada alumno.
* ❌ Evitar un archivo por alumno → se vuelve inmanejable (10 archivos diarios).
* ❌ Evitar un archivo único para todo el proyecto → pierde el control diario.

---

### 4. 📑 Plantilla reutilizable

Dentro de cada archivo, cada alumno tiene su bloque:

```markdown
# 📝 Daily Scrum - Equipo A
📅 Fecha: 2025-09-01  

---

### 👩‍💻 Ana
1. ¿Qué hice ayer?  
2. ¿Qué haré hoy?  
3. ¿Qué impedimentos tengo?  

---

### 👨‍💻 Pedro
1. ¿Qué hice ayer?  
2. ¿Qué haré hoy?  
3. ¿Qué impedimentos tengo?  

---

### 📌 Notas Scrum Master
- ...
```

---

✅ Con este esquema:

* La carpeta `docs/scrum/daily/` es la “bitácora del curso”.
* Se Puede revisar rápidamente la evolución del equipo día a día.
* Los alumnos solo editan **su sección del día**, no crean archivos nuevos.

---


