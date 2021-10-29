package ru.rsreu.tantsev0617;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import ru.rsreu.tantsev0617.commercialenterprises.CommercialEnterprise;
import ru.rsreu.tantsev0617.commercialenterprises.CommercialEnterprisesInitializer;
import ru.rsreu.tantsev0617.utils.FileHandler;
import ru.rsreu.tantsev0617.utils.Resourcer;
import ru.rsreu.tantsev0617.utils.TableCreater;

public class Runner {

	private Runner() {

	}

	public static void main(String[] args) {
		FileHandler.createFolder(Resourcer.getString("files.folder.source.name"));
		FileHandler.createFolder(Resourcer.getString("files.folder.source.name") + File.separator
				+ Resourcer.getString("files.folder.copy.name"));
		FileHandler.createFolder(Resourcer.getString("files.folder.move.name"));

		boolean fileInSourceCreatedAndRecorded = true;
		String relativePathToFileInSource = Resourcer.getString("files.folder.source.name") + File.separator
				+ Resourcer.getString("files.file.data.name") + Resourcer.getString("files.file.data.extension");
		File fileInSource = new File(relativePathToFileInSource);
		try {
			FileHandler.createFile(fileInSource);
		} catch (Exception e) {
			fileInSourceCreatedAndRecorded = false;
			System.out.println(Resourcer.getString("message.error.creating.file") + fileInSource.getAbsolutePath());
		}

		CommercialEnterprise[] dataForWritingInFile = CommercialEnterprisesInitializer
				.initializeCommercialEnterprises();
		try {
			FileHandler.writeToFile(fileInSource, dataForWritingInFile);
		} catch (Exception e) {
			fileInSourceCreatedAndRecorded = false;
			System.out.println(Resourcer.getString("message.error.writing.file") + fileInSource.getAbsolutePath());
		}

		String relativePathToFileInCopy = Resourcer.getString("files.folder.source.name") + File.separator
				+ Resourcer.getString("files.folder.copy.name") + File.separator
				+ Resourcer.getString("files.file.data.name") + Resourcer.getString("files.file.backup.extension");
		File fileInCopy = new File(relativePathToFileInCopy);
		try {
			FileHandler.createFile(fileInCopy);
		} catch (Exception e) {
			System.out.println(Resourcer.getString("message.error.creating.file") + fileInCopy.getAbsolutePath());
		}
		try {
			FileHandler.copyData(fileInSource, fileInCopy);
		} catch (Exception e1) {
			System.out.println(Resourcer.getString("message.error.copying.data.from") + fileInSource.getAbsolutePath()
					+ Resourcer.getString("message.error.copying.data.in") + fileInCopy.getAbsolutePath());
		}

		String relativePathToFileInMove = Resourcer.getString("files.folder.move.name") + File.separator
				+ Resourcer.getString("files.file.data.name") + Resourcer.getString("files.file.data.extension");
		File fileInMove = new File(relativePathToFileInMove);
		String response = "";
		if (fileInSourceCreatedAndRecorded) {
			Scanner in = new Scanner(System.in);
			System.out.println(Resourcer.getString("message.user.request.to.move.file"));
			while (true) {
				response = in.nextLine();
				if (response.equals(Resourcer.getString("message.positive.user.response.to.request"))) {
					try {
						FileHandler.moveFile(fileInSource, fileInMove);
					} catch (Exception e) {
						System.out.println(Resourcer.getString("message.error.move.file.from")
								+ fileInSource.getAbsolutePath() + Resourcer.getString("message.error.move.file.in")
								+ fileInMove.getAbsolutePath());
					}
					break;
				} else if (response.equals(Resourcer.getString("message.negative.user.response.to.request"))) {
					break;
				} else {
					System.out.println(Resourcer.getString("message.incorrect.response.to.request"));
				}
			}
		}

		System.out.println();

		System.out.println(Resourcer.getString("message.array.to.write"));
		TableCreater.createTable(dataForWritingInFile);
		System.out.println();

		CommercialEnterprise[] dataFromFileInCopy = {};
		try {
			dataFromFileInCopy = FileHandler.readFromFile(fileInCopy);
		} catch (Exception e) {
			System.out.println(Resourcer.getString("message.error.reading.file") + fileInCopy.getAbsolutePath());
			System.out.println();
		}

		if (dataFromFileInCopy.length != 0) {
			System.out.println(Resourcer.getString("message.array.read.from.file.in.Copy"));
			TableCreater.createTable(dataFromFileInCopy);
			System.out.println();
		}

		if (response.equals(Resourcer.getString("message.positive.user.response.to.request"))) {
			CommercialEnterprise[] dataFromFileInMove = {};
			try {
				dataFromFileInMove = FileHandler.readFromFile(fileInMove);
			} catch (Exception e) {
				System.out.println(Resourcer.getString("message.error.reading.file") + fileInMove.getAbsolutePath());
				System.out.println();
			}

			if (dataFromFileInMove.length != 0) {
				System.out.println(Resourcer.getString("message.array.read.from.file.in.Move"));
				TableCreater.createTable(dataFromFileInMove);
				System.out.println();
			}

			if (Arrays.equals(dataForWritingInFile, dataFromFileInMove)) {
				System.out.println(Resourcer.getString("message.array.to.write.equals.array.read.from.file.in.Move"));
			} else {
				System.out
						.println(Resourcer.getString("message.array.to.write.not.equals.array.read.from.file.in.Move"));
			}

			if (Arrays.equals(dataFromFileInCopy, dataFromFileInMove)) {
				System.out.println(Resourcer
						.getString("message.array.read.from.file.in.Copy.equals.array.read.from.file.in.Move"));
			} else {
				System.out.println(Resourcer
						.getString("message.array.read.from.file.in.Copy.not.equals.array.read.from.file.in.Move"));
			}
		}

		if (Arrays.equals(dataForWritingInFile, dataFromFileInCopy)) {
			System.out.println(Resourcer.getString("message.array.to.write.equals.array.read.from.file.in.Copy"));
		} else {
			System.out.println(Resourcer.getString("message.array.to.write.not.equals.array.read.from.file.in.Copy"));
		}

	}
}
