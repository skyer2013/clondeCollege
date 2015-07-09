import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by u6031313 on 7/9/2015.
 * Content:
 */
public class QuickSort {
    @Test
    public void getInstance(){
        //for test
    }
    private List<Integer> list = new ArrayList<>();

    private void initList(){
        Random random = new Random();
        int scope = 10_000;
        for (int i=0;i< scope;i++){
            int ranInt = random.nextInt(scope);
            list.add(ranInt);
        }
    }
    public QuickSort(){
/*        initList();
        Integer [] a = new Integer[list.size()];

        list.toArray(a);*/
        Aohj.readRrandomFile();
        int[]a =Aohj.A;
        commonQuickSort(a);

    }

    private void commonQuickSort(int[]a) {
        long beginTime =System.currentTimeMillis();
        //QuickSortMain(a, 0, a.length-1);
        Arrays.sort(a,0,a.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("sort file:" + (endTime - beginTime) + "ms");
    }

    private void QuickSortMain(int[] a, int low, int high){
        if(low<high){
            int flag = partition(a,low,high);
            QuickSortMain(a,low,flag-1);
            QuickSortMain(a,flag+1,high);
        }

    }
    private int partition(int[] a,int low ,int high){
        int flag = a[low];
        while (low<high){
            while (low<high && a[high]>=flag){
                high--;
            }
            a[low]=a[high];
            while (low<high && a[low]<=flag){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=flag;
        return low;
    }
}
