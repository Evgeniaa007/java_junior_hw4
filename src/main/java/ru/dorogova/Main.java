package ru.dorogova;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()){
            //создание
            Session session = sessionFactory.getCurrentSession();
            //запуск
            session.beginTransaction();

            //создание объектов для записи
            Person person1 = Person.createPerson();
            Person person2 = Person.createPerson();
            Person person3 = Person.createPerson();

            //сохраненение
            session.save(person1);
            session.save(person2);
            session.save(person3);
            System.out.println("Объекты были успешно сохранены");

            //чтение
            Person readPerson = session.get(Person.class, person2.getId());
            System.out.println("Чтение объекта.");
            System.out.println("Получен объект: " + readPerson);

            //изменение объекта
            readPerson.updateAge();
            readPerson.updateOccupation();
            session.update(readPerson);
            System.out.println("Данные об объекте были изменены");
            System.out.println("Новые данные об объекте: " + readPerson);

            //удаление
            session.delete(person3);
            System.out.println("Объект удален");

            session.getTransaction().commit();
                    }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}