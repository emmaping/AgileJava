package sis.studentinfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sis.session.CourseSession;
import sis.session.Session;

public class CourseCatalog {
	private List<Session> sessions = new ArrayList<Session>();
	
	public void add(Session session) {
		sessions.add(session);
	}
	
	public List<Session> getSessions() {
		return sessions;
	}
	
	public void clearAll() {
		sessions.clear();
	}
	
	public void  store(String filename) throws IOException {
		DataOutputStream outputStream = null;
		try {
			outputStream = new DataOutputStream(new FileOutputStream(filename));
			outputStream.writeInt(sessions.size());
			for (Session session:sessions){
				outputStream.writeInt(session.getStartDate().getYear());
				outputStream.writeInt(session.getStartDate().getMonthValue());
				outputStream.writeInt(session.getStartDate().getDayOfMonth());
				outputStream.writeInt(session.getNumberOfCredit());
				outputStream.writeUTF(session.getDepartment());
				outputStream.writeUTF(session.getNumber());
			}
		} finally {
			outputStream.close();
		}
	}
	
	public void load(String filename) throws IOException{
		DataInputStream inputStream = null;
		try{
			inputStream = new DataInputStream(new FileInputStream(filename));
			int numberOfSessions = inputStream.readInt();
			for(int i = 0; i<numberOfSessions; i++){
				LocalDate startDate = LocalDate.of(inputStream.readInt(), inputStream.readInt(), inputStream.readInt());
				int numberOfCredit = inputStream.readInt();
				Course course = new Course(inputStream.readUTF(), inputStream.readUTF());
				Session session = CourseSession.createSession(course, startDate);
				session.setNumberOfCredit(numberOfCredit);
				sessions.add(session);
			}
		}
		finally{
			inputStream.close();
		}
	}
	
	public void  storeByStream(String filename) throws IOException{
		ObjectOutputStream outputStream = null;
		try{
			outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(sessions);
		}
		finally{
			outputStream.close();
		}
	}
	
	public void loadByStream(String filename) throws IOException,ClassNotFoundException {
		ObjectInputStream inputStream = null;
		try{
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			sessions = (List<Session>)inputStream.readObject();
		}
		finally{
			inputStream.close();
		}
	}

}
