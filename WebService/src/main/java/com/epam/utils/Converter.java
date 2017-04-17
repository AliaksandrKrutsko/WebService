package com.epam.utils;


import com.epam.bean.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile = "book.json";

    public static void toJSON(Book book) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), book);
    }

    public static Book fromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Book.class);
    }

}
