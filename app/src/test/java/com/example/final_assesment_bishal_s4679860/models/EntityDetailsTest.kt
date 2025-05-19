package com.example.final_assesment_bishal_s4679860.models

import org.junit.Assert.assertEquals
import org.junit.Test

class EntityDetailsTest {

    @Test
    fun testEntityDetails() {
        val entity = EntityDetails(
           species = "African Elephant",
            scientificName = "Loxodonta africana",
            habitat = "Savannah",
            diet =  "Herbivore",
            conservationStatus = "Vulnerable",
            averageLifespan =60,
            description = "The largest land animal, known for its intelligence, social behavior, and distinctive trunk."
        )

        assertEquals("African Elephant", entity.species)
        assertEquals("Loxodonta africana", entity.scientificName)
        assertEquals(60, entity.averageLifespan)
        assertEquals("Herbivore", entity.diet)
        assertEquals("The largest land animal, known for its intelligence, social behavior, and distinctive trunk.", entity.description)
    }
}
