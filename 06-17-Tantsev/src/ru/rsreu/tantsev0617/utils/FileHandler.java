package ru.rsreu.tantsev0617.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.rsreu.tantsev0617.commercialenterprises.CommercialEnterprise;

public class FileHandler {

	private FileHandler() {

	}

	public static void createFolder(String folderName) {
		File folder = new File(folderName);
		folder.mkdirs();
		System.out.println(Resourcer.getString("message.folder") + folder.getAbsolutePath() + " "
				+ Resourcer.getString("message.created"));
	}

	public static void createFile(File beingCreatedFile) throws Exception {
		if (beingCreatedFile.createNewFile()) {
			System.out.println(Resourcer.getString("message.file") + beingCreatedFile.getAbsolutePath()
					+ Resourcer.getString("message.created"));
		}
	}

	public static void writeToFile(File beingCreatedFile, CommercialEnterprise[] dataForWriting) throws Exception {
		FileOutputStream out = null;
		ObjectOutputStream oos = null;

		try {
			out = new FileOutputStream(beingCreatedFile);
			oos = new ObjectOutputStream(out);
			oos.writeObject(dataForWriting);
		} finally {
			if (oos != null) {
				oos.close();
			}
		}
	}

	public static void copyData(File beingCopiedFile, File beingCreatedFile) throws Exception {
		FileInputStream in = null;
		FileOutputStream out = null;
		int character;

		try {
			in = new FileInputStream(beingCopiedFile);
			out = new FileOutputStream(beingCreatedFile);

			while ((character = in.read()) != -1) {
				out.write(character);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	private static void deleteFile(File beingDeletedFile) {
		if (beingDeletedFile.exists()) {
			beingDeletedFile.delete();
			System.out.println(Resourcer.getString("message.file") + beingDeletedFile.getAbsolutePath()
					+ Resourcer.getString("message.deleted"));
		}
	}

	public static void moveFile(File beingDeletedFile, File beingCreatedFile) throws Exception {
		createFile(beingCreatedFile);
		copyData(beingDeletedFile, beingCreatedFile);
		deleteFile(beingDeletedFile);
		System.out.println(Resourcer.getString("message.file.moved.from") + beingDeletedFile.getAbsolutePath()
				+ Resourcer.getString("message.file.moved.in") + beingCreatedFile.getAbsolutePath());
	}

	public static CommercialEnterprise[] readFromFile(File readableFile) throws Exception {
		FileInputStream in = null;
		ObjectInputStream ois = null;
		CommercialEnterprise[] dataFromFile = {};

		try {
			in = new FileInputStream(readableFile);
			ois = new ObjectInputStream(in);
			dataFromFile = (CommercialEnterprise[]) ois.readObject();
		} finally {
			if (ois != null) {
				ois.close();
			}
		}
		return dataFromFile;
	}
}
