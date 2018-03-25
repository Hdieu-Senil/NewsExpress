package util;

import javax.servlet.http.Part;

public class FilenameUtil {
	public static String getFilename(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static String renameFile(String filename) {
		String[] tachFilename = filename.split("[.]");
		String duoiFilename = tachFilename[tachFilename.length - 1];
		String tmp = "";
		for (int i = 0; i < tachFilename.length - 1; i++) {
			tmp += tachFilename[i] + "-";
		}
		String newFilename = tmp + System.nanoTime() + "." + duoiFilename;
		return newFilename;
	}
}
