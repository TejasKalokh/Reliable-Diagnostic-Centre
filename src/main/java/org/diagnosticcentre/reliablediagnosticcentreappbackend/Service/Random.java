package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service;


    import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Random {

        public static File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
            // Create a temporary file
            Path tempFile = Files.createTempFile("temp", multipartFile.getOriginalFilename());
            File file = tempFile.toFile();

            // Copy the MultipartFile's content to the temporary file
            try {
                Files.copy(multipartFile.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                // Handle the exception (e.g., log, throw a custom exception)
                Files.deleteIfExists(tempFile); // Clean up the temp file
                throw e;
            }

            // Return the File object
            return file;

    }
}
