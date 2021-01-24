//package Utilities;
//
//import Command.*;
//import Movie.Movie;
//import Movie.MovieCollection;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Класс-утилита для реализации команды execute_script.
// * В классе описано выполнение команд, полученных при обработке скрипт-файла.
// *
// * @author Deimos
// * @version 1.00
// */
//public class Executer {
//
//    /**
//     * Метод обрабатывает файл и выполняет список команд, описанных в нём
//     * @param fileName имя файла с командами
//     */
//    public static void executeFile(String fileName) {
//        ArrayList<String> executeFiles = new ArrayList<>();
//        executeFiles.add("C:\\Users\\wers0\\Desktop\\script.txt");
//        FileToStringScanner fileToStringScanner = new FileToStringScanner();
//        MovieCollection movies = new MovieCollection();
//        MovieCreator creator = new MovieCreator();
//        Iterator<Movie> iterator = movies.getMovies().iterator();
//
//        Invoker invoker = new Invoker();
//        Info info = new Info();
//        Show show = new Show();
//        Help help = new Help();
//        Clear clear = new Clear();
//        Add add = new Add();
//        Update_by_id update_by_id = new Update_by_id();
//        Save save = new Save();
//        Exit exit = new Exit();
//        Add_if_min add_if_min = new Add_if_min();
//        History history = new History();
//        Sum_of_total_box_office sum_of_total_box_office = new Sum_of_total_box_office();
//        Remove_any_by_oscars_count remove_any_by_oscars_count = new Remove_any_by_oscars_count();
//        Remove_lower remove_lower = new Remove_lower();
//        Remove_by_id remove_by_id = new Remove_by_id();
//        Execute_script execute_script = new Execute_script();
//        Print_field_descending_person_height print_field_descending_person_height = new Print_field_descending_person_height();
//
//        String data = fileToStringScanner.convert(fileName);
//        String[] commands = data.split("\n|\r\n");
//
//        for (String commandName : commands) {
//            if (!commandName.equals("")) {
//                String[] complexCommand = commandName.split(" ");
//                if (complexCommand[0].equals("add") || complexCommand[0].equals("remove_any_by_oscars_count") || complexCommand[0].equals("remove_by_id") || complexCommand[0].equals("remove_lower") || complexCommand[0].equals("update_by_id") || complexCommand[0].equals("add_if_min") || complexCommand[0].equals("execute_script") || complexCommand[0].equals("exit")) {
//
//                    if (complexCommand[0].equals("add")) {
//                        try {
//                            System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\":");
//                            movies.addToCollection(creator.createFromScript(complexCommand));
//                            Invoker.addToHistory(complexCommand[0]);
//                        } catch (Exception e) {
//                            System.out.println("Неверный формат ввода в файле");
//                        }
//                    }
//
//                    if (complexCommand[0].equals("remove_any_by_oscars_count")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\"" + complexCommand[1] + ":");
//                        remove_any_by_oscars_count.execute(complexCommand[1]);
//                        Invoker.addToHistory(complexCommand[0]);
//                    }
//
//                    if (complexCommand[0].equals("remove_by_id")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\"" + complexCommand[1] + ":");
//                        remove_by_id.execute(complexCommand[1]);
//                        Invoker.addToHistory(complexCommand[0]);
//                    }
//                    if (complexCommand[0].equals("remove_lower")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\"" + complexCommand[1] + ":");
//                        remove_lower.execute(complexCommand[1]);
//                        Invoker.addToHistory(complexCommand[0]);
//                    }
//
//                    if (complexCommand[0].equals("update_by_id")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\"" + complexCommand[1] + ":");
//                        while (iterator.hasNext()) {
//                            Movie movie = iterator.next();
//                            int movieId = movie.getId();
//                            if (movieId == Integer.parseInt(complexCommand[1])) {
//                                iterator.remove();
//                                System.out.println("Удалён элемент с id " + movieId);
//                                break;
//                            }
//                        }
//                        movies.addToCollection(creator.createFromScriptArg(complexCommand));
//                        System.out.println("Добавлен элемент с id" + complexCommand[1]);
//                        Invoker.addToHistory(complexCommand[0]);
//                    }
//
//                    if (complexCommand[0].equals("add_if_min")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\" " + complexCommand[1] + ":");
//                        if (Integer.parseInt(complexCommand[1]) < movies.getMinId()) {
//                            System.out.println("Попытка создать элемент с id " + complexCommand[1]);
//                            movies.addToCollection(creator.createFromScriptArg(complexCommand));
//                        } else System.out.println("Извините, но ваш id слишком большой :)");
//                        Invoker.addToHistory(complexCommand[0]);
//                    }
//
//                    if (complexCommand[0].equals("execute_script")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\":\n" + complexCommand[1]);
//                        if (executeFiles.contains(complexCommand[1])) System.out.println("Аргумент команды содержит путь к недопустимому для исполнения файлу " + complexCommand[1]);
//                        else {
//                            execute_script.execute(complexCommand[1]);
//                            Invoker.addToHistory(complexCommand[0]);
//                            executeFiles.add(complexCommand[1]);
//                        }
//                    }
//
//                    if (complexCommand[0].equals("exit")) {
//                        System.out.println("\nВыполняется команда \"" + complexCommand[0] + "\":");
//                        Invoker.addToHistory(complexCommand[0]);
//                        try {
//
//                            if (complexCommand[1].equals("yes")) System.exit(0);
//                        } catch (ArrayIndexOutOfBoundsException e) {
//                            try {
//                                Invoker.execute(commandName);
//                            }catch (IOException ignored1) {} }
//                    }
//
//                } else {
//                    try {
//                        System.out.println("\nВыполняется команда \"" + commandName + "\":");
//                        Invoker.execute(commandName);
//                    } catch (IOException e) {
//                        System.out.println("Внезапно-появившаяся ошибка ввода-вывода. Время подумать о вечном и перестать выполнять файл");
//                    }
//                }
//            }
//        }
//
//    }
//}
