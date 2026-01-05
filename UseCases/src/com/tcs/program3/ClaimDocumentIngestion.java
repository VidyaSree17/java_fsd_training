package com.tcs.program3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class ClaimDocumentIngestion {

	public static void main(String[] args) {

		// Creating directories
		Path basedir = Paths.get("claims_processing").toAbsolutePath();
		List<Path> dirs = List.of(basedir.resolve("incoming_claims"), basedir.resolve("processing_claims"),
				basedir.resolve("processed_claims"), basedir.resolve("error_claims"),
				basedir.resolve("claims_archive"));
		for (Path p : dirs) {
			try {
				Files.createDirectories(p);
				System.out.println(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// monitoring incoming claims folder for claims

		Timer timer = new Timer("incoming_claims", false);
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					System.out.println("Polling incoming_claims...");
					//creating incoming_claims object
					File dir = new File(
							"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/UseCases/claims_processing/incoming_claims/");
					
					//name validation of files
					Pattern pattern = Pattern.compile("^claim_.*\\.(pdf|jpeg?g)$", Pattern.CASE_INSENSITIVE);
					if (dir.exists() && dir.isDirectory()) {
						//listing files in incoming_claims folder
						File[] files = dir.listFiles();
						if (files != null) {
							for (File file : files) {
								if (file.isFile()) {
									String name = file.getName();
									boolean isValid = pattern.matcher(name).matches();
									if (isValid) {
										System.out.println("Valid " + name);
										try {
											
											
										//Moving valid files from incoming_claims to processing claims
											
										Path source = Paths.get(
												"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/"
														+ "UseCases/claims_processing/incoming_claims");
										Path target = Paths.get(
												"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/"
														+ "UseCases/claims_processing/processing_claims/");
										Path sourceFile=source.resolve(name);
										Path targetFile=target.resolve(sourceFile.getFileName());
										Path movedFiles = Files.move(sourceFile, targetFile,StandardCopyOption.REPLACE_EXISTING);
										System.out.printf("[%s] SUCCESS: Moved %s -> %s%n", java.time.LocalDateTime.now(),sourceFile.toAbsolutePath(),movedFiles.toAbsolutePath());
						
										//Moving valid files from processing_claims to processed_claims
									
										Path target1 = Paths.get(
												"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/"
														+ "UseCases/claims_processing/processed_claims/");
										Path targetFile1=target1.resolve(targetFile.getFileName());
										Path movedFiles1 = Files.move(targetFile, targetFile1,StandardCopyOption.REPLACE_EXISTING);
										System.out.printf("[%s] SUCCESS: Moved %s -> %s%n", java.time.LocalDateTime.now(),targetFile.toAbsolutePath(),movedFiles1.toAbsolutePath());
										
										//creating a timestamped archive directory
										
										Path archivebase=Paths.get("/home/labuser/Documents"
												+ "/workspace-spring-tool-suite-4-4.23.1.RELEASE/UseCases/claims_processing/claims_archive//");
										String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
										System.out.println(timestamp);
										Path archivdir = archivebase.resolve(timestamp);
										System.out.println(archivdir);
										Files.createDirectories(archivdir);
										System.out.println("Archive directory created");
										
										//Moving files from processed_claims to archive timestamped directory
										
										Path targetFile2=archivdir.resolve(targetFile1.getFileName());
										Path movedFiles2 = Files.move(targetFile1, targetFile2,StandardCopyOption.REPLACE_EXISTING);
										System.out.printf("[%s] SUCCESS: Moved %s -> %s%n", java.time.LocalDateTime.now(),targetFile1.toAbsolutePath(),movedFiles2.toAbsolutePath());
										
										}catch(Exception e) {
											e.printStackTrace();
										}
									} else {
										System.out.println("Not Valid " + name);
										
										//Moving invalid files from incoming_claims to error_claims
										
										Path source = Paths.get(
												"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/"
														+ "UseCases/claims_processing/incoming_claims");
										Path target = Paths.get(
												"/home/labuser/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/"
														+ "UseCases/claims_processing/error_claims/");
										Path sourceFile=source.resolve(name);
										Path targetFile=target.resolve(sourceFile.getFileName());
										Path movedFiles = Files.move(sourceFile, targetFile,StandardCopyOption.REPLACE_EXISTING);
										System.out.printf("[%s] SUCCESS: Moved %s -> %s%n", java.time.LocalDateTime.now(),sourceFile.toAbsolutePath(),movedFiles.toAbsolutePath());
									}
								}

							}
						} else {
							System.out.println("No files");
						}

					} else {
						System.out.println("no dir");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}, 0, 60000);

		try {
			Thread.sleep(10000);
			System.out.println("Main Thread Running...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
