package com.nttdata.boilerplate.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	
	public static void copy(InputStream in, OutputStream out) throws IOException {
	    while (true) {
	      int c = in.read();
	      if (c == -1)
	        break;
	      out.write((char) c);
	    }
	  }

	  public static boolean checkDuplicateProject(String projectName) {
	    boolean alreadyExists = false;
	    File file = new File(projectName);
	    if (file.isDirectory() && file.exists()) {
	      alreadyExists = true;
	    }
	    return alreadyExists;
	  }

}
