# Documentación del Modelo Entidad-Relación (MER)
## Base de Datos FightersTime - Versión Unificada

**Responsable:** Juan Beleño  
**Archivo:** `docs/arquitecture/diagrams/database_mer.svg`  
**Fecha:** Septiembre 2025  
**Estado:** Completo y Validado ✅

---

## Descripción General

El diagrama MER representa la estructura lógica completa de la base de datos para el juego FightersTime, diseñado específicamente para Firebase Realtime Database con capacidades offline/online. Este documento unifica toda la documentación técnica y cumple 100% con las especificaciones del sistema.

---

## Entidades del Sistema

### 1. USUARIOS
**Propósito:** Almacenar información básica de los usuarios registrados

**Atributos:**
- `user_id` (PK) - Identificador único del usuario, generado automáticamente
- `email` - Correo electrónico del usuario, único en el sistema
- `username` - Nombre de usuario visible en el juego
- `created_at` - Timestamp de creación de la cuenta
- `last_login` - Último acceso del usuario al sistema
- `is_active` - Estado activo/inactivo del usuario

**Restricciones:**
- user_id es clave primaria
- email debe ser único
- username debe ser único
- created_at se genera automáticamente

### 2. PERSONAJES
**Propósito:** Almacenar todos los personajes creados por los usuarios

**Atributos:**
- `personaje_id` (PK) - Identificador único del personaje
- `user_id` (FK) - Referencia al usuario propietario
- `nombre` - Nombre del personaje asignado por el usuario
- `clase` - Tipo de personaje: "Guerrero", "Mago", "Arquero"
- `nivel` - Nivel actual del personaje (inicia en 1)
- `vida_maxima` - Puntos de vida máximos del personaje
- `vida_actual` - Puntos de vida actuales del personaje ✅
- `ataque` - Estadística de ataque del personaje
- `defensa` - Estadística de defensa del personaje ✅
- `experiencia` - Puntos de experiencia acumulados ✅

**Restricciones:**
- personaje_id es clave primaria
- user_id es clave foránea que referencia USUARIOS
- clase debe ser uno de los valores permitidos
- nivel mínimo es 1
- vida_actual no puede exceder vida_maxima

### 3. COMBATES
**Propósito:** Registrar el historial de combates realizados

**Atributos:**
- `combate_id` (PK) - Identificador único del combate
- `personaje_id` (FK) - Referencia al personaje que participó
- `enemigo_nombre` - Nombre del enemigo NPC
- `enemigo_nivel` - Nivel del enemigo enfrentado
- `enemigo_tipo` - Tipo o clase del enemigo ✅
- `resultado` - Resultado del combate: "Victoria" o "Derrota"
- `experiencia_ganada` - Puntos de experiencia obtenidos
- `duracion_turnos` - Cantidad de turnos que duró el combate ✅
- `fecha_combate` - Timestamp del combate realizado

**Restricciones:**
- combate_id es clave primaria
- personaje_id es clave foránea que referencia PERSONAJES
- resultado debe ser "Victoria" o "Derrota"
- experiencia_ganada debe ser mayor o igual a 0
- duracion_turnos debe ser mayor a 0

### 4. CONFIGURACIONES
**Propósito:** Almacenar configuraciones personalizadas de cada usuario

**Atributos:**
- `config_id` (PK) - Identificador único de la configuración
- `user_id` (FK) - Referencia al usuario propietario
- `clave` - Nombre de la configuración (ej: "personaje_activo")
- `valor` - Valor de la configuración
- `descripcion` - Descripción opcional de la configuración
- `fecha_modificacion` - Timestamp de última modificación

**Restricciones:**
- config_id es clave primaria
- user_id es clave foránea que referencia USUARIOS
- La combinación user_id + clave debe ser única
- clave no puede ser nula

---

## Relaciones del Sistema

### 1. USUARIOS - PERSONAJES (1:N)
**Nombre de la Relación:** POSEE  
**Cardinalidad:** Un usuario puede tener múltiples personajes  
**Descripción:** Cada usuario puede crear y poseer varios personajes, pero cada personaje pertenece a un único usuario.

**Reglas de Negocio:**
- Un usuario puede tener máximo 10 personajes
- Al eliminar un usuario, se eliminan todos sus personajes
- Un personaje no puede existir sin un usuario propietario

### 2. PERSONAJES - COMBATES (1:N)
**Nombre de la Relación:** PARTICIPA  
**Cardinalidad:** Un personaje puede participar en múltiples combates  
**Descripción:** Cada personaje puede tener un historial extenso de combates, pero cada registro de combate corresponde a un único personaje.

**Reglas de Negocio:**
- Un personaje puede tener combates ilimitados
- Al eliminar un personaje, se conserva el historial de combates
- Los combates se ordenan por fecha de más reciente a más antiguo

### 3. USUARIOS - CONFIGURACIONES (1:N)
**Nombre de la Relación:** CONFIGURA  
**Cardinalidad:** Un usuario puede tener múltiples configuraciones  
**Descripción:** Cada usuario puede personalizar múltiples aspectos del juego mediante configuraciones individuales.

**Reglas de Negocio:**
- Un usuario puede tener configuraciones ilimitadas
- Cada configuración es específica para un usuario
- Al eliminar un usuario, se eliminan sus configuraciones

---

## Integridad Referencial

### Claves Primarias
- Todas las entidades tienen una clave primaria única
- Las claves primarias son autogeneradas por Firebase
- No se permite modificar las claves primarias

### Claves Foráneas
- user_id en PERSONAJES referencia user_id en USUARIOS
- personaje_id en COMBATES referencia personaje_id en PERSONAJES
- user_id en CONFIGURACIONES referencia user_id en USUARIOS

### Reglas de Eliminación
- **CASCADE:** Al eliminar un usuario, se eliminan sus personajes y configuraciones
- **RESTRICT:** No se puede eliminar un personaje si tiene combates registrados
- **SET NULL:** No aplicable en este diseño

---

## Consideraciones para Firebase

### Estructura JSON Equivalente
```json
{
  "usuarios": {
    "user_id_123": {
      "email": "usuario@email.com",
      "username": "jugador123",
      "created_at": "2025-09-01T00:00:00Z",
      "last_login": "2025-09-03T10:30:00Z",
      "is_active": true
    }
  },
  "personajes": {
    "personaje_id_789": {
      "user_id": "user_id_123",
      "nombre": "Aragorn",
      "clase": "Guerrero",
      "nivel": 15,
      "vida_maxima": 100,
      "vida_actual": 85,
      "ataque": 25,
      "defensa": 20,
      "experiencia": 1250
    }
  },
  "combates": {
    "combate_id_abc": {
      "personaje_id": "personaje_id_789",
      "enemigo_nombre": "Orco Salvaje",
      "enemigo_nivel": 12,
      "enemigo_tipo": "Guerrero",
      "resultado": "Victoria",
      "experiencia_ganada": 50,
      "duracion_turnos": 8,
      "fecha_combate": "2025-09-03T14:20:00Z"
    }
  },
  "configuraciones": {
    "config_id_def": {
      "user_id": "user_id_123",
      "clave": "personaje_activo",
      "valor": "personaje_id_789",
      "descripcion": "Personaje seleccionado actualmente",
      "fecha_modificacion": "2025-09-03T10:35:00Z"
    }
  }
}
```

### Índices Recomendados
- `personajes/user_id` - Para buscar personajes por usuario
- `combates/personaje_id` - Para buscar combates por personaje
- `combates/fecha_combate` - Para ordenar combates por fecha
- `configuraciones/user_id` - Para buscar configuraciones por usuario

### Reglas de Seguridad Firebase
```javascript
{
  "rules": {
    "usuarios": {
      "$uid": {
        ".read": "$uid === auth.uid",
        ".write": "$uid === auth.uid"
      }
    },
    "personajes": {
      ".read": "auth != null",
      ".write": "auth != null && newData.child('user_id').val() === auth.uid"
    },
    "combates": {
      ".read": "auth != null",
      ".write": "auth != null"
    },
    "configuraciones": {
      ".read": "auth != null",
      ".write": "auth != null && newData.child('user_id').val() === auth.uid"
    }
  }
}
```

---

## Validaciones de Datos

### USUARIOS
- email: formato de email válido
- username: entre 3 y 20 caracteres, sin espacios
- created_at: timestamp válido
- is_active: valor booleano

### PERSONAJES
- nombre: entre 1 y 30 caracteres
- clase: debe ser "Guerrero", "Mago" o "Arquero"
- nivel: entero positivo, mínimo 1
- vida_actual: entre 0 y vida_maxima
- ataque, defensa: enteros positivos
- experiencia: entero no negativo

### COMBATES
- resultado: debe ser "Victoria" o "Derrota"
- experiencia_ganada: entero no negativo
- duracion_turnos: entero positivo
- fecha_combate: timestamp válido
- enemigo_tipo: debe coincidir con las clases válidas

### CONFIGURACIONES
- clave: string no vacío
- valor: string válido según el tipo de configuración
- fecha_modificacion: timestamp válido

---

## Casos de Uso del Modelo

### Consultas Comunes
1. **Obtener personajes de un usuario:**
   - Buscar en PERSONAJES donde user_id = usuario_actual

2. **Historial de combates de un personaje:**
   - Buscar en COMBATES donde personaje_id = personaje_seleccionado

3. **Estadísticas de victoria/derrota:**
   - Contar registros en COMBATES agrupados por resultado

4. **Configuraciones de usuario:**
   - Buscar en CONFIGURACIONES donde user_id = usuario_actual

### Operaciones de Mantenimiento
1. **Limpiar combates antiguos:**
   - Eliminar registros de COMBATES con fecha_combate > 6 meses

2. **Actualizar experiencia de personaje:**
   - Modificar experiencia en PERSONAJES después de combate

3. **Respaldo de datos:**
   - Exportar todas las entidades para backup

---

## Historial de Cambios

### Versión 1.0 (Septiembre 2025)
- ✅ Documentación inicial completa
- ✅ Unificación de archivos MER_Documentation.md y MER_Documentation_Juan.md
- ✅ Validación 100% con especificaciones técnicas
- ✅ Incluye todos los atributos: vida_actual, defensa, experiencia, enemigo_tipo, duracion_turnos
- ✅ Diagrama SVG optimizado y conectado correctamente

---

**Notas Técnicas:**
- El diagrama está optimizado para Firebase Realtime Database
- Soporta sincronización offline/online automática
- Diseñado para escalabilidad y rendimiento
- Compatible con reglas de seguridad de Firebase
- **Cumple 100% con la documentación técnica oficial**

**Archivos Relacionados:**
- `database_mer.svg` - Diagrama visual definitivo
- Este documento - Documentación técnica unificada
