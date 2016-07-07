package threads.join;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 13.06.2016.
 */
public class _02ThreadJoin {

    public static void main(String[] args) {
        File folder = new File("D:\\Development\\GitHub\\prof_homework");

        File[] files = folder.listFiles();

        List<Thread> threads = new ArrayList<>();

        List<AsynchFileSearchTask> tasks = new ArrayList<>();

        List<File> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                AsynchFileSearchTask task = new AsynchFileSearchTask(file, "Test");
                Thread thread = new Thread(task);
                threads.add(thread);
                tasks.add(task);
                thread.start();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (AsynchFileSearchTask task : tasks) {
            List<File> result = task.getRes();
            results.addAll(result);
        }

        results.forEach(System.out::println);
        System.out.println(results.size());

    }
}


class AsynchFileSearchTask implements Runnable {

    private File root;
    private String keyWord;
    private List<File> searchResult;

    public AsynchFileSearchTask(File root, String keyWord) {
        this.root = root;
        this.keyWord = keyWord;
        searchResult = new ArrayList<>();
    }

    @Override
    public void run() {
        resSearch(root);
    }

    private void resSearch(File dir) {
        if (dir == null) {
            return;
        }

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                resSearch(file);
            } else if (file.getName().contains(keyWord)) {
                searchResult.add(file);
            }
        }
    }

    public List<File> getRes() {
        return searchResult;
    }

}