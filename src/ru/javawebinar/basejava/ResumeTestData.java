package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.contacts.put(ContactType.TELEPHONE, "+7(921) 855-0482");
        resume.contacts.put(ContactType.MAIL, "grigory.kislin");
        resume.contacts.put(ContactType.GITHUB, "https://github.com/gkislin");
        resume.contacts.put(ContactType.HOMEPAGE, "http://gkislin.ru/");
        resume.contacts.put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/gkislin");

        resume.sections.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. "));
        resume.sections.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        List<String> listAchievement = null;
        try {
            listAchievement = Arrays.asList(readUsingFiles("/home/anton/basejava-1/achievement.txt").split("\\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        resume.sections.put(SectionType.ACHIEVEMENT, new ListSection(listAchievement));
        List<String> listQualification = null;
        try {
            listQualification = Arrays.asList(readUsingFiles("/home/anton/basejava-1/qualification").split("\\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.sections.put(SectionType.QUALIFICATIONS, new ListSection(listQualification));
        List<ExperienceEducation> experienceEducationList = new ArrayList<>();
        experienceEducationList.add(new ExperienceEducation("Java Online Projects", "http://javaops.ru/", LocalDate.of(2013, 10, 1), LocalDate.of(2019, 12, 1),
                "Создание, организация и проведение Java онлайн проектов и стажировок.\n", "Автор проекта."));
        experienceEducationList.add(new ExperienceEducation("Wrike", "https://www.wrike.com/", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1),
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", "Старший разработчик (backend)"));
        experienceEducationList.add(new ExperienceEducation("Luxoft", "https://www.luxoft.com/", LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Ведущий программист\n" +
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.\n"));
        resume.sections.put(SectionType.EXPERIENCE, new ExperienceEducationSection(experienceEducationList));


        List<ExperienceEducation> educationList = new ArrayList<>();
        educationList.add(new ExperienceEducation("Coursera", "https://www.coursera.org/learn/progfun1", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "Functional Programming Principles in Scala\" by Martin Odersky"));
        educationList.add(new ExperienceEducation("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html", LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));
        resume.sections.put(SectionType.EDUCATION, new ExperienceEducationSection(educationList));


        System.out.println(resume.getContact(ContactType.GITHUB));
        System.out.println(resume.getContact(ContactType.TELEPHONE));


        System.out.println(resume.getSection(SectionType.ACHIEVEMENT));
        System.out.println(resume.getSection(SectionType.QUALIFICATIONS));
        System.out.println(resume.getSection(SectionType.EXPERIENCE));
        System.out.println(resume.getSection(SectionType.EDUCATION));

    }

    private static String readUsingFiles(String fileName) throws IOException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return fileName;
        }
    }

}
