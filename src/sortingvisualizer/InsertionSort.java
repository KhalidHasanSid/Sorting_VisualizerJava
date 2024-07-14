/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualizer;

/**
 *
 * @author khalid hasan
 */
import static sortingvisualizer.SortingVisualizer.paused;
import static sortingvisualizer.SortingVisualizer.sortingThread;

public class InsertionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	
	
	public InsertionSort(Integer[] toBeSorted, VisualizerFrame frame) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;	
	}
	public void run() {
		
			inserttsort();
		
		SortingVisualizer.isSorting=false;
	}
	
	
	
	public void inserttsort() {
		int temp = 0;
		int insert = 0;
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0){
						break;
					}
				}else{
					break;
				}
                                if(paused == true)
                        {
                           
                            synchronized(sortingThread)
                            {
                                // Pause
                                try 
                                {sortingThread.wait();
                                } 
                                catch (InterruptedException e) 
                                {
                                }
                            }
                        }
				frame.reDrawArray(toBeSorted, i, insert);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
		}
		frame.reDrawArray(toBeSorted);
	}
}
