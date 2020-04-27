package config;

import org.springframework.context.annotation.Configuration;

//класс для подключения ресурсов

@Configuration
public class RootConfig {

}


//    Создаем класс RootConfig который будет унаследован
//    от WebMvcConfigurerAdapter — этот класс имплементирует
//    интерфейс WebMvcConfigurer, которые имеет очень много методов.
//    Из них самые используемые: настройка ресурсов, валидации,
//    сообщений (messaging), интерцепторы (interceptors) и другие.
//    Больше Вы сможете найти в документации. Не забудьте пометить
//    свой класс аннотацией @Configuration