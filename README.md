<p align="center"> 
 <img src="https://revizto.com/wp-content/uploads/2021/02/logo.svg" title="Revizto" alt="Revizto" width="236" height="120" />
</p>

# Revizto UI Automation Tests

Проект автоматизированного тестирования пользовательского интерфейса для веб-сайта [Revizto](https://revizto.com/) - платформы для совместной работы в сфере архитектуры, инженерии и строительства (AEC).

## 🛠 Технологии и инструменты

### Основной стек:
<p align="left">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original-wordmark.svg" title="JUnit 5" alt="JUnit 5" width="40" height="40"/>      
<img src="https://github.com/push-mybuttons/resources/blob/main/icons/Selenide.svg" title="Selenide" alt="Selenide" width="40" height="40"/>
<img src="https://avatars.githubusercontent.com/u/5879054?s=200&v=4" title="Allure Report" alt="Allure Report" width="40" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/>
</p>


### Дополнительные инструменты:
- **Owner 1.0.12** - библиотека для управления конфигурацией
- **Lombok** - библиотека для автоматической генерации boilerplate кода
- **Allure Selenide 2.21.0** - интеграция Selenide с Allure для расширенной отчетности
- **Selenoid** - легковесная платформа для запуска браузеров в Docker-контейнерах
- **JavaFaker** - библиотека для генерации тестовых данных

## 📋 Покрытый функционал

### 1. Главная страница (`MainPageTest`)
- **Навигация по заголовку:**
  - Переход к форме запроса демо через кнопку "Request a Demo"
  - Переход к разделу решений через меню "Solutions"
- **Навигация по разделу "Company":**
  - Переход к странице карьеры через подменю "Careers"
- **Подписка на новости:**
  - Переход к форме подписки на рассылку
- **Функциональность новостных слайдов:**
  - Переключение между слайдами новостей

### 2. Поиск на странице Studies (`CaseStudiesSearchTest`)
- **Параметризованное тестирование:**
  - Поиск по различным запросам: "kiwi", "construction", "architecture"
  - Использование `@CsvSource` для передачи тестовых данных
- **Негативное тестирование:**
  - Проверка поведения при поиске несуществующего контента

### 3. Подписка на рассылку (`SubscribePageTest`)
- **Форма подписки:**
  - Заполнение всех обязательных полей (email, имя, фамилия, страна)
  - Выбор штата (при необходимости)
  - Подтверждение успешной подписки

## 🏗 Архитектура проекта

### Паттерн Page Object Model
Каждая веб-страница представлена отдельным классом:
- `MainPage` - главная страница
- `CaseStudiesPage` - страница Studies
- `SubscribePage` - страница Subscribe
- `DemoRequestPage` - страница запроса демо
- `SolutionsPage` - страница Solutions
- `CareersPage` - страница Career

### Базовые компоненты

#### `BaseTest`
- Конфигурация окружения тестирования
- Поддержка локального и удаленного запуска
- Настройка браузера, размера окна, таймаутов
- Интеграция с Allure для логирования
- Автоматическое закрытие браузера после каждого теста

#### `TestData`
- Генерация тестовых данных (email, имена, страны)
- Поисковые запросы для позитивного и негативного тестирования
- Использование аннотации `@UtilityClass` от Lombok

#### `Attach`
- Создание вложений для Allure отчетов:
  - Скриншоты страниц
  - HTML исходный код страницы
  - Логи браузера
  - Видеозапись прохождения тестов

## 🚀 Запуск тестов

### Локальный запуск
```bash
# Запуск всех тестов
./gradlew test

# Запуск с параметрами
./gradlew test -Dbrowser=chrome -DbrowserSize=1920x1080 

# Запуск конкретного класса
./gradlew test --tests MainPageTest
```


### Параметры конфигурации
- `baseUrl` - базовый URL (по умолчанию: https://revizto.com/en/)
- `browser` - браузер (по умолчанию: chrome)
- `browserVersion` - версия браузера (по умолчанию: 131.0)
- `browserSize` - размер окна (по умолчанию: 1920x1080)
- `remote` - URL удаленного драйвера
- `headless` - headless режим (по умолчанию: false)
- `local` - локальный запуск (по умолчанию: false, тесты запускаются через Selenoid)

## 🔄 CI/CD интеграция с Jenkins

Проект интегрирован с Jenkins для автоматического запуска тестов.

### 🔗 Jenkins Job
**[Jenkins Job: 035-mariia_p-ui](https://jenkins.autotests.cloud/job/035-mariia_p-ui/)**

### Конфигурация запуска
Тесты автоматически запускаются в Jenkins со следующими параметрами:
- **Окружение**: Удаленное выполнение через Selenoid
- **Браузер**: Chrome 128.0
- **Размер окна**: 1920x1080
- **Gradle команда**: `clean test`


## 📊 Отчетность

### Генерация Allure отчета

#### Локально:
```bash
# Генерация отчета
./gradlew allureReport

# Запуск сервера с отчетом
./gradlew allureServe
```

#### В Jenkins:
Allure отчет генерируется автоматически после каждого запуска тестов и доступен по ссылке:
- **[Последний Allure Report](https://jenkins.autotests.cloud/job/035-mariia_p-ui/allure/)**

<img width="1511" height="861" alt="image" src="https://github.com/user-attachments/assets/6cc2d0ab-d349-46b7-aa2f-fd5447c4c00d" />


### Структура отчетов
- **Epic**: группировка по основным функциональным областям
- **Feature**: группировка по конкретным возможностям
- **Story**: детализация пользовательских историй
- **@DisplayName**: человекочитаемые названия тестов
- **@Owner**: указание ответственного за тест
- **@Severity**: уровень критичности теста



## 🎯 Особенности реализации

### Лучшие практики
- ✅ **Модульность**: каждая страница имеет свой PageObject класс
- ✅ **Универсальность**: методы принимают параметры, а не используют хардкод
- ✅ **Чистота тестов**: браузер закрывается после каждого теста
- ✅ **Параметризация**: использование `@ParameterizedTest` с различными источниками данных
- ✅ **Логирование**: все действия логируются через аннотацию `@Step`
- ✅ **Ожидания**: корректное использование явных ожиданий Selenide

### Соответствие требованиям
- **UI-тестирование**: реализовано 10 тестов
- **PageObject паттерн**: каждая страница представлена отдельным классом
- **Базовый класс**: `BaseTest` с методами `@BeforeAll` и `@AfterEach`
- **Allure интеграция**: подробная отчетность с вложениями (скриншоты, HTML, логи, видео)
- **Параметризованные тесты**: реализовано в `CaseStudiesSearchTest` с использованием `@CsvSource`
- **Управление конфигурацией**: через системные свойства
- **CI/CD**: интеграция с Jenkins для автоматического запуска тестов
- **Удаленное выполнение**: поддержка запуска через Selenoid

---

*Автор: MariiaP*  
*Версия: 1.1.0*  
*Обновлено: Октябрь 2025*
