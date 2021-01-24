//package Command;
//
//import Server.ServerSender;
//import Utilities.FileToStringScanner;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.AccessDeniedException;
//import java.util.Iterator;
//import java.util.TreeSet;
//
//public class Execute_script implements Command {
//
//    public Execute_script(){
//        Invoker.regist("execute_script",this);
//    }
//    private static TreeSet<String> fileNames = new TreeSet<>();
//    private static int numberOfExecution=0;
//
//    /**
//     * The constant inExecution - shows if the script executed from file.
//     */
//    public static boolean inExecution = false;
//
//    private static String executeData = "";
//    /**
//     * Gets execute data.
//     *
//     * @return the execute data
//     */
//    public static String getExecuteData() {
//        return executeData;
//    }
//
//    @Override
//    public String execute(String par1) {
//        try {
//            String executionResult = "";
//            fileNames.add(par1);
//            String data = FileToStringScanner.convert( par1);
//            String[] stroka = data.split("\r\n|\n");
//            for (int i=0;i<stroka.length;i++) {
//                int number = i;
//                inExecution = true;
//                String[] commandAndPar;
//                commandAndPar = stroka[i].split(" ");
//                if (commandAndPar[0].equals("execute_script")) {
//                    Iterator iterator = fileNames.iterator();
//                    boolean alreadyInList = false;
//                    while (iterator.hasNext()) {
//                        if (commandAndPar[1].equals(iterator.next())) alreadyInList = true;
//                    }
//                    if (alreadyInList) {
//                        ServerSender.send("\n!!!Попытка зациклить программу прервана,постарайтесь такого больше не допускать.\n",2);
//                    } else {
//                        fileNames.add(commandAndPar[1]);
//                        ++numberOfExecution;
//                        Invoker.execute(stroka[i]);
//                        --numberOfExecution;
//                    }
//                } else {
//                    executionResult += "\nВыполнение команды " + stroka[i] + ":\n" + Invoker.execute(stroka[i]) + "\n";
//                }
//            }
//            if (numberOfExecution==0){ fileNames.clear();inExecution = false; return (executionResult + "\nВыполнение скрипта завершено.");}
//
//        } catch (AccessDeniedException ex) {
//            if (Execute_script.inExecution) ServerSender.send("Нет доступа к файлу.",2);
//            else ServerSender.send("Нет доступа к файлу.",0);
//        }
//        catch (NullPointerException ex){
//            ex.printStackTrace();
//            if (Execute_script.inExecution) ServerSender.send("Имя файла не указано или файл пустой.",2);
//            else ServerSender.send("Имя файла не указано или файл пустой.",0);
//
//        }
//        catch (FileNotFoundException ex){
//            if (Execute_script.inExecution) ServerSender.send("Файл не найден,попробуйте ещё раз.",2);
//            else ServerSender.send("Файл не найден,попробуйте ещё раз.",0);;
//
//        } catch (IOException e) {
//            ServerSender.send("Проблемы с выполнением скрипта...", 0);
//        }
//        return "Выполнение скрипта завершено.";
//    }
//}
