package ru.javawebinar.basejava.model;

import java.util.Objects;
import java.util.UUID;

/**
 * ru.javawebinar.basejava.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }
    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume() {
    }


    /* @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Resume resume = (Resume) o;
         return Objects.equals(uuid, resume.uuid) &&
                 Objects.equals(fullName, resume.fullName);
     }
 */@Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;

       Resume resume = (Resume) o;

       if (!uuid.equals(resume.uuid)) return false;
       return fullName.equals(resume.fullName);

   }
   /* @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }*/
   @Override
   public int hashCode() {
       int result = uuid.hashCode();
       result = 31 * result + fullName.hashCode();
       return result;
   }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Resume resume) {
        int a = fullName.compareTo(resume.fullName);
        return a != 0 ? a : uuid.compareTo(resume.uuid);
    }
}