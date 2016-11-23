package fi.sjs.domore.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository("UploadDao")
public class UploadDAO {	
	
	private static final String imgFolder = "kuvat";
	private static final String tomcatPath = System.getProperty("catalina.home");
	private static final String imagesPath = tomcatPath + File.separator + imgFolder;
	private static final File imagesDir = new File(imagesPath);
	
	 public void createImagesDirIfNeeded() {
	        if (!imagesDir.exists()) {
	            imagesDir.mkdirs();
	        }
	 }
	 
	 public void createUserDir(int kId) {
		 File userFolder = new File (imagesPath + File.separator + kId);		 
	        if (!userFolder.exists()) {
	            userFolder.mkdirs();
	        }
	 }
	 
	public void saveImage(MultipartFile file, int kayttajaId) {
		 
		try {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			System.out.println(src.toString());
			createUserDir(kayttajaId);
			File destination = new File(imagesPath + File.separator + kayttajaId + File.separator + kayttajaId + ".jpg"); 
			ImageIO.write(src, "jpg", destination);
		} catch (IOException e) {
			System.out.println("Upload ei onnistunut");
			e.printStackTrace();
		}
		 
	 }

}
