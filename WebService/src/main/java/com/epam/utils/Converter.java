package com.epam.utils;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

//    public static void toJSON(Book book) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File(baseFile), book);
//    }

//    public static Book fromJson() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(new File(baseFile), Book.class);
//    }

    public static String toJson(Object src) {
        try {
            return mapper.writeValueAsString(src);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
