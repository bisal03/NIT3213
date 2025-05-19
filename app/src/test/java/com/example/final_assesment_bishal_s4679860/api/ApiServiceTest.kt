package com.example.final_assesment_bishal_s4679860.api

import com.example.final_assesment_bishal_s4679860.api.ApiService
import com.example.final_assesment_bishal_s4679860.models.DashboardResponse
import com.example.final_assesment_bishal_s4679860.models.EntityDetails
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Call
import retrofit2.Response
import kotlin.test.assertEquals

class ApiServiceTest {

    private lateinit var apiService: ApiService
    private lateinit var mockCall: Call<DashboardResponse>

    @Before
    fun setUp() {
        apiService = mock(ApiService::class.java)
        mockCall = mock(Call::class.java) as Call<DashboardResponse>
    }

    @Test
    fun `test getEntities success`() {
        // Create a mock response
        val mockEntities = listOf(
            EntityDetails("African Elephant", "Loxodonta africana", "Savanna", "Herbivore","Vulnerable",60, "The largest land animal, known for its intelligence, social behavior, and distinctive trunk."),
            EntityDetails("Giant Panda", "Ailuropoda melanoleuca", "Temperate broadleaf and mixed forests", "Herbivore","Vulnerable",20, "A bear native to China, known for its distinctive black and white coat and bamboo diet."),
            EntityDetails("Blue Whale", "Balaenoptera musculus",  "Ocean","Carnivore", "Endangered",80, "The largest animal known to have ever existed, known for its massive size and haunting vocalizations."),
            EntityDetails("Komodo Dragon", "Varanus komodoensis", "Tropical savanna","Carnivore", "Vulnerable",30, "The largest living species of lizard, found in the Indonesian islands."),
            EntityDetails("Emperor Penguin", "Aptenodytes forsteri", "Antarctic coast","Carnivore","Near Threatened",20, "The tallest and heaviest of all living penguin species, known for its extreme adaptations to its Antarctic habitat."),
            EntityDetails("Red Panda", "Ailurus fulgens", "Temperate forests", "Omnivore","Endangered",8, "A small mammal native to the eastern Himalayas and southwestern China, known for its distinctive red fur and raccoon-like appearance."),
            EntityDetails("Platypus", "Ornithorhynchus anatinus", "Freshwater", "Carnivore","Vulnerable",10, "A unique egg-laying mammal with a duck-like bill, beaver-like tail, and otter-like feet, native to Australia.")
        )
        val mockResponse = DashboardResponse(mockEntities, mockEntities.size)

        // Set up the mock call
        `when`(mockCall.execute()).thenReturn(Response.success(mockResponse))
        `when`(apiService.getEntities()).thenReturn(mockCall)

        // Perform the API call
        val response = apiService.getEntities().execute()

        // Validate the results
        assertEquals(mockResponse, response.body())
        verify(apiService).getEntities()
    }
}
