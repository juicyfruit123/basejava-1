package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected void saveResume(Resume resume, int index) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected int getIndex(String uuid) {
        return mapResume.containsKey(uuid) ? 1 : -1;
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return mapResume.get(uuid);
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        mapResume.remove(uuid);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = mapResume.values().toArray(new Resume[mapResume.size()]);
        Arrays.sort(resumes);
        return resumes;
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
