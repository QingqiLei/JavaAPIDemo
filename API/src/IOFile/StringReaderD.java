package IOFile;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StringReaderD {
    private static void readString() throws IOException {
        String info = "good good study, day day up 123 123 !";
        StringReader sr = new StringReader(info);
        StreamTokenizer st = new StreamTokenizer(sr);

        int count_word = 0;
        int count_num = 0;
        while (st.ttype != StreamTokenizer.TT_EOF) {
            switch (st.nextToken()) {
                case StreamTokenizer.TT_WORD:
                    count_word++;
                    break;
                case StreamTokenizer.TT_NUMBER:
                    count_num++;
                    break;
            }
        }
        sr.close();
        System.out.println("word "+count_word);
        System.out.println("number "+count_num);
    }


    public static void main(String[] args) throws IOException {
        readString();
    }
}
