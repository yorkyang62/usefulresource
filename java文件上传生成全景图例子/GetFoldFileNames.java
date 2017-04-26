import java.io.File;
import java.util.ArrayList;

public class GetFoldFileNames {

    /**
     * 
     * @author zdz8207
     */
    public static void main(String[] args) {
        getFileName("d:\\music");
    }
    
    public static String getFileName(String path) {
    	ArrayList fileList = new ArrayList();
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [Ŀ¼]");
            } else {
            	fileList.add("\""+fs.getName()+"\"");
                System.out.println(fs.getName());
            }
        }
        return fileList.toString();
    }
}