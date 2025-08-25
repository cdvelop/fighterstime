# Requerimientos FightersTime - Versión Estudiantes
## Aplicación Android Simple para Taller de Programación Móvil

---

## 📋 Requerimientos Funcionales Básicos

### RF-01: Crear Personaje Simple
**Lo que debe hacer:** Una pantalla donde el estudiante pueda crear un personaje básico.

**Funcionalidades mínimas:**
- ✅ Botón para elegir clase: Guerrero, Mago o Arquero
- ✅ Mostrar 4 números: Vida, Ataque, Defensa, Velocidad
- ✅ Botón "Crear" que guarde el personaje
- ✅ Navegar a la pantalla principal

**Pantalla:** `CreateCharacterActivity`  

---

### RF-02: Combate Básico
**Lo que debe hacer:** Una pantalla simple de combate por turnos.

**Funcionalidades mínimas:**
- ✅ Mostrar vida del jugador y enemigo (con números)
- ✅ 2 botones: "Atacar" y "Defenderse"
- ✅ Turnos: jugador → enemigo → jugador...
- ✅ Cuando alguien llega a 0 vida, mostrar "Ganaste" o "Perdiste"
- ✅ Botón para volver al menú

**Pantalla:** `CombatActivity`  

---

### RF-03: Guardar Datos
**Lo que debe hacer:** Recordar el personaje cuando se cierre la app.

**Funcionalidades mínimas:**
- ✅ RF03.01 - Guardado de personajes/partida
- ✅ RF03.02 - Carga de personajes/partida
- ✅ RF03.03 - Base de datos que contenga la información de cada personaje

**Tecnología:** SharedPreferences (sin base de datos)  

---

## 📱 Requerimientos No Funcionales Simples

### RNF-01: Fácil de Usar
**Lo que significa:** La app debe ser simple para cualquier usuario.

**Criterios básicos:**
- ✅ Botones grandes y fáciles de tocar
- ✅ Textos legibles en el celular
- ✅ No se rompe si el usuario toca botones rápido
- ✅ Funciona en teléfonos Android normales

---

### RNF-02: Código Simple
**Lo que significa:** El código debe ser fácil de entender y modificar.

**Criterios básicos:**
- ✅ Máximo 3 Activities (pantallas)
- ✅ Variables con nombres claros
- ✅ Comentarios en partes importantes
- ✅ Sin código complicado

---

## 🎯 Lo Mínimo que Debe Funcionar (MVP)

### Pantalla 1: MainActivity
- Botón "Nuevo Personaje"
- Botón "Combate" (si ya hay personaje)
- Botón "Salir"

### Pantalla 2: CreateCharacterActivity  
- 3 botones para elegir clase
- Mostrar números de atributos
- Botón "Crear"

### Pantalla 3: CombatActivity
- Mostrar vida de jugador y enemigo
- Botón "Atacar"
- Botón "Defenderse"
- Mostrar resultado final

---

## 📝 Plan de Desarrollo para Estudiantes

### Crear Personaje
- Hacer la pantalla de crear personaje
- Solo mostrar números fijos al principio
- Que funcione el botón "Crear"

### Combate Básico
- Pantalla de combate con botones
- Lógica simple: click botón → restar vida
- Mostrar "Ganaste" o "Perdiste"

### Guardar Datos
- Usar SharedPreferences para guardar
- Cargar personaje al abrir app

### Pulir y Probar
- Hacer que se vea mejor
- Probar en celular real
- Arreglar errores

---

## ⚠️ Lo que NO es Necesario (Para Mantener Simple)

❌ **No implementar por ahora:**
- Múltiples enemigos
- Niveles o progresión
- Sonidos o música
- Animaciones complejas
- Base de datos SQLite
- Imágenes elaboradas
- Sistema de experiencia

✅ **Enfocarse solo en:**
- 3 pantallas básicas que funcionen
- Crear personaje
- Combate simple
- Guardar datos básicos

---

## 🚀 Criterios de Éxito para Estudiantes

**La aplicación está completa cuando:**
1. ✅ Puede crear un personaje y ver sus números
2. ✅ Puede hacer un combate completo hasta el final
3. ✅ Al cerrar y abrir la app, recuerda el personaje
4. ✅ No se rompe al usar normalmente
5. ✅ Se puede instalar en un celular Android

**Nota:** ¡Si se puede! 🎉
