package ru.aston.mcs.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.service.BookingResourceServices;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(BookingResourceController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookingResourceControllerTest {
    @MockBean
    private BookingResourceServices bookingResourceServices;

    BookingResourceDTO bookingResourceDTO;

    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
        mockMvc = standaloneSetup(new BookingResourceController(bookingResourceServices)).build();
        bookingResourceDTO = new BookingResourceDTO
                (0L, null, null, 0, new Date(), new Date(), null);
    }

    @Test
    void getAllBookingResourcesTest() throws Exception {
        when(bookingResourceServices.getAllBookingResources()).thenReturn(Collections.singletonList(bookingResourceDTO));
        MvcResult mvcResult = mockMvc
                .perform(get("/api/resource-booking/"))
                .andReturn();
        verifyBody(asJsonString(Collections.singletonList(bookingResourceDTO)), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getBookingResourceByIdTest() throws Exception {
        when(bookingResourceServices.getBookingResource(0L)).thenReturn(bookingResourceDTO);

        MvcResult mvcResult = mockMvc
                .perform(get("/api/resource-booking/0").param("id", "0"))
                .andReturn();
        verifyBody(asJsonString(bookingResourceDTO), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void saveBookingResourceByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/resource-booking/")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(bookingResourceDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(bookingResourceDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void updateBookingResourceByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/resource-booking/")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(bookingResourceDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(bookingResourceDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void deleteBookingResourceByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/resource-booking/0")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(0)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(0), mvcResult.getRequest().getContentAsString());
    }

    private static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    private void verifyBody(String expectedBody, String actualBody) {
        assertThat(actualBody).isEqualTo(expectedBody);
    }
}