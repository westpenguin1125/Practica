package es.ucm.tp1.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.exceptions.IORecordException;

public class Record {

	private static final String RECORD_FILE = "record.txt";

	private static final String I_FORMAT_ERROR_MSG = String.format("Incorrect format of %s", RECORD_FILE);
	private static final String I_ACCES_ERROR_MSG = String.format("%s file cant be read or does not exist",
			RECORD_FILE);
	private static final String O_ACCES_ERROR_MSG = String.format("%s file cant be writen on", RECORD_FILE);

	Level level;
	double bestTime;

	public Record(Level level) throws IORecordException {
		this.level = level;

		readTime();
	}

	private void readTime() throws IORecordException {

		boolean nivelEncontrado = false;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RECORD_FILE))) {
			String line;

			line = bufferedReader.readLine();
			while (!nivelEncontrado && line != null) {

				if (level.name().equalsIgnoreCase(line.split(":")[0]))
					nivelEncontrado = true;
				if (!nivelEncontrado)
					line = bufferedReader.readLine();
			}

			if (!nivelEncontrado) {
				bestTime = Long.MAX_VALUE;
				System.out.format("Creating default record for level '%s'\n", level.name().toUpperCase());
			}
			else {
				try {
					bestTime = Double.parseDouble(line.split(":")[1]);
				}
				catch (NumberFormatException nfe) {
					throw new IORecordException(I_FORMAT_ERROR_MSG, nfe);
				}
			}

		}
		catch (IOException e) {
			throw new IORecordException(I_ACCES_ERROR_MSG, e);
		}

		if (!nivelEncontrado)
			setNewRecord(bestTime);
	}

	public void setNewRecord(double newRecord) throws IORecordException {
		StringBuilder buffer = new StringBuilder();
		bestTime = newRecord;

		buffer.append(String.format("%s:%.00f\n", level.name().toUpperCase(), bestTime));

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RECORD_FILE))) {

			String line = new String();
			line = bufferedReader.readLine();

			while (line != null) {
				if (!level.name().equalsIgnoreCase(line.split(":")[0]))
					buffer.append(line + "\n");
				line = bufferedReader.readLine();
			}
		}
		catch (IOException e) {
			throw new IORecordException(I_ACCES_ERROR_MSG, e);
		}

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(RECORD_FILE))) {
			bufferedWriter.append(buffer.toString());
		}
		catch (IOException e) {
			throw new IORecordException(O_ACCES_ERROR_MSG, e);
		}
	}

	public double getRecord() {
		return bestTime;
	}

	public void showRecord() {
		System.out.format(Locale.FRANCE, "%s record is %.02f s\n", level.toString(), bestTime / 1000);
	}
}