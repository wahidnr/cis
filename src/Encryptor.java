import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class Encryptor {
	public Encryptor(String src, String key, String tweak, String target)
			throws IOException, NoSuchAlgorithmException, NoSuchPaddingException {
		RandomAccessFile reader = new RandomAccessFile(src, "r");
		RandomAccessFile writer = new RandomAccessFile(target, "rw");
		long fileLength = reader.length();
		long pointer = 0;
		Byte input;
		
		
		while (pointer < fileLength) {
			int pointer_block = 0;
			
			while(pointer_block < 16){
				pointer_block++;
			}
			
			reader.seek(pointer);
			input = reader.readByte();
			
			writer.write(input);
			
			pointer++;
		}
		
		int m = (int) (fileLength / 16);
        int b = (int) (fileLength % 16);
		Thread[] worker = new Thread[100];
        for (int a = 0; a <= m - 2; a++) {
            worker[a % 100] = new Thread(new WorkerThread(0,
                    bufferOut[a], bufferIn[a], key1, key2, a, i));
            worker[a % NUMBER_OF_THREAD].start();
            if (a % NUMBER_OF_THREAD == NUMBER_OF_THREAD - 1) {
                for (int aa = 0; aa < NUMBER_OF_THREAD; aa++) {
                    if (worker[aa] != null) {
                        worker[aa].join(0);
                    }
                }
            }
        }
	}
	
	class WorkerThread implements Runnable {

        /**
         * variabel-variabel yang digunakan
         */
        public static final int MODE_ENCRYPT = 0;
        public static final int MODE_DECRYPT = 1;
        private int mode;
        private byte[] dest;
        private byte[] source;
        private byte[] key1;
        private byte[] key2;
        private int j;
        private byte[] i;

        // Constructor
        public WorkerThread(int mode, byte[] dest, byte[] source, byte[] key1,
                byte[] key2, int j, byte[] i) {
            this.mode = mode;
            this.dest = dest;
            this.source = source;
            this.key1 = key1;
            this.key2 = key2;
            this.j = j;
            this.i = i;
        }

        @Override
        public void run() {
            switch (this.mode) {
                case MODE_ENCRYPT:
                    //perBlockEncrypt(dest, source, key1, key2, j, i);
                    break;
                case MODE_DECRYPT:
                    //perBlockDecrypt(dest, source, key1, key2, j, i);
                    break;
            }
        }
    }
}
