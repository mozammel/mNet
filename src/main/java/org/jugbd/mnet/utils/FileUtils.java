package org.jugbd.mnet.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
public class FileUtils {
    public static final int FILE_NAME_MAX_SIZE = 60;

    private static final Map<String, String> extensionContentTypeMap;

    static {
        extensionContentTypeMap = new HashMap<>();
        extensionContentTypeMap.put("jpg", "image/jpeg");
        extensionContentTypeMap.put("jpeg", "image/jpeg");
        extensionContentTypeMap.put("png", "image/png");
        extensionContentTypeMap.put("pdf", "application/pdf");
        extensionContentTypeMap.put("doc", "application/msword");
        extensionContentTypeMap.put("docx", "application/msword");
    }

    public static boolean isValidFile(MultipartFile file, String[] fileTypeList) {
        String fileName = file.getOriginalFilename();
        String extension = getExtensionInLowerCase(fileName);
        for (String validFileType : fileTypeList) {
            if (extension.equalsIgnoreCase(validFileType)) {
                return true;
            }
        }
        return false;
    }

    public static String getContentType(String extension) {
        return extensionContentTypeMap.get(extension.toLowerCase());
    }

    public static String getExtensionInLowerCase(String fileName) {
        return FilenameUtils.getExtension(fileName).toLowerCase();
    }

    public static String getExtensionFromContentType(String contentType) {
        String key = "";
        for (Map.Entry<String, String> entry : extensionContentTypeMap.entrySet()) {
            if ((entry.getValue().equalsIgnoreCase(contentType))) {
                key = entry.getKey();
            }
        }
        return key;
    }

    /**
     * Get file name trimmed to FILE_NAME_MAX_SIZE and also extension to lower case (bcoz, people tend to have file in uppercase extension like JPG, jpg)
     *
     * @param fileName User's file name
     * @return
     */
    public static String getFilteredFileName(String fileName) {
        String extension = getExtensionInLowerCase(fileName);
        String baseName = FilenameUtils.getBaseName(fileName);
        baseName = baseName.replaceAll(" ", "-");
        return StringUtils.getTrimmedString(baseName, FILE_NAME_MAX_SIZE - extension.length()) + "." + extension;
    }
}
