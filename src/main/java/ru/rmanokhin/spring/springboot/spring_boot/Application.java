package ru.rmanokhin.spring.springboot.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//сканирование происходит от папки в которой лежит данный файл, следовательно класс должен быть выше по иерархии
//или необходимо (scanBasePackages = "") указать какие пакеты будут сканироваться для поиска бинов
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
