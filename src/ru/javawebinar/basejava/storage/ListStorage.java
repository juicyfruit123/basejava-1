package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> listResume = new ArrayList<>();

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        listResume.add(listResume.size(), resume);
    }

    @Override
    public Resume[] getAll() {
        return listResume.toArray(new Resume[listResume.size()]);
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return listResume.get(index);
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        listResume.remove(index);
    }

    @Override
    public int size() {
        return listResume.size();
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        listResume.set(index, resume);
    }

    @Override
    protected int getIndex(String uuid) {
        /*Resume resume = new Resume(uuid);
        return Collections.binarySearch(listResume, resume);
       */
        for (int i = 0; i < listResume.size(); i++) {
            if (listResume.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
