package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.contactMap.put(ContactType.TELEPHONE, "+7(921) 855-0482");
        resume.contactMap.put(ContactType.MAIL, "grigory.kislin");
        resume.contactMap.put(ContactType.GITHUB, "https://github.com/gkislin");
        resume.contactMap.put(ContactType.HOMEPAGE, "http://gkislin.ru/");
        resume.contactMap.put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/gkislin");

        resume.sectionMap.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. "));
        resume.sectionMap.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        List<String> listAchievement = null;
        try {
            listAchievement = Arrays.asList(readUsingFiles("/home/anton/basejava-1/achievement.txt").split("\\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.sectionMap.put(SectionType.ACHIEVEMENT, new AchievementQualifications(listAchievement));
        List<String> listQualification = null;
        try {
           listQualification  = Arrays.asList(readUsingFiles("/home/anton/basejava-1/qualification").split("\\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.sectionMap.put(SectionType.QUALIFICATIONS, new AchievementQualifications(listQualification));
        resume.sectionMap.put(SectionType.EXPERIENCE, new ExperienceEducation("http://javaops.ru/", "10/2013", "12/2019", "Автор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.\n","Автор проекта."));
        resume.sectionMap.put(SectionType.EXPERIENCE, new ExperienceEducation("https://www.wrike.com/", "10/2014", "01/2016", "01/2016 \tСтарший разработчик (backend)\n" +
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", "Старший разработчик (backend)"));
        resume.sectionMap.put(SectionType.EXPERIENCE, new ExperienceEducation("https://www.luxoft.com/", "12/2010", "04/2012", "Ведущий программист\n" +
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.\n"));
        resume.sectionMap.put(SectionType.EDUCATION, new ExperienceEducation("https://www.coursera.org/learn/progfun1", "03/2013", "05/2013 ", "Functional Programming Principles in Scala\" by Martin Odersky"));
        resume.sectionMap.put(SectionType.EDUCATION, new ExperienceEducation("https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html", "03/2011", "04/2011", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));


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
