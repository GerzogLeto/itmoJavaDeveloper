
Lesson6

hw1 Условия

Описать объектную модель Альпинист, Гора, Группа для восхождения на гору.
Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов).
Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров)
Группа для восхождения на гору создаётся со следующими характеристиками:
идёт набор в группу или нет;
массив альпинистов;
гора;
должна быть возможность добавить альпиниста в группу, если набор ещё идёт
В методе main (отдельного класса) создать:
3 группы для восхождений на 3 различных горы.
В первой группе 3 альпиниста (набор закрыт)
Во второй и третьей группах по 2 альпиниста (набор в эти группы закрыт)
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.

hw2 Условия

Список разрешенных продуктов
Класс Пищевая Ценность
Свойства: имя продукта / белки / жиры / углеводы / калории
Минимум 4 конструктора
Реализовать необходимые проверки входящих данных
Создать не менее 4 экземпляров данного класса (объектов)
Класс Мои Продукты
Свойства: разрешенное количество белков / жиров / углеводов / калорий / список разрешенных продуктов (массив)
Реализовать метод, который принимает на вход название продукта и добавляет его в список разрешенных,
если характеристики продукта полностью соответствуют заявленным разрешениям,
в противном случае сообщить, по какой причине продукт не может быть добавлен в список
Реализовать метод, который показывает список разрешенных продуктов
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.


hw3 Условия

Доработать метод public void addColouring(ColouringBook... books) из класса com.ifmo.jjd.lesson6.ColouringShelf
Метод должен добавлять несколько объектов (books) в массив colouring



Lesson7

hwSchool Условия

Задача "Школа":
        
        Класс Ученик 
        создается со следующими характеристиками:
            имя (тип String)
            возраст (тип int)
            изучаемый предмет (тип String)
            уровень знаний (тип int)
        и методом:
            учиться() - уровень знаний ученика повышается
        
        Класс Учитель 
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
            преподаваемый предмет (тип String)
        и методом:
            учить(обучаемый) - тип данных обучаемого определить самостоятельно
        
        Класс Директор 
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
        и методами:
            объявить начало занятий()
            объявить окончание занятий занятий()
        
        Класс Школа
        создается со следующими харатеристиками:
            название - задается при создании объекта и не может быть изменено в последствии
            директор - школа не может функционировать без директора
            учителя[] - массив
            ученики[] - массив
        и методом:
            день в школе() - 
                1. директор объявляет начало занятий
                2. учителя учат учеников (предмет учителя и ученика должны совпадать)
                3. директор объявляет окончание занятий
        
        Методы учить() и учиться() необходимо описать в разных интерфейсах
        Общие свойства необходимо вынести в родительские классы (какие определить самостоятельно)
        В классах можно добавлять методы и свойства при необходимости 
        

 