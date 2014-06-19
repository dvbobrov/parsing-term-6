Для сборки и запуска нужна JDK 8. При первом запуске Gradle понадобится подключение к интернету, чтобы скачать себя и библиотеки.
Под Windows вместо ./gradlew нужно использовать gradlew.bat

Запуск тестов:
./gradlew test

Сборка jar-файла:
./gradlew fatJar (долго, около 30 секунд)

Запуск визуализатора:
java -cp build/libs/RecursiveParsing-all-1.0.jar com.dbobrov.labs.recursive_parsing.visualization.Visualizer "EXPRESSION"

Вывод дерева разбора нескольких выражений в не очень читаемом текстовом виде:
java -cp build/libs/RecursiveParsing-all-1.0.jar com.dbobrov.labs.recursive_parsing.Main "EXPRESSION1" "EXPRESSION2" ...