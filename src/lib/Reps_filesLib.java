// JAVA 17
package lib;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Reps_filesLib {
    public static class download_txt {
        public static int download(String fileName, String format, List<?> fileInside, boolean isAutoNaming, String path) {
            try {
                Path targetPath = Paths.get(path, fileName + format);
                if (isAutoNaming) {
                    String sourceFileName = fileName;
                    int name_counter = 1;
                    while (Files.exists(targetPath)) {
                        fileName = sourceFileName + " (" + name_counter + ")";
                        targetPath = Paths.get(path, fileName + format);
                        name_counter = name_counter + 1;
                    }
                }
                Files.createDirectories(targetPath.getParent());
                try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
                    for (Object element : fileInside) {
                        String line = (element != null) ? element.toString() : "";
                        writer.write(line);
                        writer.newLine();
                    }
                    return 0;
                } catch (IOException e) {
                    return 1;
                }
            } catch (Exception e) {
                return 1;
            }
        }

        public static int downloads_folder(String fileName, String format, List<?> fileInside, boolean isAutoNaming) {
            try {
                String userHome = System.getProperty("user.home");
                Path targetPath = Paths.get(userHome, "Downloads", fileName + format);
                if (isAutoNaming) {
                    String sourceFileName = fileName;
                    int name_counter = 1;
                    while (Files.exists(targetPath)) {
                        fileName = sourceFileName + " (" + name_counter + ")";
                        targetPath = Paths.get(userHome, "Downloads", fileName + format);
                        name_counter = name_counter + 1;
                    }
                }
                try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
                    for (Object element : fileInside) {
                        String line = (element != null) ? element.toString() : "";
                        writer.write(line);
                        writer.newLine();
                    }
                    return 0;
                } catch (IOException e) {
                    return 1;
                }
            } catch (Exception e) {
                return 1;
            }
        }

        public static int documents_folder(String fileName, String format, List<?> fileInside, boolean isAutoNaming) {
            try {
                String userHome = System.getProperty("user.home");
                Path targetPath = Paths.get(userHome, "Documents", fileName + format);
                if (isAutoNaming) {
                    String sourceFileName = fileName;
                    int name_counter = 1;
                    while (Files.exists(targetPath)) {
                        fileName = sourceFileName + " (" + name_counter + ")";
                        targetPath = Paths.get(userHome, "Documents", fileName + format);
                        name_counter = name_counter + 1;
                    }
                }
                try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
                    for (Object element : fileInside) {
                        String line = (element != null) ? element.toString() : "";
                        writer.write(line);
                        writer.newLine();
                    }
                    return 0;
                } catch (IOException e) {
                    return 1;
                }
            } catch (Exception e) {
                return 1;
            }
        }
    }

    public static class read_txt {
        public static Optional<List<String>> read(String fileName, String format, String path) {
            try {
                Path targetPath = Paths.get(path, fileName + format);
                if (!Files.exists(targetPath)) {
                    return Optional.empty();
                }
                List<String> fileInside = Files.readAllLines(targetPath);
                return Optional.of(fileInside);
            } catch (Exception e) {
                return Optional.empty();
            }
        }
    }
}