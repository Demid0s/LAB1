package first;
import java.io.File;

public class Main {
    public static int x = 1, b = 1;

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator;
        System.out.println("Current working directory in Java : " + path);

        File file[] = new File(path).listFiles();
        listfiles(file, "\t");
    }

    public static void listfiles(File[] f, String sprtr) {
        int k = 1;
        File file[] = f;
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {
                System.out.println(sprtr + "-> " + file[i].getName() + " (folder)"+ k);
                k++;
              listfiles(file[i].listFiles(), sprtr + "\t");
            }
            else {
                System.out.println(sprtr + file[i].getName()+" (file)"+b);
                b++;
                //hello
            }
        }
    }
}	