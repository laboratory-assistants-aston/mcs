package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.service.ResourceTypeService;
import ru.aston.mcs.service.StatusService;
import ru.aston.mcs.util.ResourceTypeDataUtils;
import ru.aston.mcs.util.StatusDataUtils;

import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResourceTypeController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResourceTypeControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private ResourceTypeService resourceTypeService;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                        new ResourceTypeController(resourceTypeService)).build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void getAllTypeResources() throws Exception {

        List<ResourceTypeDTO> dto = ResourceTypeDataUtils.createResourceTypeDTOList();

        Mockito.when(resourceTypeService.getAllResourceTypes()).thenReturn(dto);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/resource-types/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(dto.size())))
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }

    @Test
    void getTypeResources() throws Exception {

        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();

        Mockito.when(resourceTypeService.getResourceType(dto.getNameId())).thenReturn(dto);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/resource-types/{id}", dto.getNameId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }

    @Test
    void addTypeResources() throws Exception {

        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();

      //  Mockito.when(resourceTypeService.saveResourceType(dto)).thenReturn(dto);

        Mockito.doNothing().when(resourceTypeService).saveResourceType(dto);


        MockHttpServletRequestBuilder mockRequest =
                MockMvcRequestBuilders.post("/api/resource-types/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void updateTypeResources() throws Exception {

        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();

        Mockito.when(resourceTypeService.updateResourceType(dto)).thenReturn(dto);


        MockHttpServletRequestBuilder mockRequest =
                MockMvcRequestBuilders.put("/api/resource-types/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateTypeResourcesBadRequest() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/resource-types/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(null));

        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteTypeResources() throws Exception {

        StatusDTO dto = StatusDataUtils.createStatusDTO();

        Mockito.doNothing().when(resourceTypeService).deleteResourceType(dto.getStatusId());

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/resource-types/{id}", dto.getStatusId()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
