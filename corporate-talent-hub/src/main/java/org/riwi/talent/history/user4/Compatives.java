package org.riwi.talent.history.user4;

/**
 * COMPARATIVA: SEALED CLASS
 * Seguridad: Interna y Estructural.
 * El compilador garantiza que NO pueden existir más tipos de los permitidos.
 */
/*public sealed class EstadoProyecto permits Activo, Finalizado, Cancelado {
    // Este diseño es seguro porque el programador no puede inventar
    // un estado nuevo sin permiso explícito en la lista 'permits'.
}

final class Activo extends EstadoProyecto {}
final class Finalizado extends EstadoProyecto {}
final class Cancelado extends EstadoProyecto {}*/

/**
 * COMPARATIVA: API (Concepto de Interface de comunicación)
 * Seguridad: Externa y de Acceso.
 * Es una puerta abierta que acepta cualquier dato que cumpla el formato (JSON/String).
 */
/*public interface ProyectoAPI {
    // La API es flexible: cualquier sistema externo puede enviarte
    // un String que diga "En Proceso", pero la API no sabe si ese
    // estado es válido hasta que el programa ya está ejecutándose.
    void actualizarEstado(String nuevoEstado);
}*/
