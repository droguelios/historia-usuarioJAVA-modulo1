package org.riwi.models;

/**
 * Modern Record (Java 17/21):
 * Represents basic company data in a concise and immutable way.
 */
public record Company(String name, String nit, int foundationYear) {
    // Unlike a traditional class, this single line automatically generates:
    // - Private final fields
    // - Constructor
    // - Getters (name(), nit(), foundationYear())
    // - toString(), equals(), and hashCode()
}