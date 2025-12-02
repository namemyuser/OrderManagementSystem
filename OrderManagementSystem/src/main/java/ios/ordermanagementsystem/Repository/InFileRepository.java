package ios.ordermanagementsystem.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class InFileRepository<T> {

    private final Class<T> type;
    private final Path filePath;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Function<T, String> getIdFn;
    private final BiConsumer<T, String> setIdFn;

    // In‑memory cache of entities
    protected final List<T> data = new ArrayList<>();

    protected InFileRepository(
            Class<T> type,
            String fileName,
            Function<T, String> getIdFn,
            BiConsumer<T, String> setIdFn
    ) {
        this.type = type;
        this.filePath = Paths.get("src/main/resources/data/" + fileName);
        this.getIdFn = getIdFn;
        this.setIdFn = setIdFn;
        loadFromFile();
    }

    private void loadFromFile() {
        try {
            if (Files.notExists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.writeString(filePath, "[]");
            }

            byte[] bytes = Files.readAllBytes(filePath);
            if (bytes.length == 0) {
                data.clear();
                return;
            }

            var collectionType = objectMapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, type);

            List<T> loaded = objectMapper.readValue(bytes, collectionType);
            data.clear();
            if (loaded != null) {
                data.addAll(loaded);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load data from " + filePath, e);
        }
    }

    private void saveToFile() {
        try {
            String json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(data);
            Files.writeString(filePath, json, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save data to " + filePath, e);
        }
    }

    // ---------- Protected CRUD helpers ----------

    protected List<T> findAllInternal() {
        return new ArrayList<>(data);
    }

    protected T findByIdInternal(String id) {
        if (id == null) return null;
        for (T entity : data) {
            String currentId = getIdFn.apply(entity);
            if (currentId != null && currentId.equals(id)) {
                return entity;
            }
        }
        return null;
    }

    protected T saveInternal(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        String id = getIdFn.apply(entity);
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
            setIdFn.accept(entity, id);
        }
        if (findByIdInternal(id) == null) {
            data.add(entity);
            saveToFile();
            return entity;
        }
        return null;
    }

    protected void updateInternal(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        String id = getIdFn.apply(entity);
        if (id == null) {
            throw new IllegalArgumentException("Entity ID must not be null");
        }
        for (int i = 0; i < data.size(); i++) {
            if (id.equals(getIdFn.apply(data.get(i)))) {
                data.set(i, entity);
                saveToFile();
                return;
            }
        }
        data.add(entity);
        saveToFile();
    }

    protected void deleteByIdInternal(String id) {
        if (id == null) return;
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            T entity = it.next();
            String currentId = getIdFn.apply(entity);
            if (currentId != null && currentId.equals(id)) {
                it.remove();
                saveToFile();
                return;
            }
        }
        saveToFile();
    }
}
