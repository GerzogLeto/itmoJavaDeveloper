package com.grudnov.lessons.lesson12.exceptions;

import java.io.IOException;
import java.util.Arrays;

public class ExceptionLesson {
    public static void main(String[] args) {
        /* Error Ошибки связанные с проблемами уровня JVM
        например , ошибка нехватки памяти.
        Ошибки (все Error ) не следует обрабатывать в программе

        Exception - исключения. Все исключения можно предугадать
        и обработать. При этом некоторые из них разрбы обязаня обработать
        в своей программе


        Все исключения деляться на:
        1. Исключения времени выполнения (наследники RuntimtException)
        unchecked/необрабатываемые
        Исключения данного типа можно обработать а можно и нет
        2. Все ост искл искл времени компил:
        checked/обрабатыв. Данные искл разраб обязян обработ
         */
        int a = 30;
        int b = 0;
        int res;
        //res = a / b; //java.lang.AritmticExcepion

        int[] ints = new int[3];
//        ints[100] = 90; java.lang.ArrayIndexOutOfBoundsException

        String s = null;
        //      s.equals("data"); java.lang.NullPointerException

        Object data = "123";
//        Integer integer = (Integer) data; java.lang.ClassCastException

        //Обработка искл checked and unchecked
        //использ try catch блок и блок finally

        try {//в блок try помещ код кот может привести к Excep
            res = a / b; //java.lang.ArithmeticException
            //управление переходит в блок catch
            //остальной код в блоке try не выполн
        } catch (ArithmeticException e) {//перехватывает только то исключение
            //которое указано в () (Тип исключения) е- обьект искл
            System.out.println(e.getMessage());// информ об искл
            e.printStackTrace();//весь путь исключения
            res = 100;
        }
        System.out.println("after error " + res);
        //обьединение catch блоков для обработки неск искл
        //1. несколько блоков catch позв обраб разн искл разными способами
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException e) {//перехват ClassCastException и всех его потомков
            System.out.println("Проблема с приведением");
        } catch (ArrayIndexOutOfBoundsException e) {//перехват ArrayIndexOutOfBoundsException
            // и всех его потомков
            System.out.println("Проблема с массивом");
        }
        //2. Все искл надо обраб одинаково
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;

        }catch (ClassCastException | ArrayIndexOutOfBoundsException e){// только один вид искл из двух
            System.out.println("Пробл с массивом или привидением типа");
        }
        //3. через общего родителя
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;

        }catch (RuntimeException e){// только один вид искл из двух
            System.out.println("Пробл с чем то в Runtime");
        }
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;

        }catch (ClassCastException | ArrayIndexOutOfBoundsException e){// только один вид искл из двух
            System.out.println("Пробл с массивом или привидением типа");
        }catch(RuntimeException e) {
            System.out.println("Пробл с чем то в Runtime");// Сначала потомки искл потом родители искл
        }
        //доп блок finally
        finally {
            //этот код выполнится в  случае любого искл, даже если он не перехват в блоке catch
            // и если перехват то тоже выполн. Использ для закрытия ресуросов.
            // Но есть try  с ресурсами для автомат  закр ресурсов


        }
        try{
            voidWithCheckedEx("file.json");
        }catch(IOException e){
            e.printStackTrace();
        }
try{//переменн message обьявл в блоке {}
    //значит ее обл видимости ограничена данным блоком
    Message message = new Message("T");
}catch(ChatException e){
    e.getMessage();
}
    }
        public static  void voidWithCheckedEx(String fileName) throws IOException{
        if(fileName.endsWith("json")){
            // выбрасыв искл времени компиляции т.е. обрабатываемое искл.
            // 1. Либо обработать в try-catch
            //2. либо пробросить исключение. Ответсвенн за обработку ляжет на код который будет вызыв
            //данный метод
            throw new IOException("Trouble with file");
        }
        }
    }