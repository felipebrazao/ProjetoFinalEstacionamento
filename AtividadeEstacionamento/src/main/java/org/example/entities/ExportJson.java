package org.example.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportJson {


    private static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> {
        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type typeOfSrc, JsonSerializationContext context) {
            return new com.google.gson.JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    private static Gson criarGsonComAdaptadorLocalDateTime() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }

    public static void exportarParaJSON(List<Veiculo> veiculos) {
        Gson gson = criarGsonComAdaptadorLocalDateTime();
        String json = gson.toJson(veiculos);

        try (FileWriter writer = new FileWriter("veiculos.json")) {
            writer.write(json);
            System.out.println("Arquivo JSON gerado com sucesso!");
            System.out.println("Arquivo será salvo em: " + new File("veiculos.json").getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
