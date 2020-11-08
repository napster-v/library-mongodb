package com.neeraj.libraryApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neeraj.libraryApi.book.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllBooks() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/book")
                                          .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());
    }

    @Test
    public void addNewBook() throws Exception {
        Book book = new Book("abc", "1234", 50D, 25D, List.of("cat1", "cat2"));
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(book);
        mvc.perform(MockMvcRequestBuilders.post("/book")
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .content(s)
        )
           .andDo(print())
           .andExpect(status().isCreated());
    }
}
