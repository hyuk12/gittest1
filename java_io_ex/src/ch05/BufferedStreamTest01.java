package ch05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest01 {

	public static void main(String[] args) {
		long millisecond = 0;
		try (FileInputStream fis = new FileInputStream("a.zip")) {

			FileOutputStream fos = new FileOutputStream("copy.zip");
			// ���� ��Ʈ�� ��ǲ
			BufferedInputStream bis = new BufferedInputStream(fis);
			// ���� ��Ʈ�� �ƿ�ǲ
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			millisecond = System.currentTimeMillis();

			int i;
//			while((i = fis.read()) != -1) {
//				fos.write(i);
//			}
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			millisecond = System.currentTimeMillis() - millisecond;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���� �����ϴµ� " + millisecond + "�ҿ� �Ǿ����ϴ�.");
	}
}
