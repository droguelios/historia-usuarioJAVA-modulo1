package Historia_user_1.empleados.arquitetura;/* Notas de Arquitectura
 *
 * TASK 1: Evolución del Ecosistema Java
 * ─────────────────────────────────────────────────────────────
 *
 * ┌─────────────────────────────────────────────────────────┐
 * │                  JAVA 8 (LEGACY)                        │
 * ├─────────────────────────────────────────────────────────┤
 * │  Lanzado en 2014. Introdujo Lambdas, Streams y la API   │
 * │  de Fecha/Hora. Fue un hito, pero su Historia_user_1.empleados.modelo de clases   │
 * │  exige mucho "boilerplate": constructores, getters,     │
 * │  setters, toString(), equals() y hashCode() escritos    │
 * │  manualmente o generados por el IDE.                    │
 * │                                                         │
 * │  Enfoque: IMPERATIVO / ORIENTADO A OBJETOS clásico.     │
 * │  El desarrollador gestiona explícitamente el estado     │
 * │  mutable de los objetos.                                │
 * └─────────────────────────────────────────────────────────┘

  * ┌─────────────────────────────────────────────────────────┐
 * │           JAVA 17 / 21 (LTS MODERNOS)                  │
 * ├─────────────────────────────────────────────────────────┤
 * │  Java 17 (LTS, 2021) y Java 21 (LTS, 2023) consolidan  │
 * │  años de mejoras:                                       │
 * │                                                         │
 * │  • Records (Java 16+): clases de datos inmutables con   │
 * │    síntaxis mínima. El compilador genera constructor,   │
 * │    accessors, equals(), hashCode() y toString().        │
 * │                                                         │
 * │  • Sealed Classes (Java 17): jerarquías cerradas y      │
 * │    seguras, ideales para modelar dominios acotados.     │
 * │                                                         │
 * │  • Text Blocks (Java 15+): literales de texto           │
 * │    multilinea que eliminan concatenaciones frágiles.    │
 * │                                                         │
 * │  • Pattern Matching para instanceof y switch.           │
 * │                                                         │
 * │  • Virtual Threads (Java 21 / Project Loom):            │
 * │    concurrencia masiva con código sencillo.             │
 * │                                                         │
 * │  Enfoque: FUNCIONAL + OO + DECLARATIVO.                 │
 * │  Se favorece la inmutabilidad y la expresividad.        │
 * └─────────────────────────────────────────────────────────┘*

 ─────────────────────────────────────────────────────────────
 * JVM y GARBAGE COLLECTOR — Gestión de Memoria
 * ─────────────────────────────────────────────────────────────
 *
 *  La JVM divide la memoria en regiones:
 *
 *  1. STACK (Pila):
 *     - Almacena variables locales y tipos primitivos
 *       (byte, short, int, long, float, double, char, boolean).
 *     - Gestión LIFO automática: al salir del método,
 *       el frame se elimina al instante. Sin costo de GC.
 *
 *  2. HEAP (Montículo):
 *     - Almacena todos los objetos (instancias de clase,
 *       arrays, Strings, Records).
 *     - El GC monitorea la accesibilidad: cuando un objeto
 *       no tiene más referencias activas, se convierte en
 *       "basura" elegible para recolección.
 *
 *  3. GARBAGE COLLECTOR — Algoritmos en versiones modernas:
 *
 *     Java 8  → Parallel GC (throughput orientado).
 *     Java 11 → ZGC y Shenandoah disponibles (baja latencia).
 *     Java 17 → G1GC como default. ZGC productivo.
 *     Java 21 → ZGC Generacional (reducción de pausas <1ms).
 *
 *  4. GENERACIONES dentro del Heap:
 *     ┌───────────────────────────────────────────────────┐
 *     │  Young Generation  │  Eden + Survivor S0/S1       │
 *     │                    │  Objetos nuevos → Minor GC   │
 *     ├───────────────────────────────────────────────────┤
 *     │  Old Generation    │  Objetos de larga vida       │
 *     │  (Tenured)         │  → Major GC (Full GC)        │
 *     └───────────────────────────────────────────────────┘
 *
 *  Implicación para el sistema:
 *  Los Records (inmutables, de corta vida) son excelentes
 *  candidatos para residir en Young Generation y ser
 *  recolectados rápidamente por el Minor GC, optimizando
 *  el throughput del Corporate Talent Hub.
 */


public class notasArquitetura {

}
