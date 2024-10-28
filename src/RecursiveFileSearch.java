import java.io.File;

public class RecursiveFileSearch {
    public static boolean searchFile(File directory, String fileName) {
        // Base case: If directory is not valid
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("The directory does not exist or is not a valid directory.");
        }

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            return false;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursive case: Search in subdirectory
                if (searchFile(file, fileName)) {
                    return true;
                }
            } else if (file.getName().equals(fileName)) {
                // File found
                System.out.println("File found: " + file.getAbsolutePath());
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory> <filename>");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];
        File directory = new File(directoryPath);

        try {
            if (!searchFile(directory, fileName)) {
                System.out.println("File not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
